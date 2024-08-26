package fr.thoridan.planes.entity;

import fr.thoridan.planes.ForPlanes;
import fr.thoridan.planes.entity.custom.YellowPlaneEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ForPlanes.MOD_ID);

	public static final RegistryObject<EntityType<YellowPlaneEntity>> YELLOW_PLANE =
		ENTITY_TYPES.register("yellow_plane",
			() -> EntityType.Builder.of(YellowPlaneEntity::new, MobCategory.MISC)
					.sized(3.0f, 2.0f) // Taille de l'entité
					.build(new ResourceLocation(ForPlanes.MOD_ID, "yellow_plane").toString()));
				



    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
