package fr.thoridan.planes.event;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.thoridan.planes.entity.client.ModModelLayers;
import fr.thoridan.planes.entity.client.models.YellowPlaneModel;
import fr.thoridan.planes.entity.custom.PlaneStructure;
import fr.thoridan.planes.entity.custom.models.YellowPlane;
import fr.thoridan.planes.item.ModItems;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.*;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.entity.player.Player;
import org.joml.Quaternionf;

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

//    @SubscribeEvent
//    public static void onItemRightClick(PlayerInteractEvent.RightClickItem event){
//        if(event.getItemStack().getItem() == ModItems.DEBUG_TOOL_4PLANE.get()){
//            event.getEntity().sendSystemMessage(Component.nullToEmpty("Hello from EventBus !"));
//        }
//    }


    @SubscribeEvent
    public static void onRenderPlayerPre(RenderLivingEvent.Pre<?, ?> event) {
        // Ensure the entity being rendered is a Player
        if (event.getEntity() instanceof Player player) {
            Entity entity = player.getRootVehicle();

            // Ensure the vehicle is a PlaneStructure
            if (entity instanceof PlaneStructure plane) {
                // Retrieve plane rotation
                float planeYaw = plane.getYRot();
                float planePitch = plane.getXRot();
                float planeRoll = plane.getInterpolate_roll();

                // Update player's yaw
                player.yBodyRot = planeYaw;
                player.yBodyRotO = planeYaw;

                // Access PoseStack
                PoseStack poseStack = event.getPoseStack();

                // Normalize the look direction (forward vector, local Z-axis)
                Vec3 forward = player.getLookAngle().normalize();

                // Define the global up vector
                Vec3 globalUp = new Vec3(0, 1, 0);

                // Compute the right vector (local X-axis)
                Vec3 right = globalUp.cross(forward).normalize();

                // Handle edge cases where the player looks straight up/down
                if (right.lengthSqr() < 0.0001) {
                    right = new Vec3(1, 0, 0); // Default right vector
                }

                // Compute the local up vector (perpendicular to forward and right, local Y-axis)
                Vec3 localUp = forward.cross(right).normalize();

                // Convert the rotation angles to radians
                float angleXRad = (float) Math.toRadians(planePitch);
                float angleZRad = (float) Math.toRadians(- planeRoll);

                // Shift the rotation point to the middle of the player's body
                double middleHeight = player.getBbHeight() / 2.0; // Half the player's height
                poseStack.translate(0.0, middleHeight, 0.0); // Move up by half the player's height

                // Create a quaternion for the 45° rotation around the local X-axis
                Quaternionf rotationQuaternionX = new Quaternionf().rotateAxis(
                        angleXRad,
                        (float) right.x,
                        (float) right.y,
                        (float) right.z
                );

                // Create a quaternion for the 30° rotation around the local Z-axis
                Quaternionf rotationQuaternionZ = new Quaternionf().rotateAxis(
                        angleZRad,
                        (float) forward.x,
                        (float) forward.y,
                        (float) forward.z
                );

                // Combine the rotations
                Quaternionf combinedQuaternion = new Quaternionf();
                combinedQuaternion.mul(rotationQuaternionZ); // Apply Z rotation first
                combinedQuaternion.mul(rotationQuaternionX); // Then apply X rotation

                // Apply the combined rotation to the PoseStack
                poseStack.mulPose(combinedQuaternion);

                // Translate back to the original position
                poseStack.translate(0.0, -middleHeight, 0.0); // Move back down by the same amount

                // Synchronize body rotation with the head
                player.yBodyRot = player.yHeadRot;
                player.yBodyRotO = player.yHeadRotO;

            }
        }
    }


