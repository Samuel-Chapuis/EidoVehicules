package fr.thoridan.planes.entity.client.models.rafale;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.thoridan.planes.ForPlanes;
import fr.thoridan.planes.entity.client.ModModelLayers;
import fr.thoridan.planes.entity.client.PlaneRenderer;
import fr.thoridan.planes.entity.custom.PlaneStructure;
import fr.thoridan.planes.entity.custom.models.rafale.GreenRafale;
import fr.thoridan.planes.entity.custom.models.rafale.NormalRafale;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class RafaleNormalRenderer extends PlaneRenderer<NormalRafale> {
    private static final ResourceLocation NORMAL_RAFALE_TEXTURE = new ResourceLocation(ForPlanes.MOD_ID, "textures/entity/rafale_texture.png");
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
        poseStack.translate(0.0D, 2D, 0.0D);
    }
}
