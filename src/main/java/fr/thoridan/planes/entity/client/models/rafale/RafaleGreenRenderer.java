package fr.thoridan.planes.entity.client.models.rafale;

import fr.thoridan.planes.ForPlanes;
import fr.thoridan.planes.entity.custom.PlaneStructure;
import fr.thoridan.planes.entity.custom.models.rafale.GreenRafale;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class RafaleGreenRenderer extends RafaleRenderer<PlaneStructure> {
    public RafaleGreenRenderer(EntityRendererProvider.Context context) {
        super(context);
        System.out.println("RafaleGreenRenderer");
        this.RAFALE_TEXTURE = new ResourceLocation(ForPlanes.MOD_ID, "textures/entity/rafale_green_texture.png");
    }
}
