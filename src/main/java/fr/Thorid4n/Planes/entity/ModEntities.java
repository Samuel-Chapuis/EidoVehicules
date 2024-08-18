package fr.Thorid4n.Planes.entity;

import fr.Thorid4n.Planes.ForPlanes;
import fr.Thorid4n.Planes.entity.custom.RhinoEntity;
import fr.Thorid4n.Planes.entity.custom.YellowPlaneEntity;
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

    public static final RegistryObject<EntityType<RhinoEntity>> RHINO =
            ENTITY_TYPES.register("rhino", () -> EntityType.Builder.of(RhinoEntity::new, MobCategory.CREATURE)
                    .sized(2.5f, 2.5f).build("rhino"));

	public static final RegistryObject<EntityType<YellowPlaneEntity>> YELLOW_PLANE =
	ENTITY_TYPES.register("yellow_plane",
		() -> EntityType.Builder.of(YellowPlaneEntity::new, MobCategory.CREATURE)
				.sized(1.0f, 1.0f) // Taille de l'entité
				.build(new ResourceLocation(ForPlanes.MOD_ID, "yellow_plane").toString()));
				



    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
