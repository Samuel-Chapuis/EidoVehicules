package fr.thoridan.planes.entity.client.models;

import fr.thoridan.planes.ForPlanes;
import fr.thoridan.planes.entity.client.ModModelLayers;
import fr.thoridan.planes.entity.client.PlaneRenderer;
import fr.thoridan.planes.entity.custom.models.Rafale;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class RafaleRender extends PlaneRenderer<Rafale> {
    private static final ResourceLocation RAFALE_TEXTURE = new ResourceLocation(ForPlanes.MOD_ID, "textures/entity/rafale_texture.png");
    private final RafaleModel<Rafale> model;

    public RafaleRender(EntityRendererProvider.Context context) {
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
}
