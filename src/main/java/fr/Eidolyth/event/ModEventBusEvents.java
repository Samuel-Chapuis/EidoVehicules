package fr.Eidolyth.event;

import fr.Eidolyth.EidoVehicules;
import fr.Eidolyth.entity.vehicule.plane.render.models.a220.A220Model;
import fr.Eidolyth.entity.ModModelLayers;
import fr.Eidolyth.entity.vehicule.plane.render.models.tourist.ToursiticPlaneModel;
import fr.Eidolyth.entity.vehicule.plane.render.models.rafale.RafaleModel;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Handles mod-specific event registrations for the ForPlanes mod.
 * This class subscribes to the mod event bus and registers model layer definitions
 * for custom entities used within the mod.
 */
@Mod.EventBusSubscriber(modid = EidoVehicules.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
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
        event.registerLayerDefinition(ModModelLayers.YELLOW_PLANE, ToursiticPlaneModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.NORMAL_RAFALE, RafaleModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.RAFALE_GREEN, RafaleModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.A220LAYER, A220Model::createBodyLayer);
    }
}
