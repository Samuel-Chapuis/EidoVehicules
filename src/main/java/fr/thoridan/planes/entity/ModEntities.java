package fr.thoridan.planes.entity;

import fr.thoridan.planes.ForPlanes;
import fr.thoridan.planes.entity.custom.models.rafale.GreenRafale;
import fr.thoridan.planes.entity.custom.models.rafale.NormalRafale;
import fr.thoridan.planes.entity.custom.models.YellowPlane;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Handles the registration of custom entities for the ForPlanes mod.
 * This class utilizes DeferredRegister to safely and efficiently register new entity types
 * with Forge's registry system.
 */
public class ModEntities {

	/**
	 * DeferredRegister instance for registering entity types.
	 * Associates the entity types with the mod's unique identifier.
	 */
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
			DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ForPlanes.MOD_ID);

	/**
	 * RegistryObject representing the YellowPlane entity type.
	 * This entity is categorized under MobCategory.MISC and has defined dimensions.
	 */
	public static final RegistryObject<EntityType<YellowPlane>> YELLOW_PLANE = ENTITY_TYPES.register("yellow_plane",
			() -> EntityType.Builder.<YellowPlane>of(YellowPlane::new, MobCategory.MISC)
					.sized(1.5F, 1.5F) // Dimensions of the YellowPlane (width, height)
					.build(new ResourceLocation(ForPlanes.MOD_ID, "yellow_plane").toString()));

	/**
	 * RegistryObject representing the NormalRafale entity type.
	 * This Rafale variant is categorized under MobCategory.MISC and has defined dimensions.
	 */
	public static final RegistryObject<EntityType<NormalRafale>> NORMAL_RAFALE = ENTITY_TYPES.register("normal_rafale",
			() -> EntityType.Builder.<NormalRafale>of(NormalRafale::new, MobCategory.MISC)
					.sized(4F, 3F) // Dimensions of the NormalRafale (width, height)
					.build(new ResourceLocation(ForPlanes.MOD_ID, "normal_rafale").toString()));

	/**
	 * RegistryObject representing the GreenRafale entity type.
	 * This Rafale variant is categorized under MobCategory.MISC and has defined dimensions.
	 */
	public static final RegistryObject<EntityType<GreenRafale>> GREEN_RAFALE = ENTITY_TYPES.register("green_rafale",
			() -> EntityType.Builder.<GreenRafale>of(GreenRafale::new, MobCategory.MISC)
					.sized(4F, 3F) // Dimensions of the GreenRafale (width, height)
					.build(new ResourceLocation(ForPlanes.MOD_ID, "green_rafale").toString()));

	/**
	 * Registers all custom entity types with the provided event bus.
	 * This method should be called during the mod's initialization phase to ensure
	 * that all entities are registered correctly.
	 *
	 * @param eventBus The mod's event bus used for registering entity types.
	 */
	public static void register(IEventBus eventBus) {
		ENTITY_TYPES.register(eventBus);
	}
}
