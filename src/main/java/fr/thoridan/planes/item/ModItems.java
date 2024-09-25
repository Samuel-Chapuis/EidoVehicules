package fr.thoridan.planes.item;

import fr.thoridan.planes.ForPlanes;
import fr.thoridan.planes.item.custom.DebugTool4Plane;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS = 
		DeferredRegister.create(ForgeRegistries.ITEMS, ForPlanes.MOD_ID); // This is a long list of items

	public static final RegistryObject<Item> TITANIUM = ITEMS.register("titanium",
		() -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> RAW_TITANIUM = ITEMS.register("raw_titanium",
		() -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> DEBUG_TOOL_4PLANE = ITEMS.register("debug_tool_4plane",
			() -> new DebugTool4Plane(new Item.Properties()));

	
	public static void register(IEventBus eventBus) { // This is the register method
		ITEMS.register(eventBus);
	}

}
