package fr.Eidolyth.entity.vehicule.plane.render.models.a220;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import fr.Eidolyth.EidoVehicules;
import fr.Eidolyth.entity.ModModelLayers;
import fr.Eidolyth.entity.vehicule.plane.PlaneStructure;
import fr.Eidolyth.entity.vehicule.plane.PlaneRenderer;
import fr.Eidolyth.entity.vehicule.plane.declaration.models.a220.A220;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class A220Renderer extends PlaneRenderer<A220> {
    private static final ResourceLocation A220_TEXTURE = new ResourceLocation(EidoVehicules.MODID, "textures/entity/a220_texture.png");
    // This texture will be tinted with a custom color
    private static final ResourceLocation A220_COLORABLE_TEXTURE = new ResourceLocation(EidoVehicules.MODID, "textures/entity/a220_colorable_texture.png");
    private final A220Model<A220> model;

    public A220Renderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new A220Model<>(context.bakeLayer(ModModelLayers.A220LAYER));
    }

    @Override
    protected ResourceLocation getPlaneTexture(A220 entity) {
        return A220_TEXTURE;
    }

    @Override
    protected EntityModel<A220> getPlaneModel(A220 entity) {
        return model;
    }

    @Override
    protected void renderSettings(PoseStack poseStack) {
        poseStack.scale(1.5F, 1.5F, 1.5F);
        poseStack.translate(0.0D, 0.7f, 0.0D);
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
        VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityCutoutNoCull(A220_COLORABLE_TEXTURE));

        // Render the model a second time with the tinted texture.
        // Note: renderToBuffer() usually takes the pose, vertexConsumer, light, overlay, and RGBA values.
        model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, red, green, blue, alpha);
    }
}