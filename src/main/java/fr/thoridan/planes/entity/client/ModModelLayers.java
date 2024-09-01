package fr.thoridan.planes.entity.client;

import fr.thoridan.planes.ForPlanes;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
	public static final ModelLayerLocation YELLOW_PLANE = new ModelLayerLocation(
			new ResourceLocation(ForPlanes.MOD_ID, "yellow_plane"), "main");

	public static final ModelLayerLocation RAFALE = new ModelLayerLocation(
			new ResourceLocation(ForPlanes.MOD_ID, "normal_rafale"), "main");

	public static final ModelLayerLocation RAFALE_GREEN = new ModelLayerLocation(
			new ResourceLocation(ForPlanes.MOD_ID, "rafale_green"), "main");
}
