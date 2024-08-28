package fr.thoridan.planes.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import fr.thoridan.planes.entity.custom.PlaneStructure;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
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

    protected abstract EntityModel<T> getPlaneModel(T entity);  // Utilisez EntityModel ou votre superclasse de modèle

    @Override
    public void render(T plane, float entityYaw, float partialTicks, PoseStack poseStack,
                       net.minecraft.client.renderer.MultiBufferSource buffer, int packedLight) {

        poseStack.pushPose();

        poseStack.translate(0.0D, 1.5D, 0.0D);
        poseStack.mulPose(Axis.XP.rotationDegrees(180.0F));

        float interpolatedYaw = interpolateAngle(plane.yRotO, plane.getYRot(), partialTicks);
        poseStack.mulPose(Axis.YP.rotationDegrees(interpolatedYaw));

        double speedSquared = plane.getDeltaMovement().horizontalDistanceSqr();
        double minSpeedSquared = 0.03;
        if (speedSquared > minSpeedSquared) {
            float interpolatedPitch = interpolateAngle(plane.xRotO, plane.getXRot(), partialTicks);
            poseStack.mulPose(Axis.XP.rotationDegrees(interpolatedPitch));
        }

        float interpolatedRoll = interpolateAngle(plane.getPreviousRoll(), plane.getRoll(), partialTicks);
        interpolatedRoll = Math.max(-180.0F, Math.min(180.0F, interpolatedRoll));
        poseStack.mulPose(Axis.ZP.rotationDegrees(interpolatedRoll));

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