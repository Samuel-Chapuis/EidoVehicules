package fr.Eidolyth.item;

import fr.Eidolyth.EidoMod;
import fr.Eidolyth.entity.ModEntities;
import fr.Eidolyth.item.custom.DebugTool4Plane;
import fr.Eidolyth.item.custom.PlaneSpawnItem;
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
		DeferredRegister.create(ForgeRegistries.ITEMS, EidoMod.MODID); // This is a long list of items

	/**
	 *
	 * Debug Tools
	 *
	 **/
	public static final RegistryObject<Item> DEBUG_TOOL_4PLANE = ITEMS.register("debug_tool_4plane",
			() -> new DebugTool4Plane(new Item.Properties()));

	/**
	 *
	 * Vehicle Spawn Items
	 *
	 **/
	public static final RegistryObject<Item> NORMAL_RAFALE_SPAWN_ITEM = ITEMS.register(
			"normal_rafale_spawn_item",
			() -> new PlaneSpawnItem<>(
					ModEntities.NORMAL_RAFALE,
					new Item.Properties()
							.stacksTo(1)
			)
	);

	public static final RegistryObject<Item> YELLOW_PLANE_SPAWN_ITEM = ITEMS.register(
			"tourist_plane_spawn_item",
			() -> new PlaneSpawnItem<>(
					ModEntities.YELLOW_PLANE,
					new Item.Properties()
							.stacksTo(1)
			)
	);

	public static final RegistryObject<Item> A220_SPAWN_ITEM = ITEMS.register(
			"a220_spawn_item",
			() -> new PlaneSpawnItem<>(
					ModEntities.A220LAYER,
					new Item.Properties()
							.stacksTo(1)
			)
	);


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
