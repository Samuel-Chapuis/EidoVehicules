package fr.Eidolyth.item;

import fr.Eidolyth.EidoMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


/**
 * Registers custom creative mode tabs for the EidoVehicles mod.
 * Organizes mod-specific items and blocks within the Minecraft creative inventory.
 */
public class ModCreativeModTabs {

    /**
     * DeferredRegister instance for registering creative mode tabs.
     * Associates the tabs with the mod's unique identifier.
     */
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EidoMod.MODID);

    /**
     * RegistryObject representing the custom creative mode tab for Vehicles.
     * This tab will contain all vehicle-related items, making them easily accessible
     * within the creative inventory.
     */
    public static final RegistryObject<CreativeModeTab> VEHICLES_TAB = CREATIVE_MODE_TABS.register("vehicles_eidovehicules",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.NORMAL_RAFALE_SPAWN_ITEM.get()))
                    .title(Component.translatable("creativetab.vehicles_eidovehicules"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.DEBUG_TOOL_4PLANE.get());             // Debug Tool for Planes
                        pOutput.accept(ModItems.NORMAL_RAFALE_SPAWN_ITEM.get());      // Normal Rafale Spawn Item
                        pOutput.accept(ModItems.YELLOW_PLANE_SPAWN_ITEM.get());       // Tourist Plane Spawn Item
                        pOutput.accept(ModItems.A220_SPAWN_ITEM.get());               // A220 Spawn Item
                    })
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .build());

    /**
     * Registers all creative mode tabs with the provided event bus.
     * This method should be called during the mod's initialization phase to ensure
     * that the creative tabs are registered at the appropriate time.
     *
     * @param eventBus The mod's event bus used for registering creative tabs.
     */
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}