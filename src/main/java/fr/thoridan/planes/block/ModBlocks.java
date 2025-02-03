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

/**
 * Handles the registration of custom blocks for the ForPlanes mod.
 * Blocks are registered using Forge's {@link DeferredRegister} system.
 */
public class ModBlocks {
	// DeferredRegister to hold all custom blocks
	public static final DeferredRegister<Block> BLOCKS =
			DeferredRegister.create(ForgeRegistries.BLOCKS, ForPlanes.MOD_ID); // Registers blocks under the mod's namespace

	/* --------------------- */
	/* --- Block Entries --- */
	/* --------------------- */

	// Titanium Block: A block with properties similar to an Iron Block
	public static final RegistryObject<Block> TITANIUM_BLOCK = registerBlock("titanium_block",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

	// Titanium Ore: A block that drops experience when mined, similar to Cobblestone
//	public static final RegistryObject<Block> TITANIUM_ORE = registerBlock("titanium_ore",
//			() -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

	/* --------------------- */
	/* --- Helper Methods --- */
	/* --------------------- */

	/**
	 * Registers a block and its corresponding BlockItem.
	 *
	 * @param name  The registry name of the block.
	 * @param block A supplier that provides the block instance.
	 * @param <T>   The type of the block.
	 * @return A {@link RegistryObject} representing the registered block.
	 */
	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
		// Register the block
		RegistryObject<T> toReturn = BLOCKS.register(name, block);
		// Register the block as an item
		registerBlockItem(name, toReturn);
		return toReturn;
	}

	/**
	 * Registers a BlockItem for a given block.
	 *
	 * @param name  The registry name of the block item.
	 * @param block The {@link RegistryObject} representing the block.
	 * @param <T>   The type of the block.
	 * @return A {@link RegistryObject} representing the registered BlockItem.
	 */
	private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
		return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
	}

	/**
	 * Registers all blocks in this class with the provided {@link IEventBus}.
	 *
	 * @param eventBus The event bus to register the blocks with.
	 */
	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
}
