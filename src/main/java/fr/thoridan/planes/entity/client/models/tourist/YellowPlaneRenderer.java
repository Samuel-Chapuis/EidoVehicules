package fr.thoridan.planes.entity.client.models.tourist;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import fr.thoridan.planes.ForPlanes;
import fr.thoridan.planes.entity.client.ModModelLayers;
import fr.thoridan.planes.entity.client.PlaneRenderer;
import fr.thoridan.planes.entity.custom.PlaneStructure;
import fr.thoridan.planes.entity.custom.models.tourist.YellowPlane;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class YellowPlaneRenderer extends PlaneRenderer<YellowPlane> {
    private static final ResourceLocation YELLOW_PLANE_TEXTURE = new ResourceLocation(ForPlanes.MOD_ID, "textures/entity/yellow_plane_texture.png");
    private static final ResourceLocation YELLOW_PLANE_COLORABLE_TEXTURE = new ResourceLocation(ForPlanes.MOD_ID, "textures/entity/yellow_plane_colorable_texture.png");
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
    protected void render_addition(PoseStack poseStack, MultiBufferSource buffer, int packedLight, PlaneStructure plane){
        float red = plane.getRed();
        float green = plane.getGreen();
        float blue = plane.getBlue();
        float alpha = plane.getAlpha();

        // Use a RenderType that supports tinting (for example, entityCutoutNoCull).
        VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityCutoutNoCull(YELLOW_PLANE_COLORABLE_TEXTURE));

        // Render the model a second time with the tinted texture.
        // Note: renderToBuffer() usually takes the pose, vertexConsumer, light, overlay, and RGBA values.
        model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, red, green, blue, alpha);
    }

}