package fr.thoridan.planes.entity.client.models.rafale;

import fr.thoridan.planes.ForPlanes;
import fr.thoridan.planes.entity.custom.PlaneStructure;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class RafaleNormalRenderer extends RafaleRenderer<PlaneStructure> {
    public RafaleNormalRenderer(EntityRendererProvider.Context context) {
        super(context);
        System.out.println("RafaleNormalRenderer");
        this.RAFALE_TEXTURE = new ResourceLocation(ForPlanes.MOD_ID, "textures/entity/rafale_texture.png");
    }
}
