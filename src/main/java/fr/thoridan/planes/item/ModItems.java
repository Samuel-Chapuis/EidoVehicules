package fr.thoridan.planes.item;

import fr.thoridan.planes.ForPlanes;
import fr.thoridan.planes.item.custom.DebugTool4Plane;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


/**
 * Registry class for all custom items in the ForPlanes mod.
 * Utilizes DeferredRegister for thread-safe item registration with Forge.
 */
public class ModItems {
	/**
	 * DeferredRegister instance for registering items.
	 * Associates the items with the mod's unique identifier.
	 */
	public static final DeferredRegister<Item> ITEMS =
		DeferredRegister.create(ForgeRegistries.ITEMS, ForPlanes.MOD_ID); // This is a long list of items


	/**
	 * Titanium ingot item.
	 * Commonly used for crafting advanced plane components.
	 */
	public static final RegistryObject<Item> TITANIUM = ITEMS.register("titanium",
		() -> new Item(new Item.Properties()));

	/**
	 * Raw Titanium ore item.
	 * Mined and smelted into Titanium ingots.
	 */
	public static final RegistryObject<Item> RAW_TITANIUM = ITEMS.register("raw_titanium",
		() -> new Item(new Item.Properties()));

	/**
	 * Debug Tool for Plane-related debugging tasks.
	 * Provides special functionalities for developers during testing.
	 */
	public static final RegistryObject<Item> DEBUG_TOOL_4PLANE = ITEMS.register("debug_tool_4plane",
			() -> new DebugTool4Plane(new Item.Properties()));

	/**
	 * Registers all items with the provided event bus.
	 * Must be called during the mod's initialization phase.
	 *
	 * @param eventBus The mod's event bus to which items are registered.
	 */
	public static void register(IEventBus eventBus) { // This is the register method
		ITEMS.register(eventBus);
	}

}
