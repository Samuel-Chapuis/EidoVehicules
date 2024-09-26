package fr.thoridan.planes.event;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.thoridan.planes.entity.client.ModModelLayers;
import fr.thoridan.planes.entity.client.models.YellowPlaneModel;
import fr.thoridan.planes.entity.custom.PlaneStructure;
import fr.thoridan.planes.entity.custom.models.YellowPlane;
import fr.thoridan.planes.item.ModItems;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.entity.player.Player;
import org.joml.Quaternionf;
import org.joml.Vector3f;

@Mod.EventBusSubscriber(modid = "forplanes", bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModEventBusClientEvents {

    @SubscribeEvent
    public static void onEntityEnterPlane(EntityMountEvent event) {
        if (event.getEntityBeingMounted() instanceof YellowPlane planeEntity) {
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
        // Logique d'ajustement de la caméra ici, par exemple on peut changer l'angle ou le FOV
    }

    @SubscribeEvent
    public static void onEntityRenderersRegister(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.YELLOW_PLANE, YellowPlaneModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.NORMAL_RAFALE, YellowPlaneModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.RAFALE_GREEN, YellowPlaneModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void onItemRightClick(PlayerInteractEvent.RightClickItem event){
        if(event.getItemStack().getItem() == ModItems.DEBUG_TOOL_4PLANE.get()){
            event.getEntity().sendSystemMessage(Component.nullToEmpty("Hello from EventBus !"));
        }
    }

    @SubscribeEvent
    public static void onRenderPlayerPre(RenderLivingEvent.Pre<LivingEntity, ?> event) {
        LivingEntity livingEntity = event.getEntity();
        Entity entity = livingEntity.getRootVehicle();
        /* The logic is one only if the player is inside a plane */
        if(entity instanceof PlaneStructure p){
            PoseStack poseStack = event.getPoseStack();
            Quaternionf quaternionf = new Quaternionf();

        /* Exemple of 45 rotation degres on the X axe */
            quaternionf.rotateX(45);
            poseStack.mulPose(quaternionf);
        /* Exemple of 5 blocks translation on the Y axe */
            poseStack.translate(0, 5, 0);


        }
    }

}