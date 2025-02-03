package fr.thoridan.planes.item;

import fr.thoridan.planes.ForPlanes;
import fr.thoridan.planes.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


/**
 * Registers custom creative mode tabs for the ForPlanes mod.
 * Organizes mod-specific items and blocks within the Minecraft creative inventory.
 */
public class ModCreativeModTabs {

    /**
     * DeferredRegister instance for registering creative mode tabs.
     * Associates the tabs with the mod's unique identifier.
     */
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ForPlanes.MOD_ID);

    /**
     * RegistryObject representing the custom creative mode tab for ForPlanes.
     * This tab will contain all mod-specific items and blocks, making them easily accessible
     * within the creative inventory.
     */
    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("forplanes_tab",
            () -> CreativeModeTab.builder()
                    // Sets the icon for the creative tab. Here, Titanium serves as the representative icon.
                    .icon(() -> new ItemStack(ModItems.TITANIUM.get()))

                    // Sets the display title of the creative tab using a translatable component.
                    .title(Component.translatable("creativetab.forplanes_tab"))

                    // Defines which items and blocks appear in this creative tab.
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.TITANIUM.get());           // Titanium ingot
                        pOutput.accept(ModItems.RAW_TITANIUM.get());       // Raw Titanium ore
                        pOutput.accept(ModBlocks.TITANIUM_BLOCK.get());    // Titanium block
//                        pOutput.accept(ModBlocks.TITANIUM_ORE.get());      // Titanium ore
                        pOutput.accept(ModItems.DEBUG_TOOL_4PLANE.get());  // Debug Tool for Plane
                        pOutput.accept(ModItems.NORMAL_RAFALE_SPAWN_ITEM.get());  // Normal Rafale Spawn Item
                        pOutput.accept(ModItems.YELLOW_PLANE_SPAWN_ITEM.get());    // Blue Rafale Spawn Item
                    })

                    // Builds and returns the CreativeModeTab instance.
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