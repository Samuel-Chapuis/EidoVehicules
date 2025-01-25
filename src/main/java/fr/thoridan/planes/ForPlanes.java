package fr.thoridan.planes;

import com.mojang.logging.LogUtils;

import fr.thoridan.planes.block.ModBlocks;
import fr.thoridan.planes.entity.ModEntities;
import fr.thoridan.planes.entity.client.models.YellowPlaneRenderer;
import fr.thoridan.planes.entity.client.models.rafale.RafaleGreenRenderer;
import fr.thoridan.planes.entity.client.models.rafale.RafaleNormalRenderer;
import fr.thoridan.planes.event.KeyInputHandler;
import fr.thoridan.planes.item.ModCreativeModTabs;
import fr.thoridan.planes.item.ModItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;



// The value here should match an entry in the META-INF/mods.toml file
@Mod(ForPlanes.MOD_ID)
public class ForPlanes {
    public static final String MOD_ID = "forplanes";

    public ForPlanes() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		ModCreativeModTabs.register(modEventBus);		// Register the creative tab
		ModItems.register(modEventBus);					// Register the items
		ModBlocks.register(modEventBus);				// Register the blocks
		ModEntities.register(modEventBus);				// Register the entities


        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
		if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {

		}
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
			EntityRenderers.register(ModEntities.YELLOW_PLANE.get(), YellowPlaneRenderer::new);
            EntityRenderers.register(ModEntities.NORMAL_RAFALE.get(), RafaleNormalRenderer::new);
            EntityRenderers.register(ModEntities.GREEN_RAFALE.get(), RafaleGreenRenderer::new);
        }
    }
}
