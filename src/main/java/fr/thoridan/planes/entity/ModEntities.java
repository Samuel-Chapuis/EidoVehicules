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

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ForPlanes.MOD_ID);

	public static final RegistryObject<EntityType<YellowPlane>> YELLOW_PLANE = ENTITY_TYPES.register("yellow_plane",
			() -> EntityType.Builder.<YellowPlane>of(YellowPlane::new, MobCategory.MISC)
					.sized(1.5F, 1.5F) // dimensions de l'avion
					.build(new ResourceLocation(ForPlanes.MOD_ID, "yellow_plane").toString()));

	public static final RegistryObject<EntityType<NormalRafale>> NORMAL_RAFALE = ENTITY_TYPES.register("normal_rafale",
			() -> EntityType.Builder.<NormalRafale>of(NormalRafale::new, MobCategory.MISC)
					.sized(4F, 8F) // dimensions de l'avion
					.build(new ResourceLocation(ForPlanes.MOD_ID, "normal_rafale").toString()));

	public static final RegistryObject<EntityType<GreenRafale>> GREEN_RAFALE = ENTITY_TYPES.register("green_rafale",
			() -> EntityType.Builder.<GreenRafale>of(GreenRafale::new, MobCategory.MISC)
					.sized(4F, 8F) // dimensions de l'avion
					.build(new ResourceLocation(ForPlanes.MOD_ID, "green_rafale").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
