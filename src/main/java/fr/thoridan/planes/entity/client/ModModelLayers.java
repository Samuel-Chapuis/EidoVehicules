package fr.thoridan.planes.entity.client;

import fr.thoridan.planes.ForPlanes;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

/**
 * Defines and registers model layers for plane entities in the ForPlanes mod.
 * Each model layer location is associated with a specific model and texture,
 * allowing for proper rendering of different plane types.
 */
public class ModModelLayers {

	// Model layer for the Yellow Plane
	public static final ModelLayerLocation YELLOW_PLANE = new ModelLayerLocation(
			new ResourceLocation(ForPlanes.MOD_ID, "yellow_plane"), // Namespace and path for the model
			"main"
	);

	// Model layer for the Normal Rafale
	public static final ModelLayerLocation NORMAL_RAFALE = new ModelLayerLocation(
			new ResourceLocation(ForPlanes.MOD_ID, "normal_rafale"), // Namespace and path for the model
			"main"
	);

	// Model layer for the Green Rafale
	public static final ModelLayerLocation RAFALE_GREEN = new ModelLayerLocation(
			new ResourceLocation(ForPlanes.MOD_ID, "rafale_green"), // Namespace and path for the model
			"main"
	);

	public static final ModelLayerLocation A220LAYER =
			new ModelLayerLocation(new ResourceLocation(ForPlanes.MOD_ID, "a220"), "main");

}
