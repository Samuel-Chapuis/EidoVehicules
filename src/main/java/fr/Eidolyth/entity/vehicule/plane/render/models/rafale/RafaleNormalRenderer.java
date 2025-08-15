package fr.Eidolyth.entity.vehicule.plane.render.models.rafale;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import fr.Eidolyth.EidoMod;
import fr.Eidolyth.entity.ModModelLayers;
import fr.Eidolyth.entity.vehicule.plane.PlaneStructure;
import fr.Eidolyth.entity.vehicule.plane.declaration.models.rafale.NormalRafale;
import fr.Eidolyth.entity.vehicule.plane.PlaneRenderer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class RafaleNormalRenderer extends PlaneRenderer<NormalRafale> {
    private static final ResourceLocation NORMAL_RAFALE_TEXTURE = new ResourceLocation(EidoMod.MODID, "textures/entity/rafale_texture.png");
    // This texture will be tinted with a custom color
    private static final ResourceLocation NORMAL_RAFALE_COLORABLE_TEXTURE = new ResourceLocation(EidoMod.MODID, "textures/entity/rafale_colorable_texture.png");
    private final RafaleModel<NormalRafale> model;

    public RafaleNormalRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new RafaleModel<>(context.bakeLayer(ModModelLayers.NORMAL_RAFALE));
    }

    @Override
    protected ResourceLocation getPlaneTexture(NormalRafale entity) {
        return NORMAL_RAFALE_TEXTURE;
    }

    @Override
    protected EntityModel<NormalRafale> getPlaneModel(NormalRafale entity) {
        return model;
    }

    @Override
    protected void renderSettings(PoseStack poseStack) {
        poseStack.scale(2.5F, 2.5F, 2.5F);
        poseStack.translate(0.0D, 0.6D, 0.0D);
    }

    /**
     * Render the additional layer with a color tint.
     * Depending on your setup, you might need to pass in additional parameters such as MultiBufferSource and packedLight.
     */
    @Override
    protected void render_addition(PoseStack poseStack, MultiBufferSource buffer, int packedLight, PlaneStructure plane) {
        // Determine your tint color; for example, a red tint.
        float red = plane.getRed();
        float green = plane.getGreen();
        float blue = plane.getBlue();
        float alpha = plane.getAlpha();

        // Use a RenderType that supports tinting (for example, entityCutoutNoCull).
        VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityCutoutNoCull(NORMAL_RAFALE_COLORABLE_TEXTURE));

        // Render the model a second time with the tinted texture.
        // Note: renderToBuffer() usually takes the pose, vertexConsumer, light, overlay, and RGBA values.
        model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, red, green, blue, alpha);
    }
}