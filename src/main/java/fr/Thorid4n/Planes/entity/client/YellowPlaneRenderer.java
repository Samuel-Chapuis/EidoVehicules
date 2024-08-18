package fr.Thorid4n.Planes.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;

import fr.Thorid4n.Planes.ForPlanes;
import fr.Thorid4n.Planes.entity.custom.YellowPlaneEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class YellowPlaneRenderer extends MobRenderer<YellowPlaneEntity, YellowPlaneModel<YellowPlaneEntity>> {
	public YellowPlaneRenderer(EntityRendererProvider.Context context) {
        super(context, new YellowPlaneModel<>(context.bakeLayer(ModModelLayers.YELLOW_PLANE)), 0.5f);
    }

	@Override
    public ResourceLocation getTextureLocation(YellowPlaneEntity pEntity) {
        return new ResourceLocation(ForPlanes.MOD_ID, "textures/entity/yellow_plane_texture.png");
    }

	@Override
	public void render(YellowPlaneEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
					   net.minecraft.client.renderer.MultiBufferSource pBuffer, int pPackedLight) {
		pMatrixStack.scale(1f, 1f, 1f);
		super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
	}
}
