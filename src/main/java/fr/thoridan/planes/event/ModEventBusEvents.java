package fr.thoridan.planes.event;

import fr.thoridan.planes.ForPlanes;
import fr.thoridan.planes.entity.client.ModModelLayers;
import fr.thoridan.planes.entity.client.models.rafale.RafaleModel;
import fr.thoridan.planes.entity.client.models.YellowPlaneModel;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ForPlanes.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
	@SubscribeEvent
    public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.YELLOW_PLANE, YellowPlaneModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.RAFALE, RafaleModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.RAFALE_GREEN, RafaleModel::createBodyLayer);
    }
}
