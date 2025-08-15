package fr.Eidolyth.event.vehicule;

import fr.Eidolyth.entity.ModModelLayers;
import fr.Eidolyth.entity.vehicule.plane.PlaneStructure;
import fr.Eidolyth.entity.vehicule.plane.declaration.models.tourist.ToursiticPlane;
import fr.Eidolyth.entity.vehicule.plane.render.models.tourist.ToursiticPlaneModel;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static fr.Eidolyth.event.vehicule.VehiculeLogicUtility.doCustomPlayerRender;
import static fr.Eidolyth.event.vehicule.VehiculeLogicUtility.interpolateAngle;

@Mod.EventBusSubscriber(modid = "eidomod", bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class VehiculeEvent {


    /**
     * Called when an entity mounts or dismounts another entity.
     * Specifically handles adjustments when a player mounts a YellowPlane.
     *
     * @param event The EntityMountEvent containing information about the mounting action.
     */
    @SubscribeEvent
    public static void onEntityEnterPlane(EntityMountEvent event) {
        // Check if the entity being mounted is a YellowPlane
        if (event.getEntityBeingMounted() instanceof ToursiticPlane planeEntity) {
            // Get the entity that is mounting (e.g., a player)
            Entity passenger = event.getEntityMounting();
            // Ensure the passenger is a player and the action is mounting (not dismounting)
            if (passenger instanceof Player && event.isMounting()) {
                Player player = (Player) passenger;
                System.out.println("Adjusting camera for player mounting the plane.");
                // Invoke method to adjust camera distance based on plane's properties
                adjustCameraDistance();
            }
        }
    }

    @SubscribeEvent
    public static void onEntityMount(EntityMountEvent event) {
        // On ne s’intéresse qu’au player
        if (event.getEntityMounting() != Minecraft.getInstance().player) return;
        // Vérifie que c’est bien votre entité avion
        if (!(event.getEntityBeingMounted() instanceof PlaneStructure)) return;

        // Si c’est un montage
        if (!event.isDismounting()) {
            Minecraft mc = Minecraft.getInstance();
            mc.options.setCameraType(CameraType.THIRD_PERSON_BACK);
        }
        // Si c’est un démontage
        else {
            Minecraft mc = Minecraft.getInstance();
            mc.options.setCameraType(CameraType.FIRST_PERSON);
        }
    }


    /**
     * Adjusts the camera distance when a player mounts a plane.
     * This method can be expanded to modify the camera's position, angle, or field of view.
     */
    private static void adjustCameraDistance() {
        // Camera adjustment logic goes here
        // Example: Change the camera angle or field of view based on the plane's characteristics
    }

    /**
     * Registers layer definitions for custom entity models.
     * This method is called during the model registration phase to associate model layers with their respective models.
     *
     * @param event The RegisterLayerDefinitions event used to register model layers.
     */
    @SubscribeEvent
    public static void onEntityRenderersRegister(EntityRenderersEvent.RegisterLayerDefinitions event) {
        // Register layer definition for the Yellow Plane model
        event.registerLayerDefinition(ModModelLayers.YELLOW_PLANE, ToursiticPlaneModel::createBodyLayer);
        // Register layer definitions for Rafale plane variants
        event.registerLayerDefinition(ModModelLayers.NORMAL_RAFALE, ToursiticPlaneModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.RAFALE_GREEN, ToursiticPlaneModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.A220LAYER, ToursiticPlaneModel::createBodyLayer);
    }

    /**
     * Applies custom rendering to the player when they are inside a plane.
     * Cancels the default rendering and applies transformations to position and rotate the player model correctly.
     *
     * @param event The Pre render event containing rendering information.
     */
    @SubscribeEvent
    public static void onRenderPlayerPre(RenderLivingEvent.Pre<?, ?> event) {
        // Ensure the entity being rendered is a Player
        if (event.getEntity() instanceof Player player) {
            // Get the root vehicle the player is in (e.g., the plane)
            Entity entity = player.getRootVehicle();

            // Check if the vehicle is an instance of PlaneStructure
            if (entity instanceof PlaneStructure plane) {
                // Cancel the default player rendering
                event.setCanceled(true);

                // Retrieve partial tick time for smooth animations
                float partialTicks = event.getPartialTick();
                // Interpolate the plane's roll angle for smooth rotation
                float interpolatedRoll = plane.getInterpolate_roll();
                interpolatedRoll = Math.max(-180.0F, Math.min(180.0F, interpolatedRoll));
                // Interpolate yaw and pitch angles based on previous and current rotations
                float interpolatedYaw = interpolateAngle(plane.yRotO, plane.getYRot(), partialTicks);
                float interpolatedPitch = plane.getInterpolate_pitch();

                // Define rotation angles for the player model
                float rotX = interpolatedPitch; // Rotation around X-axis (pitch)
                float rotY = interpolatedYaw;   // Rotation around Y-axis (yaw)
                float rotZ = interpolatedRoll;  // Rotation around Z-axis (roll)

                // Define positional offsets for rendering the player model
                double posX = 0.0D; // Translation along X-axis
                double posY = 0.5D; // Translation along Y-axis
                double posZ = 0.0D; // Translation along Z-axis

                // Invoke custom rendering method with transformation parameters
                doCustomPlayerRender(player, event, rotX, rotY, rotZ, posX, posY, posZ, plane.yRiderOffset);
            }
        }
    }

    /**
     * Modifies the camera angles based on the plane's roll.
     * This method is called during the camera angle computation phase to apply custom rotations.
     *
     * @param event The ComputeCameraAngles event containing camera angle data.
     */
    @SubscribeEvent
    public static void onComputeCameraAngles(ViewportEvent.ComputeCameraAngles event) {
        // Check if the camera’s entity is a Player
        if (event.getCamera().getEntity() instanceof Player player) {
            // Get the root vehicle the player is in (e.g., the plane)
            Entity entity = player.getRootVehicle();

            // Ensure the vehicle is an instance of PlaneStructure
            if (entity instanceof PlaneStructure plane) {
                // Retrieve the plane's interpolated roll angle
                float planeRoll = plane.getInterpolate_roll();
                // Apply the plane's roll to the camera's roll
                event.setRoll(event.getRoll() + planeRoll);
            }
        }
    }    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        
        if (player != null && player.getVehicle() instanceof PlaneStructure) {
            // Force la vue en troisième personne si le joueur essaie de la changer
            if (mc.options.getCameraType() != CameraType.THIRD_PERSON_BACK) {
                mc.options.setCameraType(CameraType.THIRD_PERSON_BACK);
            }
        }
    }

}
