package fr.Eidolyth.event.vehicule;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import fr.Eidolyth.entity.vehicule.plane.PlaneStructure;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.RenderLivingEvent;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraftforge.client.event.InputEvent.Key;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.lwjgl.glfw.GLFW;

public class VehiculeLogicUtility {

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
     * Interpolates between two angles to ensure smooth transitions, accounting for angle wrapping.
     *
     * @param startAngle   The starting angle in degrees.
     * @param endAngle     The ending angle in degrees.
     * @param partialTicks The partial tick time for interpolation.
     * @return The interpolated angle in degrees.
     */
    public static float interpolateAngle(float startAngle, float endAngle, float partialTicks) {
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
     * @param posZ      Translation along the Z-axis..
     *
     *
     */
    public static void doCustomPlayerRender(Player player, RenderLivingEvent.Pre<?, ?> event,
                                            float rotX, float rotY, float rotZ,
                                            double posX, double posY, double posZ,
                                            double riderYOffset) {
        rotX = (rotX + 180) % 360;
        PoseStack poseStack = event.getPoseStack();
        MultiBufferSource buffer = event.getMultiBufferSource();
        int packedLight = event.getPackedLight();
        float partialTicks = event.getPartialTick();

        // Create or retrieve a PlayerModel instance for rendering
        ModelPart playerModelRoot = Minecraft.getInstance().getEntityModels().bakeLayer(ModelLayers.PLAYER);
        PlayerModel<Player> playerModel = new PlayerModel<>(playerModelRoot, false); // false for normal arms

        poseStack.pushPose();

        // Apply overall scaling
        float bodyScale = 0.8F;
        poseStack.scale(bodyScale, bodyScale, bodyScale);

        // Initial translation to position the model relative to the plane's origin
        poseStack.translate(posX, posY, posZ);

        // Combine the rider's offset and the plane's offset into one effective Y offset.
        double effectiveYOffset = riderYOffset;

        // --- Adjusting the Pivot Point for Rotations ---
        // You can choose a base pivot (here 0.4) that suits your model’s natural center.
        double pivotX = 0.0D;
        double basePivotY = 0.4D;
        double pivotY = basePivotY + effectiveYOffset;
        double pivotZ = 0.0D;

        // Move to the pivot point that now includes your Y offset.
        poseStack.translate(pivotX, pivotY, pivotZ);

        // Apply rotations (yaw, roll, pitch) around the new pivot.
        poseStack.mulPose(Axis.YP.rotationDegrees(-rotY));
        poseStack.mulPose(Axis.ZP.rotationDegrees(-rotZ));
        poseStack.mulPose(Axis.XP.rotationDegrees(rotX));

        // Move back from the pivot point.
        poseStack.translate(-pivotX, -pivotY, -pivotZ);
        // --- End Pivot Adjustment ---

        // Set up the sitting pose and animations for the player model.
        setupSittingPose(playerModel, player, partialTicks);

        // Render body parts
        playerModel.body.render(poseStack, buffer.getBuffer(playerModel.renderType(getPlayerTexture(player))), packedLight, OverlayTexture.NO_OVERLAY);
        playerModel.leftLeg.render(poseStack, buffer.getBuffer(playerModel.renderType(getPlayerTexture(player))), packedLight, OverlayTexture.NO_OVERLAY);
        playerModel.rightLeg.render(poseStack, buffer.getBuffer(playerModel.renderType(getPlayerTexture(player))), packedLight, OverlayTexture.NO_OVERLAY);

        // Render arms (with additional scaling)
        float armScale = 0.8F;
        poseStack.pushPose();
        poseStack.scale(armScale, armScale, armScale);
        playerModel.leftArm.render(poseStack, buffer.getBuffer(playerModel.renderType(getPlayerTexture(player))), packedLight, OverlayTexture.NO_OVERLAY);
        playerModel.rightArm.render(poseStack, buffer.getBuffer(playerModel.renderType(getPlayerTexture(player))), packedLight, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();

        // Render head (with adjusted scaling)
        poseStack.pushPose();
        float headScale = 0.9F;
        poseStack.scale(headScale, headScale, headScale);
        playerModel.head.render(poseStack, buffer.getBuffer(playerModel.renderType(getPlayerTexture(player))), packedLight, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();

        poseStack.popPose();
    }

    /** Passe automatiquement en 3e personne à l’embarquement, et inverse au débarquement. */
    @SubscribeEvent
    public static void onEntityMount(EntityMountEvent event) {
        if (event.getEntityMounting() != Minecraft.getInstance().player) return;
        if (!(event.getEntityBeingMounted() instanceof PlaneStructure)) return;

        Minecraft mc = Minecraft.getInstance();
        if (!event.isDismounting()) {
            mc.options.setCameraType(CameraType.THIRD_PERSON_BACK);
        } else {
            mc.options.setCameraType(CameraType.FIRST_PERSON);
        }
    }

}
