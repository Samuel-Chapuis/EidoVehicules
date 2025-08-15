package fr.Eidolyth.client;

import fr.Eidolyth.EidoMod;
// Ensure this import matches the actual package and class name of AureoleLayer
import fr.Eidolyth.item.ModModelLayers;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.client.model.HumanoidModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = EidoMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
        });
    }

    @SubscribeEvent
    public static void onAddLayers(EntityRenderersEvent.AddLayers event) {
        for (String skin : event.getSkins()) {
            LivingEntityRenderer<?, ?> renderer = event.getSkin(skin);
            if (renderer instanceof HumanoidMobRenderer<?, ?> humanoidRenderer) {
                // Fix generics for AureoleLayer using Mob
                @SuppressWarnings("unchecked")
                HumanoidMobRenderer<Mob, HumanoidModel<Mob>> castedRenderer = (HumanoidMobRenderer<Mob, HumanoidModel<Mob>>) humanoidRenderer;
            }
        }
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {

    }
}

