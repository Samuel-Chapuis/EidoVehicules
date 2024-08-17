package fr.Thorid4n.Planes.item;

import fr.Thorid4n.Planes.ForPlanes;
import fr.Thorid4n.Planes.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ForPlanes.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("forplanes_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TITANIUM.get()))
                    .title(Component.translatable("creativetab.forplanes_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.TITANIUM.get());
                        pOutput.accept(ModItems.RAW_TITANIUM.get());
						pOutput.accept(ModBlocks.TITANIUM_BLOCK.get());


                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
