package fr.thoridan.planes.event;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import fr.thoridan.planes.Globals;
import fr.thoridan.planes.entity.client.ModModelLayers;
import fr.thoridan.planes.entity.client.models.YellowPlaneModel;
import fr.thoridan.planes.entity.custom.PlaneStructure;
import fr.thoridan.planes.entity.custom.models.YellowPlane;
import fr.thoridan.planes.item.ModItems;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
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

    // This event is use to apply custom render to the player in the plane
    @SubscribeEvent
    public static void onRenderPlayerPre(RenderLivingEvent.Pre<?, ?> event) {
        // Ensure the entity being rendered is a Player
        if (event.getEntity() instanceof Player player) {
            Entity entity = player.getRootVehicle();

            // Ensure the vehicle is a PlaneStructure
            if (entity instanceof PlaneStructure plane) {
                event.setCanceled(true);

                float partialTicks = event.getPartialTick();
                float interpolatedRoll = plane.getInterpolate_roll();
                interpolatedRoll = Math.max(-180.0F, Math.min(180.0F, interpolatedRoll));
                float interpolatedYaw = interpolateAngle(plane.yRotO, plane.getYRot(), partialTicks);

                float interpolatedPitch = interpolateAngle(plane.xRotO, plane.getXRot(), partialTicks);
                System.out.println("interpolatedPitch: " + interpolatedPitch);

                float rotX = interpolatedPitch ;   // Rotation around X-axis
                float rotY = interpolatedYaw;  // Rotation around Y-axis
                float rotZ = interpolatedRoll;   // Rotation around Z-axis

                // Define desired positions
                double posX = 0.0D;  // Translation along X-axis
                double posY = 0.5D;  // Translation along Y-axis (1.5 + 1.0)
                double posZ = 0.0D;  // Translation along Z-axis

                // Call the custom render method with transformation parameters
                doCustomPlayerRender(player, event, rotX, rotY, rotZ, posX, posY, posZ);
            }
        }
    }

    // This event is used to apply custom logic to the camera angles
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



    @SubscribeEvent
    public static void onRenderLivingPre(RenderLivingEvent.Pre<?, ?> event) {
        // If it's a Player and holding our special item, cancel default rendering
        if (event.getEntity() instanceof Player player) {
            if (isHoldingItem(player, ModItems.DEBUG_TOOL_4PLANE.get())) {
                event.setCanceled(true);

                // Define desired rotations (in degrees)
                float rotX = Globals.global1;   // Rotation around X-axis
                float rotY = Globals.global2;  // Rotation around Y-axis
                float rotZ = Globals.global3;   // Rotation around Z-axis

                // Define desired positions
                double posX = 0.0D;  // Translation along X-axis
                double posY = 0.0D;  // Translation along Y-axis (1.5 + 1.0)
                double posZ = 0.0D;  // Translation along Z-axis

                // Call the custom render method with transformation parameters
                doCustomPlayerRender(player, event, rotX, rotY, rotZ, posX, posY, posZ);
            }
        }
    }

    public static void doCustomPlayerRender(Player player, RenderLivingEvent.Pre<?, ?> event,
                                            float rotX, float rotY, float rotZ,
                                            double posX, double posY, double posZ) {

        // Grab all the necessary information from the event
        PoseStack poseStack = event.getPoseStack();
        MultiBufferSource buffer = event.getMultiBufferSource();
        int packedLight = event.getPackedLight();
        float partialTicks = event.getPartialTick();

        rotX = (rotX + 180) % 360;

        // 1) Create or retrieve a PlayerModel to render
        ModelPart playerModelRoot = Minecraft.getInstance().getEntityModels().bakeLayer(ModelLayers.PLAYER);
        PlayerModel<Player> playerModel = new PlayerModel<>(playerModelRoot, false); // false => normal (non-slim) arms

        // 2) Push a new matrix to isolate transformations
        poseStack.pushPose();

        // 3) Apply main scaling factor for the body
        float bodyScale = 0.8F; // Adjust this value as needed for the body
        poseStack.scale(bodyScale, bodyScale, bodyScale);

        // 4) Apply position transformations (translate to desired position)
        poseStack.translate(posX, posY, posZ); // Translate model to desired position

        // === Changing the Pivot Point ===

        // Define your custom pivot point relative to the player's origin
        double pivotX = 0.0D; // Adjust these values as needed
        double pivotY = 0.5D;
        double pivotZ = 0.0D;

        // 5.1) Translate to the pivot point
        poseStack.translate(pivotX, pivotY, pivotZ);

        // 5.2) Apply rotation transformations around the new pivot

        poseStack.mulPose(Axis.YP.rotationDegrees(- rotY)); // Rotate around Y-axis
        poseStack.mulPose(Axis.ZP.rotationDegrees(- rotZ)); // Rotate around Z-axis
        poseStack.mulPose(Axis.XP.rotationDegrees(rotX)); // Rotate around X-axis

        // 5.3) Translate back from the pivot point
        poseStack.translate(-pivotX, -pivotY, -pivotZ);

        // === End of Pivot Point Adjustment ===

        // 6) Set up model animations (sitting pose)
        setupSittingPose(playerModel, player, partialTicks);

        // 7) Render body parts (excluding head)
        // Render the torso
        playerModel.body.render(poseStack, buffer.getBuffer(playerModel.renderType(getPlayerTexture(player))), packedLight, OverlayTexture.NO_OVERLAY);


        // Render legs
        playerModel.leftLeg.render(poseStack, buffer.getBuffer(playerModel.renderType(getPlayerTexture(player))), packedLight, OverlayTexture.NO_OVERLAY);
        playerModel.rightLeg.render(poseStack, buffer.getBuffer(playerModel.renderType(getPlayerTexture(player))), packedLight, OverlayTexture.NO_OVERLAY);

        float armScale = 0.8F; // Adjust this value as needed for the arms
        poseStack.pushPose();
        poseStack.scale(armScale, armScale, armScale);
        playerModel.leftArm.render(poseStack, buffer.getBuffer(playerModel.renderType(getPlayerTexture(player))), packedLight, OverlayTexture.NO_OVERLAY);
        playerModel.rightArm.render(poseStack, buffer.getBuffer(playerModel.renderType(getPlayerTexture(player))), packedLight, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();


        // 8) Render the head with adjusted scaling
        // Push a new matrix for the head
        poseStack.pushPose();

        // Define head scaling factor (less than 1 to make it smaller)
        float headScale = 0.9F; // Adjust this value as needed for the head

        // Apply scaling to the head
        poseStack.scale(headScale, headScale, headScale);

        // Optional: Adjust the head's position if it appears offset after scaling
        // For example, translate upwards to align with the body
        // poseStack.translate(0.0D, 0.1D, 0.0D); // Modify values as needed

        // Render the head
        playerModel.head.render(poseStack, buffer.getBuffer(playerModel.renderType(getPlayerTexture(player))), packedLight, OverlayTexture.NO_OVERLAY);

        // Pop the head's transformation matrix
        poseStack.popPose();

        // 9) Pop the main matrix
        poseStack.popPose();
    }


    private static void setupSittingPose(PlayerModel<Player> playerModel, Player player, float partialTicks) {
        // Calculate ageInTicks if needed for animations
        float ageInTicks = player.tickCount + partialTicks;

        // Set up model animations
        playerModel.setupAnim(player, 0.0F, 0.0F, ageInTicks, 0.0F, 0.0F);

        // Adjust legs for sitting
        // Rotate the legs forward by 90 degrees around the X-axis
        float legRotation =  - 90.0F; // Adjust as needed
        playerModel.leftLeg.xRot = (float) Math.toRadians(legRotation);
        playerModel.rightLeg.xRot = (float) Math.toRadians(legRotation);

        // Optionally, bend the knees slightly
        playerModel.leftLeg.zRot = (float) Math.toRadians(10.0F); // Adjust as needed
        playerModel.rightLeg.zRot = (float) Math.toRadians(-10.0F); // Adjust as needed

        // Adjust arms for sitting
        // For example, lower the arms to rest on the lap
        float armRotationX = - 45.0F; // Rotate arms downward
        playerModel.leftArm.xRot = (float) Math.toRadians(armRotationX);
        playerModel.rightArm.xRot = (float) Math.toRadians(armRotationX);

        // Optionally, rotate arms slightly inward
        playerModel.leftArm.zRot = (float) Math.toRadians(-10.0F); // Adjust as needed
        playerModel.rightArm.zRot = (float) Math.toRadians(10.0F); // Adjust as needed
    }



    /**
     * Retrieves the player's skin texture. Falls back to Steve's skin if unavailable.
     */
    private static ResourceLocation getPlayerTexture(Player player) {
        if (player instanceof AbstractClientPlayer clientPlayer) {
            return clientPlayer.getSkinTextureLocation();
        }
        // Fallback texture
        return new ResourceLocation("textures/entity/steve.png");
    }

    private static boolean isHoldingItem(Player player, Item item) {
        return player.getMainHandItem().getItem() == item ||
                player.getOffhandItem().getItem() == item;
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