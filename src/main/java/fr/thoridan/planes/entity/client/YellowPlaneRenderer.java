package fr.thoridan.planes.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import fr.thoridan.planes.ForPlanes;
import fr.thoridan.planes.entity.custom.YellowPlaneEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;

public class YellowPlaneRenderer extends EntityRenderer<YellowPlaneEntity> {

	private float previousRoll = 0.0F;
	private float currentRoll = 0.0F;
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
	public void render(YellowPlaneEntity plane, float entityYaw, float partialTicks, PoseStack poseStack,
					   net.minecraft.client.renderer.MultiBufferSource buffer, int packedLight) {
		
		poseStack.pushPose();
	
		// Ajuste la position du modèle
		poseStack.translate(0.0D, 1.5D, 0.0D);
	
		// Applique une rotation sur l'axe X pour redresser l'avion
		poseStack.mulPose(Axis.XP.rotationDegrees(180.0F));
	
		// Interpole l'angle de Yaw (rotation horizontale)
		float interpolatedYaw = interpolateAngle(plane.yRotO, plane.getYRot(), partialTicks);
		poseStack.mulPose(Axis.YP.rotationDegrees(interpolatedYaw));
	
		// Conditionne le tangage (pitch) à une vitesse minimale
		double speedSquared = plane.getDeltaMovement().horizontalDistanceSqr();
		double minSpeedSquared = 0.03; // Définissez ici la vitesse minimale requise (au carré) pour autoriser le tangage
		if (speedSquared > minSpeedSquared) {
			// Interpole l'angle de Pitch (inclinaison verticale) seulement si la vitesse dépasse le seuil
			float interpolatedPitch = interpolateAngle(plane.xRotO, plane.getXRot(), partialTicks);
			poseStack.mulPose(Axis.XP.rotationDegrees(interpolatedPitch)); // On applique ici la rotation sur l'axe X pour le tangage (pitch)
		}

		// Met à jour les valeurs de roll
				previousRoll = currentRoll;
		currentRoll = -plane.getRoll();

		// Interpolation avec les ticks partiels
		float interpolatedRoll = interpolateAngle(previousRoll, currentRoll, partialTicks);

		// Limite le tangage à 180 degrés
		interpolatedRoll = Math.max(-180.0F, Math.min(180.0F, interpolatedRoll));

		// Applique la rotation pour le roll (tangage)
		poseStack.mulPose(Axis.ZP.rotationDegrees(interpolatedRoll));
	
		// Rendu du modèle
		var vertexConsumer = buffer.getBuffer(this.model.renderType(this.getTextureLocation(plane)));
		this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

		this.model.setupAnim(plane, 0.0F, 0.0F, plane.tickCount + partialTicks, entityYaw, plane.getXRot());

		super.render(plane, entityYaw, partialTicks, poseStack, buffer, packedLight);
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