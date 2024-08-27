package fr.thoridan.planes.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import fr.thoridan.planes.ForPlanes;
import fr.thoridan.planes.item.ModItems;


public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS = 
		DeferredRegister.create(ForgeRegistries.BLOCKS, ForPlanes.MOD_ID); // This is a long list of blocks

	
	public static final RegistryObject<Block> TITANIUM_BLOCK = registerBlock("titanium_block",
		() -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
	public static final RegistryObject<Block> TITANIUM_ORE = registerBlock("titanium_ore",
		() -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

	
	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
		RegistryObject<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn);
		return toReturn;
	}

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
		
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
