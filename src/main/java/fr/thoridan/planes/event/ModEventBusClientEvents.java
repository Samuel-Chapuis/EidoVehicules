package fr.thoridan.planes.event;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import fr.thoridan.planes.entity.client.ModModelLayers;
import fr.thoridan.planes.entity.client.models.YellowPlaneModel;
import fr.thoridan.planes.entity.custom.PlaneStructure;
import fr.thoridan.planes.entity.custom.models.YellowPlane;
import fr.thoridan.planes.item.ModItems;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.*;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.entity.player.Player;
import org.joml.Quaternionf;
import org.joml.Vector3f;

@Mod.EventBusSubscriber(modid = "forplanes", bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModEventBusClientEvents {

    @SubscribeEvent
    public static void onEntityEnterPlane(EntityMountEvent event) {
        if (event.getEntityBeingMounted() instanceof YellowPlane planeEntity) {
            Entity passenger = event.getEntityMounting();
            if (passenger instanceof Player && event.isMounting()) {
                Player player = (Player) passenger;
                System.out.println("Ajustement de la caméra");
                // Logique d'ajustement de la caméra
                adjustCameraDistance();
            }
        }
    }
    private static void adjustCameraDistance() {
        // Logique d'ajustement de la caméra ici, par exemple on peut changer l'angle ou le FOV
    }

    @SubscribeEvent
    public static void onEntityRenderersRegister(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.YELLOW_PLANE, YellowPlaneModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.NORMAL_RAFALE, YellowPlaneModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.RAFALE_GREEN, YellowPlaneModel::createBodyLayer);
    }

    // This event is use to apply custom render to the player in the plane
    @SubscribeEvent
    public static void onRenderPlayerPre(RenderLivingEvent.Pre<?, ?> event) {
        // Ensure the entity being rendered is a Player
        if (event.getEntity() instanceof Player player) {
            Entity entity = player.getRootVehicle();

            // Ensure the vehicle is a PlaneStructure
            if (entity instanceof PlaneStructure plane) {
                // Retrieve plane rotation
                float planeYaw = plane.getYRot();
                float planePitch = plane.getXRot();
                float planeRoll = plane.getInterpolate_roll();

                // Update player's yaw
                player.yBodyRot = planeYaw;
                player.yBodyRotO = planeYaw;

                // Access PoseStack
                PoseStack poseStack = event.getPoseStack();

                // Normalize the look direction (forward vector, local Z-axis)
                Vec3 forward = player.getLookAngle().normalize();

                // Define the global up vector
                Vec3 globalUp = new Vec3(0, 1, 0);

                // Compute the right vector (local X-axis)
                Vec3 right = globalUp.cross(forward).normalize();

                // Handle edge cases where the player looks straight up/down
                if (right.lengthSqr() < 0.0001) {
                    right = new Vec3(1, 0, 0); // Default right vector
                }

                // Compute the local up vector (perpendicular to forward and right, local Y-axis)
                Vec3 localUp = forward.cross(right).normalize();

                // Convert the rotation angles to radians
                float angleXRad = (float) Math.toRadians(planePitch);
                float angleZRad = (float) Math.toRadians(- planeRoll);

                // Shift the rotation point to the middle of the player's body
                double middleHeight = player.getBbHeight() / 2.0; // Half the player's height
                poseStack.translate(0.0, middleHeight, 0.0); // Move up by half the player's height

                // Create a quaternion for the 45° rotation around the local X-axis
                Quaternionf rotationQuaternionX = new Quaternionf().rotateAxis(
                        angleXRad,
                        (float) right.x,
                        (float) right.y,
                        (float) right.z
                );

                // Create a quaternion for the 30° rotation around the local Z-axis
                Quaternionf rotationQuaternionZ = new Quaternionf().rotateAxis(
                        angleZRad,
                        (float) forward.x,
                        (float) forward.y,
                        (float) forward.z
                );

                // Combine the rotations
                Quaternionf combinedQuaternion = new Quaternionf();
                combinedQuaternion.mul(rotationQuaternionZ); // Apply Z rotation first
                combinedQuaternion.mul(rotationQuaternionX); // Then apply X rotation

                // Apply the combined rotation to the PoseStack
                poseStack.mulPose(combinedQuaternion);

                // Translate back to the original position
                poseStack.translate(0.0, -middleHeight, 0.0); // Move back down by the same amount

                // Synchronize body rotation with the head
                player.yBodyRot = player.yHeadRot;
                player.yBodyRotO = player.yHeadRotO;

            }
        }
    }

    // This event is used to apply custom logic to the camera angles
//    @SubscribeEvent
//    public static void onComputeCameraAngles(ViewportEvent.ComputeCameraAngles event) {
//        // Check if the camera’s entity is a Player
//        if (event.getCamera().getEntity() instanceof Player player) {
//            Entity entity = player.getRootVehicle();
//
//            // Ensure the vehicle is a PlaneStructure
//            if (entity instanceof PlaneStructure plane) {
//                float planeRoll = plane.getInterpolate_roll();
//                event.setRoll(event.getRoll() + planeRoll);
//            }
//
//        }
//    }


    /* --------------------- */
    /* --- FOR DEBUGING --- */
    /* -------------------- */




    /**
     * This event is called before the camera angles are computed.
     * It is used to apply custom logic to the camera angles.
     */
//    @SubscribeEvent
//    public static void TestComputeCameraAngles(ViewportEvent.ComputeCameraAngles event) {
//        // Check if the camera’s entity is a Player
//        if (event.getCamera().getEntity() instanceof Player player) {
//            ItemStack heldItem = player.getMainHandItem();
//
//            // Check if the player is holding your debug tool
//            if (heldItem.getItem() == ModItems.DEBUG_TOOL_4PLANE.get()) {
//                // Example rotations:
//                // Add +30 deg to pitch (the up/down angle),
//                // +15 deg to yaw (left/right),
//                // +10 deg to roll (camera tilt).
////                event.setPitch(event.getPitch() + 30.0F);
////                event.setYaw(event.getYaw() + 15.0F);
//                event.setRoll(event.getRoll() + 180.0F);
//            }
//        }
//    }



    @SubscribeEvent
    public static void onRenderLivingPre(RenderLivingEvent.Pre<?, ?> event) {
        // If it's a Player and holding our special item, cancel default rendering
        if (event.getEntity() instanceof Player player) {
            if (isHoldingItem(player, ModItems.DEBUG_TOOL_4PLANE.get())) {
                event.setCanceled(true);

                // Define desired rotations (in degrees)
                float rotX = 0.0F;   // Rotation around X-axis
                float rotY = 0.0F;  // Rotation around Y-axis
                float rotZ = 0.0F;   // Rotation around Z-axis

                // Define desired positions
                double posX = 0.0D;  // Translation along X-axis
                double posY = 0.0D;  // Translation along Y-axis (1.5 + 1.0)
                double posZ = 0.0D;  // Translation along Z-axis

                // Call the custom render method with transformation parameters
                doCustomPlayerRender(player, event, rotX, rotY, rotZ, posX, posY, posZ);
            }
        }
    }

    public static void doCustomPlayerRender(Player player, RenderLivingEvent.Pre<?, ?> event,
                                            float rotX, float rotY, float rotZ,
                                            double posX, double posY, double posZ) {

        event.setCanceled(true);
        // Grab all the info we need from the event
        PoseStack poseStack = event.getPoseStack();
        MultiBufferSource buffer = event.getMultiBufferSource();
        int packedLight = event.getPackedLight();
        float partialTicks = event.getPartialTick();

        // 1) Create or retrieve a PlayerModel to render.
        ModelPart playerModelRoot = Minecraft.getInstance().getEntityModels().bakeLayer(ModelLayers.PLAYER);
        PlayerModel<Player> playerModel = new PlayerModel<>(playerModelRoot, false); // false => normal (non-slim) arms

        // 2) Push a new matrix
        poseStack.pushPose();

        // 3) Apply scaling to correct the model size
        float scaleFactor = 1.0F; // Adjust as necessary
        poseStack.scale(scaleFactor, scaleFactor, scaleFactor);

        // 4) Apply fixed rotation to correct the upside-down rendering
        // Rotate 180 degrees around the X-axis to flip the model upright
        poseStack.mulPose(Axis.XP.rotationDegrees(180.0F));
        poseStack.translate(0.0D, - 1.5D, 0.0D); // Adjust the model position to align with the ground

        // 5) Apply position transformations
        poseStack.translate(posX, posY, posZ); // Translate model

        // If additional rotation is needed based on player orientation, apply it here
        // For example, to rotate the player based on their yaw:
        poseStack.mulPose(Axis.YP.rotationDegrees(player.getYRot()));

        // 6) Set up model animations
        float ageInTicks = player.tickCount + partialTicks;
        float limbSwingAmount = 0.0F; // for demonstration, set 0 or compute from speed
        float limbSwing = 0.0F;        // likewise

        // Option 1: Set fixed head rotation
        playerModel.setupAnim(player, limbSwing, limbSwingAmount, ageInTicks,
                0.0F, // netHeadYaw
                0.0F  // headPitch
        );

        // 7) Render the model
        VertexConsumer vertexconsumer = buffer.getBuffer(playerModel.renderType(getPlayerTexture(player)));
        playerModel.renderToBuffer(
                poseStack,
                vertexconsumer,
                packedLight,
                OverlayTexture.NO_OVERLAY,
                1.0F, 1.0F, 1.0F, 1.0F
        );

        // 8) Pop the matrix
        poseStack.popPose();
    }

    /**
     * Retrieves the player's skin texture. Falls back to Steve's skin if unavailable.
     */
    private static ResourceLocation getPlayerTexture(Player player) {
        if (player instanceof AbstractClientPlayer clientPlayer) {
            return clientPlayer.getSkinTextureLocation();
        }
        // Fallback texture
        return new ResourceLocation("textures/entity/steve.png");
    }

    private static boolean isHoldingItem(Player player, Item item) {
        return player.getMainHandItem().getItem() == item ||
                player.getOffhandItem().getItem() == item;
    }
}