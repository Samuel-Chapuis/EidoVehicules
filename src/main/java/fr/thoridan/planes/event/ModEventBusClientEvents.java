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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
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
        if (livingEntity instanceof Player p) {
            ItemStack heldItem = p.getMainHandItem();
            if (heldItem.getItem() == ModItems.DEBUG_TOOL_4PLANE.get()) {
                System.out.println("Player is holding the debug tool");
                PoseStack poseStack = event.getPoseStack();
                poseStack.translate(0.0, 100, 0.0);

                // Angles de rotation en degrés
                float rotationAngleX = 0; // Rotation autour de l'axe X local
                float rotationAngleY = 0; // Rotation autour de l'axe Y local
                float rotationAngleZ = 0; // Rotation autour de l'axe Z local

                // Obtenir la direction du regard du joueur
                Vec3 lookDirection = p.getLookAngle().normalize(); // Axe Z local

                // Définir le vecteur "up" global
                Vec3 upVector = new Vec3(0, 1, 0); // Axe Y global

                // Calculer l'axe X local (droite du joueur)
                Vec3 rightVector = upVector.cross(lookDirection).normalize();

                // Gestion du cas où le joueur regarde directement vers le haut ou le bas
                if (rightVector.lengthSqr() < 0.0001) {
                    rightVector = new Vec3(1, 0, 0); // Axe par défaut
                }

                // Calculer l'axe Y local (haut du joueur)
                Vec3 localUpVector = lookDirection.cross(rightVector).normalize();

                // Convertir les angles en radians
                float angleXRad = (float) Math.toRadians(rotationAngleX);
                float angleYRad = (float) Math.toRadians(rotationAngleY);
                float angleZRad = (float) Math.toRadians(rotationAngleZ);

                // Créer les quaternions de rotation
                Quaternionf rotationQuaternionX = new Quaternionf().rotateAxis(
                        angleXRad,
                        (float) rightVector.x,
                        (float) rightVector.y,
                        (float) rightVector.z
                );

                Quaternionf rotationQuaternionY = new Quaternionf().rotateAxis(
                        angleYRad,
                        (float) localUpVector.x,
                        (float) localUpVector.y,
                        (float) localUpVector.z
                );

                Quaternionf rotationQuaternionZ = new Quaternionf().rotateAxis(
                        angleZRad,
                        (float) lookDirection.x,
                        (float) lookDirection.y,
                        (float) lookDirection.z
                );

                // Combiner les quaternions de rotation
                Quaternionf combinedQuaternion = new Quaternionf();

                // Appliquer les rotations dans l'ordre souhaité
                combinedQuaternion.mul(rotationQuaternionZ);
                combinedQuaternion.mul(rotationQuaternionY);
                combinedQuaternion.mul(rotationQuaternionX);

                // Appliquer la rotation au PoseStack
                poseStack.mulPose(combinedQuaternion);

                p.yBodyRot = p.yHeadRot;
                p.yBodyRotO = p.yHeadRotO;
            }
        }
    }



}