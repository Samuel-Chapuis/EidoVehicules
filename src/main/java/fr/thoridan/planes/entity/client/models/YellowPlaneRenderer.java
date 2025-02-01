package fr.thoridan.planes.entity.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.thoridan.planes.ForPlanes;
import fr.thoridan.planes.entity.client.ModModelLayers;
import fr.thoridan.planes.entity.client.PlaneRenderer;
import fr.thoridan.planes.entity.custom.PlaneStructure;
import fr.thoridan.planes.entity.custom.models.YellowPlane;
import fr.thoridan.planes.entity.custom.models.rafale.NormalRafale;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class YellowPlaneRenderer extends PlaneRenderer<YellowPlane> {
    private static final ResourceLocation YELLOW_PLANE_TEXTURE = new ResourceLocation(ForPlanes.MOD_ID, "textures/entity/yellow_plane_texture.png");
    private final YellowPlaneModel<YellowPlane> model;

    public YellowPlaneRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new YellowPlaneModel<>(context.bakeLayer(ModModelLayers.YELLOW_PLANE));
    }

    @Override
    protected ResourceLocation getPlaneTexture(YellowPlane entity) {
        return YELLOW_PLANE_TEXTURE;
    }

    @Override
    protected EntityModel<YellowPlane> getPlaneModel(YellowPlane entity) {
        return model;
    }

    @Override
    protected void renderSettings(PoseStack poseStack) {
        poseStack.translate(0.0D, 1.5D, 0.0D);
    }

    @Override
    protected void render_addition(PoseStack poseStack, MultiBufferSource buffer, int packedLight, PlaneStructure planeStructure){

    }

}