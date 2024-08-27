//package fr.thoridan.planes.event;
//
//import com.mojang.blaze3d.systems.RenderSystem;
//import com.mojang.blaze3d.vertex.PoseStack;
//import fr.thoridan.planes.entity.custom.YellowPlaneEntity;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.gui.Gui;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.client.event.RenderGuiOverlayEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//@Mod.EventBusSubscriber(modid = "forplanes", value = Dist.CLIENT)
//public class ModRenderEvents {
//
//    private static final ResourceLocation CUSTOM_CURSOR = new ResourceLocation("forplanes", "textures/gui/custom_cursor.png");
//
//    @SubscribeEvent
//    public static void onRenderCrosshair(RenderGuiOverlayEvent event) {
//        Minecraft minecraft = Minecraft.getInstance();
//        if (minecraft.getCameraEntity() instanceof YellowPlaneEntity planeEntity) {
//
//            PoseStack poseStack = event.getPoseStack();
//            int screenWidth = minecraft.getWindow().getGuiScaledWidth();
//            int screenHeight = minecraft.getWindow().getGuiScaledHeight();
//
//            // Position du curseur (calculé en fonction de la rotation de l’avion)
//            int cursorX = screenWidth / 2 + (int) (planeEntity.getYRot() * 0.5); // Ajuster le facteur selon votre besoin
//            int cursorY = screenHeight / 2 - (int) (planeEntity.getXRot() * 0.5);
//
//            // Rendu du curseur personnalisé
//            RenderSystem.setShaderTexture(0, CUSTOM_CURSOR);
////            Gui.blit(poseStack, cursorX, cursorY, 0, 0, 16, 16, 16, 16); // Taille 16x16, ajustez selon la texture utilisée
//        }
//    }
//}