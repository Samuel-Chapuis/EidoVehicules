package fr.Thorid4n.Planes.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import fr.Thorid4n.Planes.ForPlanes;
import fr.Thorid4n.Planes.entity.custom.YellowPlaneEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;

public class YellowPlaneRenderer extends EntityRenderer<YellowPlaneEntity> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(ForPlanes.MOD_ID, "textures/entity/yellow_plane_texture.png");
    private final YellowPlaneModel<YellowPlaneEntity> model;

    public YellowPlaneRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new YellowPlaneModel<>(context.bakeLayer(ModModelLayers.YELLOW_PLANE));
    }

    @Override
    public ResourceLocation getTextureLocation(YellowPlaneEntity entity) {
        return TEXTURE;
    }

	@Override
	public void render(YellowPlaneEntity entity, float entityYaw, float partialTicks, PoseStack poseStack,
					   net.minecraft.client.renderer.MultiBufferSource buffer, int packedLight) {
		
		poseStack.pushPose();
	
		// Ajuste la position du modèle
		poseStack.translate(0.0D, 1.5D, 0.0D);
	
		// Applique une rotation sur l'axe X pour redresser l'avion
		poseStack.mulPose(Axis.XP.rotationDegrees(180.0F));
	
		// Interpole l'angle de Yaw (rotation horizontale)
		float interpolatedYaw = interpolateAngle(entity.yRotO, entity.getYRot(), partialTicks);
		poseStack.mulPose(Axis.YP.rotationDegrees(interpolatedYaw));
	
		// Conditionne le tangage (pitch) à une vitesse minimale
		double speedSquared = entity.getDeltaMovement().horizontalDistanceSqr();
		double minSpeedSquared = 0.03; // Définissez ici la vitesse minimale requise (au carré) pour autoriser le tangage
		if (speedSquared > minSpeedSquared) {
			// Interpole l'angle de Pitch (inclinaison verticale) seulement si la vitesse dépasse le seuil
			float interpolatedPitch = interpolateAngle(entity.xRotO, entity.getXRot(), partialTicks);
			poseStack.mulPose(Axis.XP.rotationDegrees(interpolatedPitch)); // On applique ici la rotation sur l'axe X pour le tangage (pitch)
		}
	
		// Rendu du modèle
		var vertexConsumer = buffer.getBuffer(this.model.renderType(this.getTextureLocation(entity)));
		this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		
		this.model.setupAnim(entity, 0.0F, 0.0F, entity.tickCount + partialTicks, entityYaw, entity.getXRot());
		
		super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
		poseStack.popPose();
	}
	
	/**
	 * Interpole l'angle de rotation en tenant compte des sauts entre -180 et 180 degrés.
	 */
	private float interpolateAngle(float startAngle, float endAngle, float partialTicks) {
		float deltaAngle = endAngle - startAngle;
	
		// Ajuste la différence d'angle pour éviter le saut
		while (deltaAngle < -180.0F) {
			deltaAngle += 360.0F;
		}
		while (deltaAngle >= 180.0F) {
			deltaAngle -= 360.0F;
		}
	
		return startAngle + partialTicks * deltaAngle;
	}
}