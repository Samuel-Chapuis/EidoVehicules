package fr.thoridan.planes.event;

import fr.thoridan.planes.ForPlanes;
import fr.thoridan.planes.entity.client.ModModelLayers;
import fr.thoridan.planes.entity.client.models.tourist.YellowPlaneModel;
import fr.thoridan.planes.entity.client.models.rafale.RafaleModel;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Handles mod-specific event registrations for the ForPlanes mod.
 * This class subscribes to the mod event bus and registers model layer definitions
 * for custom entities used within the mod.
 */
@Mod.EventBusSubscriber(modid = ForPlanes.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    /**
     * Registers layer definitions for custom entity models.
     * This method is called during the client-side setup to define how entities
     * are rendered by associating model layers with their respective model classes.
     *
     * @param event The event triggered to register model layer definitions.
     */
	@SubscribeEvent
    public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.YELLOW_PLANE, YellowPlaneModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.NORMAL_RAFALE, RafaleModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.RAFALE_GREEN, RafaleModel::createBodyLayer);
    }
}
