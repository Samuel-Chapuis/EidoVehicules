package fr.thoridan.planes.event;

import fr.thoridan.planes.ForPlanes;
import fr.thoridan.planes.entity.client.ModModelLayers;
import fr.thoridan.planes.entity.client.YellowPlaneModel;
import fr.thoridan.planes.entity.custom.YellowPlaneEntity;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;

@Mod.EventBusSubscriber(modid = "forplanes", bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModEventBusClientEvents {

    @SubscribeEvent
    public static void onEntityEnterPlane(EntityMountEvent event) {
        if (event.getEntityBeingMounted() instanceof YellowPlaneEntity planeEntity) {
            Entity passenger = event.getEntityMounting();
            if (passenger instanceof Player && event.isMounting()) {
                Player player = (Player) passenger;
                System.out.println("Ajustement de la caméra");
                // Logique d'ajustement de la caméra
                adjustCameraDistance();
            }
        }
    }

    private static void adjustCameraDistance() {
        // Logique d'ajustement de la caméra ici

    }
}