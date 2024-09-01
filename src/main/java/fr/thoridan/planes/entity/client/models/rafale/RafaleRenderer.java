package fr.thoridan.planes.entity.client.models.rafale;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.thoridan.planes.entity.client.ModModelLayers;
import fr.thoridan.planes.entity.client.PlaneRenderer;
import fr.thoridan.planes.entity.custom.PlaneStructure;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public abstract class RafaleRenderer<G extends PlaneStructure> extends PlaneRenderer<G> {
    protected static ResourceLocation RAFALE_TEXTURE;
    private final RafaleModel<G> model;

    public RafaleRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new RafaleModel<>(context.bakeLayer(ModModelLayers.RAFALE));
    }

    @Override
    protected ResourceLocation getPlaneTexture(G entity) {
        return RAFALE_TEXTURE;
    }

    @Override
    protected RafaleModel<G> getPlaneModel(G entity) {
        return model;
    }

    @Override
    protected void renderSettings(PoseStack poseStack) {
        poseStack.scale(2.5F, 2.5F, 2.5F);
        poseStack.translate(0.0D, 2D, 0.0D);
    }
}

