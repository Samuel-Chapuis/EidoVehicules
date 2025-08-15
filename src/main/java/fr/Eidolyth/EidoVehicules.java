package fr.Eidolyth;

import com.mojang.logging.LogUtils;
import fr.Eidolyth.entity.ModEntities;
import fr.Eidolyth.entity.vehicule.plane.render.models.tourist.ToursiticPlaneRenderer;
import fr.Eidolyth.entity.vehicule.plane.render.models.a220.A220Renderer;
import fr.Eidolyth.entity.vehicule.plane.render.models.rafale.RafaleNormalRenderer;
import fr.Eidolyth.item.ModCreativeModTabs;
import fr.Eidolyth.item.ModItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
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
import net.minecraftforge.server.ServerLifecycleHooks;
import org.slf4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(EidoVehicules.MODID)
public class EidoVehicules {
    public static final String MODID = "eidovehicules";
    private static final Logger LOGGER = LogUtils.getLogger();

    public EidoVehicules() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();


        ModEntities.register(modEventBus);             // Register the entities
		// ModBlocks.register(modEventBus);               // Register the blocks (REMOVED - Vehicle mod only)
		// ModBlockEntities.register(modEventBus);        // Register the block entities (REMOVED - Vehicle mod only)
		// ModMenus.register(modEventBus);                // Register the menus (REMOVED - Vehicle mod only)
        ModCreativeModTabs.register(modEventBus);      // Register the creative tab
        ModItems.register(modEventBus);                // Register the items


        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.addListener(this::addCreative);
//        modEventBus.addListener(this::addCreative);
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

    public static void broadcastServerMessage(String message, boolean actionBar) {
        // Forge's way to get the current MinecraftServer instance
        MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
        // Broadcast a "system" message. By default, it shows as
        // <Server> message
        // in chat if 'actionBar' is false.


        if (server == null) {
            LOGGER.warn("Tried to broadcast a server message, but the server is null!");
            return;
        }
        server.getPlayerList().broadcastSystemMessage(
                Component.literal(message),
                actionBar
        );
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
			EntityRenderers.register(ModEntities.YELLOW_PLANE.get(), ToursiticPlaneRenderer::new);
            EntityRenderers.register(ModEntities.NORMAL_RAFALE.get(), RafaleNormalRenderer::new);
            EntityRenderers.register(ModEntities.A220LAYER.get(), A220Renderer::new);
        }
    }
}
