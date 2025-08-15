package fr.Eidolyth.entity.vehicule.plane;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

/**
 * Abstract renderer for planes in the ForPlanes mod.
 * This class handles rendering logic for plane entities, including transformations and texture management.
 *
 * @param <T> The specific type of {@link PlaneStructure} this renderer supports.
 */
public abstract class PlaneRenderer<T extends PlaneStructure> extends EntityRenderer<T> {

    /**
     * Constructs a new PlaneRenderer.
     *
     * @param context The rendering context provided by Minecraft.
     */
    public PlaneRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    /* --------------------- */
    /* --- Abstract Methods --- */
    /* --------------------- */

    /**
     * Retrieves the texture location for the specific plane entity.
     *
     * @param plane The plane entity instance.
     * @return A {@link ResourceLocation} pointing to the texture.
     */
    protected abstract ResourceLocation getPlaneTexture(T plane);

    /**
     * Retrieves the model for the specific plane entity.
     *
     * @param plane The plane entity instance.
     * @return An {@link EntityModel} corresponding to the plane.
     */
    protected abstract EntityModel<T> getPlaneModel(T plane);

    /**
     * Applies custom rendering transformations.
     *
     * @param poseStack The {@link PoseStack} used for transformations.
     */
    protected abstract void renderSettings(PoseStack poseStack);

    /* --------------------- */
    /* --- Overridden Methods --- */
    /* --------------------- */

    /**
     * Retrieves the texture location for the given plane entity.
     *
     * @param plane The plane entity instance.
     * @return A {@link ResourceLocation} pointing to the texture.
     */
    @Override
    public ResourceLocation getTextureLocation(T plane) {
        return getPlaneTexture(plane);
    }

    /**
     * Renders the plane entity, applying transformations for yaw, pitch, and roll,
     * and handles model rendering with the associated texture.
     *
     * @param plane        The plane entity instance.
     * @param entityYaw    The entity's yaw rotation.
     * @param partialTicks The partial ticks for interpolation.
     * @param poseStack    The {@link PoseStack} for rendering transformations.
     * @param buffer       The buffer source for rendering.
     * @param packedLight  The packed lightmap coordinates.
     */
    @Override
    public void render(T plane, float entityYaw, float partialTicks, PoseStack poseStack,
                       net.minecraft.client.renderer.MultiBufferSource buffer, int packedLight) {

        poseStack.pushPose(); // Start a new transformation matrix
        renderSettings(poseStack); // Apply custom rendering transformations
        poseStack.mulPose(Axis.XP.rotationDegrees(180.0F)); // Rotate the plane to face the correct direction

        // Interpolate and apply yaw rotation
        float interpolatedYaw = interpolateAngle(plane.yRotO, plane.getYRot(), partialTicks);
        poseStack.mulPose(Axis.YP.rotationDegrees(interpolatedYaw));

        // Apply pitch rotation only if the plane is moving
        double speedSquared = plane.getDeltaMovement().horizontalDistanceSqr();
        double minSpeedSquared = 0.03; // Threshold for movement
        if (speedSquared > minSpeedSquared) {
            float interpolatedPitch = interpolateAngle(plane.xRotO, plane.getXRot(), partialTicks);
            plane.setInterpolate_pitch(interpolatedPitch); // Update interpolated pitch in the plane entity
            poseStack.mulPose(Axis.XP.rotationDegrees(interpolatedPitch));
        }

        // Interpolate and apply roll rotation
        float interpolatedRoll = interpolateAngle(plane.getPreviousRoll(), plane.getRoll(), partialTicks);
        plane.setInterpolate_roll(interpolatedRoll); // Update interpolated roll in the plane entity
        interpolatedRoll = Math.max(-180.0F, Math.min(180.0F, interpolatedRoll)); // Clamp roll angle
        poseStack.mulPose(Axis.ZP.rotationDegrees(interpolatedRoll));

        // Setup and render the model
        EntityModel<T> model = getPlaneModel(plane); // Retrieve the specific model for this plane
        model.setupAnim(plane, 0.0F, 0.0F, plane.tickCount + partialTicks, entityYaw, plane.getXRot());

        var vertexConsumer = buffer.getBuffer(model.renderType(this.getTextureLocation(plane)));
        model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

        super.render(plane, entityYaw, partialTicks, poseStack, buffer, packedLight); // Call superclass render method
        render_addition(poseStack, buffer, packedLight, plane);
        poseStack.popPose(); // Restore the transformation matrix


//        // Determine particle position based on the plane's rotation
//        double particleXOffset = -Math.sin(Math.toRadians(interpolatedYaw)) * Math.cos(Math.toRadians(interpolatedPitch));
//        double particleYOffset = -Math.sin(Math.toRadians(interpolatedPitch));
//        double particleZOffset = Math.cos(Math.toRadians(interpolatedYaw)) * Math.cos(Math.toRadians(interpolatedPitch));
//
//        // Adjust the offset to be behind and above the plane
//        double distanceBehindPlane = -10.0; // Adjust as needed for behind-plane distance
//        double heightOffset = 1.5;        // Adjust as needed for height
//        double particleX = plane.getX() + particleXOffset * distanceBehindPlane;
//        double particleY = plane.getY() + particleYOffset * distanceBehindPlane + heightOffset;
//        double particleZ = plane.getZ() + particleZOffset * distanceBehindPlane;
//
//        // Spawn particle
//        for (int i = 0; i < 5; i++){
//            double randX = Math.random() * 0.4 - 0.2;
//            double randY = Math.random() * 0.4 - 0.2;
//            double randZ = Math.random() * 0.4 - 0.2;
//            plane.level().addParticle(ParticleTypes.FLAME, true, particleX + randX, particleY + randY, particleZ + randZ, 0, 0, 0);
//        }
    }

    /**
     * Interpolates between two angles to create smooth transitions.
     *
     * @param startAngle  The starting angle.
     * @param endAngle    The target angle.
     * @param partialTicks The partial ticks for interpolation.
     * @return The interpolated angle.
     */
    private float interpolateAngle(float startAngle, float endAngle, float partialTicks) {
        float deltaAngle = endAngle - startAngle;
        while (deltaAngle < -180.0F) {
            deltaAngle += 360.0F; // Adjust for 360° wrapping
        }
        while (deltaAngle >= 180.0F) {
            deltaAngle -= 360.0F; // Adjust for 360° wrapping
        }
        return startAngle + partialTicks * deltaAngle; // Smoothly interpolate between angles
    }

    /* --------------------- */
    /* --- Example Resources --- */
    /* --------------------- */

    /**
     * Retrieves the default texture resource location for planes.
     *
     * @return A {@link ResourceLocation} pointing to the default plane texture.
     */
    public ResourceLocation getResourceLocation() {
        return new ResourceLocation("eidovehicules", "textures/entity/yellow_plane.png");
    }

    abstract protected void render_addition(PoseStack poseStack, MultiBufferSource buffer, int packedLight, PlaneStructure planeStructure);
}
