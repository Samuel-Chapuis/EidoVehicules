package fr.thoridan.planes.entity.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.thoridan.planes.entity.client.ModModelLayers;
import fr.thoridan.planes.entity.client.PlaneRenderer;
import fr.thoridan.planes.entity.custom.models.Rafale;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class RafaleRenderer extends PlaneRenderer<Rafale> {
    private static ResourceLocation RAFALE_TEXTURE;
    private final RafaleModel<Rafale> model;

    public RafaleRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new RafaleModel<>(context.bakeLayer(ModModelLayers.RAFALE));
    }

    @Override
    protected ResourceLocation getPlaneTexture(Rafale entity) {
        return RAFALE_TEXTURE;
    }

    @Override
    protected RafaleModel<Rafale> getPlaneModel(Rafale entity) {
        return model;
    }

    @Override
    protected void renderSettings(PoseStack poseStack) {
        poseStack.scale(2.5F, 2.5F, 2.5F);
        poseStack.translate(0.0D, 2D, 0.0D);
    }
}