//    @SubscribeEvent
//    public static void onRenderPlayerPre(RenderLivingEvent.Pre<?, ?> event) {
//        float partialTicks = Minecraft.getInstance().getFrameTime();
//        if (event.getEntity() instanceof Player player) {
//            Entity entity = player.getRootVehicle();
//
//            if (entity instanceof PlaneStructure plane) {
//                PoseStack poseStack = event.getPoseStack();
//
//
//                // Define rotation angles
//                float rotationAngleX = -plane.getXRot(); // Rotation on local X-axis
//                float rotationAngleY = - interpolateAngle(plane.yRotO, plane.getYRot(), partialTicks);  // Rotation on local Y-axis
//                float rotationAngleZ = plane.getInterpolate_roll(); // Rotation on local Z-axis
//
//                // Normalize look direction
//                Vec3 forward = player.getLookAngle().normalize();
//                Vec3 globalUp = new Vec3(0, 1, 0);
//                Vec3 right = globalUp.cross(forward).normalize();
//
//                if (right.lengthSqr() < 0.0001) {
//                    right = new Vec3(1, 0, 0); // Default right vector
//                }
//
//                Vec3 localUp = forward.cross(right).normalize();
//
//                float angleXRad = (float) Math.toRadians(rotationAngleX);
//                float angleYRad = (float) Math.toRadians(rotationAngleY);
//                float angleZRad = (float) Math.toRadians(rotationAngleZ);
//
//                double middleHeight = player.getBbHeight() / 2.0;
//                poseStack.translate(0.0, middleHeight, 0.0);
//
//                Quaternionf rotationQuaternionX = new Quaternionf().rotateAxis(
//                        angleXRad,
//                        (float) right.x,
//                        (float) right.y,
//                        (float) right.z
//                );
//
//                Quaternionf rotationQuaternionY = new Quaternionf().rotateAxis(
//                        angleYRad,
//                        (float) localUp.x,
//                        (float) localUp.y,
//                        (float) localUp.z
//                );
//
//                Quaternionf rotationQuaternionZ = new Quaternionf().rotateAxis(
//                        angleZRad,
//                        (float) forward.x,
//                        (float) forward.y,
//                        (float) forward.z
//                );
//
//                Quaternionf combinedQuaternion = new Quaternionf();
//                combinedQuaternion.mul(rotationQuaternionZ);
//                combinedQuaternion.mul(rotationQuaternionY);
//                combinedQuaternion.mul(rotationQuaternionX);
//
//                poseStack.mulPose(combinedQuaternion);
//                poseStack.translate(0.0, -middleHeight, 0.0);
//
//                // Avoid touching the camera
//                // Do not modify player.yBodyRot or player.yHeadRot
//            }
//        }
//    }


//    @SubscribeEvent
//    public static void onComputeCameraAngles(ViewportEvent.ComputeCameraAngles event) {
//        // Check if the camera’s entity is a Player
//        if (event.getCamera().getEntity() instanceof Player player) {
//            Entity entity = player.getRootVehicle();
//
//            // Ensure the vehicle is a PlaneStructure
//            if (entity instanceof PlaneStructure plane) {
//                float planeRoll = plane.getInterpolate_roll();
//                event.setRoll(event.getRoll() + planeRoll);
//            }
//
//        }
//    }


    /* --------------------- */
    /* --- FOR DEBUGING --- */
    /* -------------------- */




    /**
     * This event is called before the camera angles are computed.
     * It is used to apply custom logic to the camera angles.
     */
