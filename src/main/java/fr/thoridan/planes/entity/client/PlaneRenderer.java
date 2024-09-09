package fr.thoridan.planes.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import fr.thoridan.planes.entity.custom.PlaneStructure;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;

public abstract class PlaneRenderer<T extends PlaneStructure> extends EntityRenderer<T> {

    public PlaneRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return getPlaneTexture(entity);
    }

    protected abstract ResourceLocation getPlaneTexture(T entity);

    protected abstract EntityModel<T> getPlaneModel(T entity);

    protected abstract void renderSettings(PoseStack poseStack);
    @Override
    public void render(T plane, float entityYaw, float partialTicks, PoseStack poseStack,
                       net.minecraft.client.renderer.MultiBufferSource buffer, int packedLight) {

        poseStack.pushPose();
        renderSettings(poseStack);
        poseStack.mulPose(Axis.XP.rotationDegrees(180.0F));

        float interpolatedYaw = interpolateAngle(plane.yRotO, plane.getYRot(), partialTicks);
        poseStack.mulPose(Axis.YP.rotationDegrees(interpolatedYaw));

        double speedSquared = plane.getDeltaMovement().horizontalDistanceSqr();
        double minSpeedSquared = 0.03;
        float interpolatedPitch = 0;
        if (speedSquared > minSpeedSquared) {
            interpolatedPitch = interpolateAngle(plane.xRotO, plane.getXRot(), partialTicks);
            poseStack.mulPose(Axis.XP.rotationDegrees(interpolatedPitch));
        }

        float interpolatedRoll = interpolateAngle(plane.getPreviousRoll(), plane.getRoll(), partialTicks);
        interpolatedRoll = Math.max(-180.0F, Math.min(180.0F, interpolatedRoll));
        poseStack.mulPose(Axis.ZP.rotationDegrees(interpolatedRoll));




        // Determine particle position based on the plane's rotation
        double particleXOffset = -Math.sin(Math.toRadians(interpolatedYaw)) * Math.cos(Math.toRadians(interpolatedPitch));
        double particleYOffset = -Math.sin(Math.toRadians(interpolatedPitch));
        double particleZOffset = Math.cos(Math.toRadians(interpolatedYaw)) * Math.cos(Math.toRadians(interpolatedPitch));

        // Adjust the offset to be behind and above the plane
        double distanceBehindPlane = -10.0; // Adjust as needed for behind-plane distance
        double heightOffset = 1.5;        // Adjust as needed for height
        double particleX = plane.getX() + particleXOffset * distanceBehindPlane;
        double particleY = plane.getY() + particleYOffset * distanceBehindPlane + heightOffset;
        double particleZ = plane.getZ() + particleZOffset * distanceBehindPlane;

        // Spawn particle
        for (int i = 0; i < 5; i++){
            double randX = Math.random() * 0.4 - 0.2;
            double randY = Math.random() * 0.4 - 0.2;
            double randZ = Math.random() * 0.4 - 0.2;
            plane.level().addParticle(ParticleTypes.FLAME, true, particleX + randX, particleY + randY, particleZ + randZ, 0, 0, 0);
        }




        EntityModel<T> model = getPlaneModel(plane); // Récupère le modèle spécifique à l'avion
        model.setupAnim(plane, 0.0F, 0.0F, plane.tickCount + partialTicks, entityYaw, plane.getXRot());

        var vertexConsumer = buffer.getBuffer(model.renderType(this.getTextureLocation(plane)));
        model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

        super.render(plane, entityYaw, partialTicks, poseStack, buffer, packedLight);
        poseStack.popPose();
    }

    private float interpolateAngle(float startAngle, float endAngle, float partialTicks) {
        float deltaAngle = endAngle - startAngle;
        while (deltaAngle < -180.0F) {
            deltaAngle += 360.0F;
        }
        while (deltaAngle >= 180.0F) {
            deltaAngle -= 360.0F;
        }
        return startAngle + partialTicks * deltaAngle;
    }
}