package fr.thoridan.planes.event;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import fr.thoridan.planes.Globals;
import fr.thoridan.planes.entity.client.ModModelLayers;
import fr.thoridan.planes.entity.client.models.tourist.YellowPlaneModel;
import fr.thoridan.planes.entity.custom.PlaneStructure;
import fr.thoridan.planes.entity.custom.models.tourist.YellowPlane;
import fr.thoridan.planes.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.*;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.entity.player.Player;

/**
 * Handles client-side events for the ForPlanes mod.
 * This class listens to various Forge events to manage custom rendering and camera adjustments
 * when players interact with plane entities.
 */
@Mod.EventBusSubscriber(modid = "forplanes", bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModEventBusClientEvents {

    /**
     * Called when an entity mounts or dismounts another entity.
     * Specifically handles adjustments when a player mounts a YellowPlane.
     *
     * @param event The EntityMountEvent containing information about the mounting action.
     */
    @SubscribeEvent
    public static void onEntityEnterPlane(EntityMountEvent event) {
        // Check if the entity being mounted is a YellowPlane
        if (event.getEntityBeingMounted() instanceof YellowPlane planeEntity) {
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
        event.registerLayerDefinition(ModModelLayers.YELLOW_PLANE, YellowPlaneModel::createBodyLayer);
        // Register layer definitions for Rafale plane variants
        event.registerLayerDefinition(ModModelLayers.NORMAL_RAFALE, YellowPlaneModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.RAFALE_GREEN, YellowPlaneModel::createBodyLayer);
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
                float interpolatedPitch = interpolateAngle(plane.xRotO, plane.getXRot(), partialTicks);
                System.out.println("Interpolated Pitch: " + interpolatedPitch);

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
    }

    /* --------------------- */
    /* --- FOR DEBUGGING --- */
    /* --------------------- */

    /**
     * Applies custom rendering logic before the living entity (player) is rendered.
     * If the player is holding the Debug Tool for Plane, it cancels the default rendering
     * and applies custom transformations.
     *
     * @param event The Pre render event containing rendering information.
     */
    @SubscribeEvent
    public static void onRenderLivingPre(RenderLivingEvent.Pre<?, ?> event) {
        // Check if the entity being rendered is a Player
        if (event.getEntity() instanceof Player player) {
            // Check if the player is holding the Debug Tool for Plane in either hand
            if (isHoldingItem(player, ModItems.DEBUG_TOOL_4PLANE.get())) {
                // Cancel the default rendering of the player model
                event.setCanceled(true);

                // Define desired rotation angles (in degrees) from global variables
                float rotX = Globals.global1;   // Rotation around X-axis
                float rotY = Globals.global2;   // Rotation around Y-axis
                float rotZ = Globals.global3;   // Rotation around Z-axis

                // Define positional offsets for rendering the player model
                double posX = 0.0D; // Translation along X-axis
                double posY = 0.0D; // Translation along Y-axis
                double posZ = 0.0D; // Translation along Z-axis

                // Invoke custom rendering method with transformation parameters
                doCustomPlayerRender(player, event, rotX, rotY, rotZ, posX, posY, posZ, 0);
            }
        }
    }

    /* --------------------- */
    /* --- Utility Methods -- */
    /* --------------------- */

    /**
     * Renders the player model with custom transformations.
     * This method applies scaling, translation, and rotation to position the player model correctly
     * within the plane and handles the rendering of different body parts.
     *
     * @param player    The player entity to render.
     * @param event     The Pre render event containing rendering information.
     * @param rotX      Rotation around the X-axis (pitch).
     * @param rotY      Rotation around the Y-axis (yaw).
     * @param rotZ      Rotation around the Z-axis (roll).
     * @param posX      Translation along the X-axis.
     * @param posY      Translation along the Y-axis.
     * @param posZ      Translation along the Z-axis.
     * @param Yoffset   Additional Y-axis offset for rendering.
     */
    public static void doCustomPlayerRender(Player player, RenderLivingEvent.Pre<?, ?> event,
                                            float rotX, float rotY, float rotZ,
                                            double posX, double posY, double posZ, double Yoffset) {

        // Retrieve necessary rendering information from the event
        PoseStack poseStack = event.getPoseStack();
        MultiBufferSource buffer = event.getMultiBufferSource();
        int packedLight = event.getPackedLight();
        float partialTicks = event.getPartialTick();

        // Adjust rotation around the X-axis
        rotX = (rotX + 180) % 360;

        // Create or retrieve a PlayerModel instance for rendering
        ModelPart playerModelRoot = Minecraft.getInstance().getEntityModels().bakeLayer(ModelLayers.PLAYER);
        PlayerModel<Player> playerModel = new PlayerModel<>(playerModelRoot, false); // 'false' for normal arms

        // Push a new matrix stack to isolate transformations
        poseStack.pushPose();

        // Apply scaling to the player model's body
        float bodyScale = 0.8F; // Adjust this value as needed for the body size
        poseStack.scale(bodyScale, bodyScale, bodyScale);

        // Apply positional transformations to place the player model correctly
        poseStack.translate(posX, posY, posZ); // Translate model to desired position

        // === Adjusting the Pivot Point ===

        // Define a custom pivot point relative to the player's origin
        double pivotX = 0.0D; // Adjust these values as needed
        double pivotY = 0.4D + Yoffset; // Adjust Y-offset as needed (e.g., 0.7 for Rafale)
        double pivotZ = 0.0D;

        // Translate to the pivot point
        poseStack.translate(pivotX, pivotY, pivotZ);

        // Apply rotation transformations around the new pivot point
        poseStack.mulPose(Axis.YP.rotationDegrees(-rotY)); // Rotate around Y-axis (yaw)
        poseStack.mulPose(Axis.ZP.rotationDegrees(-rotZ)); // Rotate around Z-axis (roll)
        poseStack.mulPose(Axis.XP.rotationDegrees(rotX));  // Rotate around X-axis (pitch)

        // Translate back from the pivot point
        poseStack.translate(-pivotX, -pivotY, -pivotZ);

        // === End of Pivot Point Adjustment ===

        // Set up the player model's sitting pose and animations
        setupSittingPose(playerModel, player, partialTicks);

        // Render the player's body parts (excluding the head)
        // Render the torso
        playerModel.body.render(poseStack, buffer.getBuffer(playerModel.renderType(getPlayerTexture(player))), packedLight, OverlayTexture.NO_OVERLAY);

        // Render the legs
        playerModel.leftLeg.render(poseStack, buffer.getBuffer(playerModel.renderType(getPlayerTexture(player))), packedLight, OverlayTexture.NO_OVERLAY);
        playerModel.rightLeg.render(poseStack, buffer.getBuffer(playerModel.renderType(getPlayerTexture(player))), packedLight, OverlayTexture.NO_OVERLAY);

        // Apply scaling to the arms and render them
        float armScale = 0.8F; // Adjust this value as needed for the arms
        poseStack.pushPose();
        poseStack.scale(armScale, armScale, armScale);
        playerModel.leftArm.render(poseStack, buffer.getBuffer(playerModel.renderType(getPlayerTexture(player))), packedLight, OverlayTexture.NO_OVERLAY);
        playerModel.rightArm.render(poseStack, buffer.getBuffer(playerModel.renderType(getPlayerTexture(player))), packedLight, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();

        // Render the head with adjusted scaling
        poseStack.pushPose(); // Push a new matrix for the head
        float headScale = 0.9F; // Define head scaling factor (less than 1 to make it smaller)
        poseStack.scale(headScale, headScale, headScale); // Apply scaling to the head
        // Optional: Adjust the head's position if it appears offset after scaling
        // poseStack.translate(0.0D, 0.1D, 0.0D); // Modify values as needed
        playerModel.head.render(poseStack, buffer.getBuffer(playerModel.renderType(getPlayerTexture(player))), packedLight, OverlayTexture.NO_OVERLAY);
        poseStack.popPose(); // Pop the head's transformation matrix

        // Pop the main matrix stack to revert to previous transformations
        poseStack.popPose();
    }

    /**
     * Sets up the sitting pose for the player model.
     * This includes adjusting the legs and arms to mimic a sitting position.
     *
     * @param playerModel The PlayerModel instance to modify.
     * @param player      The player entity being rendered.
     * @param partialTicks Partial tick time for smooth animations.
     */
    private static void setupSittingPose(PlayerModel<Player> playerModel, Player player, float partialTicks) {
        // Calculate ageInTicks if needed for animations (e.g., idle movements)
        float ageInTicks = player.tickCount + partialTicks;

        // Set up model animations based on the player's state
        playerModel.setupAnim(player, 0.0F, 0.0F, ageInTicks, 0.0F, 0.0F);

        // Adjust legs to simulate a sitting position by rotating them forward
        float legRotation = -90.0F; // Rotate legs 90 degrees around the X-axis
        playerModel.leftLeg.xRot = (float) Math.toRadians(legRotation);
        playerModel.rightLeg.xRot = (float) Math.toRadians(legRotation);

        // Optionally, bend the knees slightly for a more natural sitting pose
        playerModel.leftLeg.zRot = (float) Math.toRadians(10.0F);   // Bend left knee
        playerModel.rightLeg.zRot = (float) Math.toRadians(-10.0F); // Bend right knee

        // Adjust arms to a relaxed position, such as resting on the lap
        float armRotationX = -45.0F; // Rotate arms downward by 45 degrees
        playerModel.leftArm.xRot = (float) Math.toRadians(armRotationX);
        playerModel.rightArm.xRot = (float) Math.toRadians(armRotationX);

        // Optionally, rotate arms slightly inward for a more natural pose
        playerModel.leftArm.zRot = (float) Math.toRadians(-10.0F); // Rotate left arm inward
        playerModel.rightArm.zRot = (float) Math.toRadians(10.0F); // Rotate right arm inward
    }

    /**
     * Retrieves the player's skin texture. Falls back to the default Steve skin if unavailable.
     *
     * @param player The player entity whose skin texture is to be retrieved.
     * @return The ResourceLocation of the player's skin texture.
     */
    private static ResourceLocation getPlayerTexture(Player player) {
        if (player instanceof AbstractClientPlayer clientPlayer) {
            return clientPlayer.getSkinTextureLocation();
        }
        // Fallback texture if the player's skin is not available
        return new ResourceLocation("textures/entity/steve.png");
    }

    /**
     * Checks if the player is holding a specific item in either their main hand or offhand.
     *
     * @param player The player entity to check.
     * @param item   The item to verify if the player is holding.
     * @return True if the player is holding the specified item, false otherwise.
     */
    private static boolean isHoldingItem(Player player, Item item) {
        return player.getMainHandItem().getItem() == item ||
                player.getOffhandItem().getItem() == item;
    }

    /**
     * Interpolates between two angles to ensure smooth transitions, accounting for angle wrapping.
     *
     * @param startAngle   The starting angle in degrees.
     * @param endAngle     The ending angle in degrees.
     * @param partialTicks The partial tick time for interpolation.
     * @return The interpolated angle in degrees.
     */
    private static float interpolateAngle(float startAngle, float endAngle, float partialTicks) {
        float deltaAngle = endAngle - startAngle;
        // Adjust deltaAngle to be within the range [-180, 180] degrees
        while (deltaAngle < -180.0F) {
            deltaAngle += 360.0F;
        }
        while (deltaAngle >= 180.0F) {
            deltaAngle -= 360.0F;
        }
        // Return the interpolated angle
        return startAngle + partialTicks * deltaAngle;
    }
}
