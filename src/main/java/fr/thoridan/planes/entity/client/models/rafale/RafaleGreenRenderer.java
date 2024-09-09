package fr.thoridan.planes.entity.client.models.rafale;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.thoridan.planes.ForPlanes;
import fr.thoridan.planes.entity.client.ModModelLayers;
import fr.thoridan.planes.entity.client.PlaneRenderer;
import fr.thoridan.planes.entity.custom.PlaneStructure;
import fr.thoridan.planes.entity.custom.models.rafale.GreenRafale;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;

public class RafaleGreenRenderer extends PlaneRenderer<GreenRafale> {

    private static final ResourceLocation GFREEN_RAFALE_TEXTURE = new ResourceLocation(ForPlanes.MOD_ID, "textures/entity/rafale_green_texture.png");
    private final RafaleModel<GreenRafale> model;

    public RafaleGreenRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new RafaleModel<>(context.bakeLayer(ModModelLayers.RAFALE_GREEN));
    }

    @Override
    protected ResourceLocation getPlaneTexture(GreenRafale entity) {
        return GFREEN_RAFALE_TEXTURE;
    }

    @Override
    protected RafaleModel<GreenRafale> getPlaneModel(GreenRafale entity) {
        return model;
    }

    @Override
    protected void renderSettings(PoseStack poseStack) {
        poseStack.scale(2.5F, 2.5F, 2.5F);
        poseStack.translate(0.0D, 0.8D, 0.0D);

    }
}
