package fr.Thorid4n.Planes.event;

import fr.Thorid4n.Planes.ForPlanes;
import fr.Thorid4n.Planes.entity.ModEntities;
import fr.Thorid4n.Planes.entity.client.ModModelLayers;
import fr.Thorid4n.Planes.entity.client.YellowPlaneModel;
import fr.Thorid4n.Planes.entity.custom.RhinoEntity;
import fr.Thorid4n.Planes.entity.custom.YellowPlaneEntity;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ForPlanes.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.RHINO.get(), RhinoEntity.createAttributes().build());
    }

	@SubscribeEvent
    public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.YELLOW_PLANE, YellowPlaneModel::createBodyLayer);
    }
}