//    @SubscribeEvent
//    public static void TestComputeCameraAngles(ViewportEvent.ComputeCameraAngles event) {
//        // Check if the camera’s entity is a Player
//        if (event.getCamera().getEntity() instanceof Player player) {
//            ItemStack heldItem = player.getMainHandItem();
//
//            // Check if the player is holding your debug tool
//            if (heldItem.getItem() == ModItems.DEBUG_TOOL_4PLANE.get()) {
//                // Example rotations:
//                // Add +30 deg to pitch (the up/down angle),
//                // +15 deg to yaw (left/right),
//                // +10 deg to roll (camera tilt).
////                event.setPitch(event.getPitch() + 30.0F);
////                event.setYaw(event.getYaw() + 15.0F);
//                event.setRoll(event.getRoll() + 180.0F);
//            }
//        }
//    }


    /**
     * This event is called before the player is rendered.
     * It is used to apply custom logic to the player's rendering.
     */
    @SubscribeEvent
    public static void onRenderPlayerPreDebugTool(RenderLivingEvent.Pre<LivingEntity, ?> event) {
        LivingEntity livingEntity = event.getEntity();

        // Ensure the entity is a Player
        if (livingEntity instanceof Player player) {
            ItemStack heldItem = player.getMainHandItem();

            // Check if the player is holding the debug tool
            if (heldItem.getItem() == ModItems.DEBUG_TOOL_4PLANE.get()) {
                PoseStack poseStack = event.getPoseStack();

                // Define the desired rotation angles
                float rotationAngleX = 180.0f; // Rotation on local X-axis
                float rotationAngleY = 90.0f;  // Additional rotation on local Y-axis
                float rotationAngleZ = 0.0f;   // Additional rotation on local Z-axis

                // Normalize the look direction (forward vector, local Z-axis)
                Vec3 forward = player.getLookAngle().normalize();

                // Define the global up vector
                Vec3 globalUp = new Vec3(0, 1, 0);

                // Compute the right vector (local X-axis)
                Vec3 right = globalUp.cross(forward).normalize();

                // Handle edge cases where the player looks straight up/down
                if (right.lengthSqr() < 0.0001) {
                    right = new Vec3(1, 0, 0); // Default right vector
                }

                // Compute the local up vector (perpendicular to forward and right, local Y-axis)
                Vec3 localUp = forward.cross(right).normalize();

                // Convert the rotation angles to radians
                float angleXRad = (float) Math.toRadians(rotationAngleX);
                float angleYRad = (float) Math.toRadians(rotationAngleY);
                float angleZRad = (float) Math.toRadians(rotationAngleZ);

                // Shift the rotation point to the middle of the player's body
                double middleHeight = player.getBbHeight() / 2.0; // Half the player's height
                poseStack.translate(0.0, middleHeight, 0.0); // Move up by half the player's height

                // Create a quaternion for the rotation around the local X-axis
                Quaternionf rotationQuaternionX = new Quaternionf().rotateAxis(
                        angleXRad,
                        (float) right.x,
                        (float) right.y,
                        (float) right.z
                );

                // Create a quaternion for the rotation around the local Y-axis
                Quaternionf rotationQuaternionY = new Quaternionf().rotateAxis(
                        angleYRad,
                        (float) localUp.x,
                        (float) localUp.y,
                        (float) localUp.z
                );

                // Create a quaternion for the rotation around the local Z-axis
                Quaternionf rotationQuaternionZ = new Quaternionf().rotateAxis(
                        angleZRad,
                        (float) forward.x,
                        (float) forward.y,
                        (float) forward.z
                );

                // Combine the rotations
                Quaternionf combinedQuaternion = new Quaternionf();
                combinedQuaternion.mul(rotationQuaternionZ); // Apply Z rotation first
                combinedQuaternion.mul(rotationQuaternionY); // Then apply Y rotation
                combinedQuaternion.mul(rotationQuaternionX); // Then apply X rotation

                // Apply the combined rotation to the PoseStack
                poseStack.mulPose(combinedQuaternion);

                // Translate back to the original position
                poseStack.translate(0.0, -middleHeight, 0.0); // Move back down by the same amount

                // Synchronize body rotation with the head
                player.yBodyRot = player.yHeadRot;
                player.yBodyRotO = player.yHeadRotO;
            }
        }
    }


    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Minecraft minecraft = Minecraft.getInstance();
            if (minecraft.player != null && minecraft.gameRenderer != null) {
                Camera camera = minecraft.gameRenderer.getMainCamera();

                // Apply roll (Z-axis rotation) to the camera's quaternion
                float customRollAngle = 30.0F; // Example roll in degrees
                Quaternionf rollQuaternion = new Quaternionf().rotateZ((float) Math.toRadians(customRollAngle));
                camera.rotation().mul(rollQuaternion);
            }
        }
    }

    private static float interpolateAngle(float startAngle, float endAngle, float partialTicks) {
        float deltaAngle = endAngle - startAngle;
        while (deltaAngle < -180.0F) {
            deltaAngle += 360.0F;
        }
        while (deltaAngle >= 180.0F) {
            deltaAngle -= 360.0F;
        }
        return startAngle + partialTicks * deltaAngle;
    }

}