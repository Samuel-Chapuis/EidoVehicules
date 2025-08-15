package fr.Eidolyth.entity.vehicule.plane.declaration.models.rafale;

import fr.Eidolyth.entity.vehicule.plane.PlaneStructure;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

import static fr.Eidolyth.item.ModItems.NORMAL_RAFALE_SPAWN_ITEM;

/**
 * Represents the NormalRafale entity, a high-performance aircraft in the ForPlanes mod.
 * Extends the {@link PlaneStructure} class to inherit base functionalities for planes,
 * with specific values and behaviors defined for the NormalRafale.
 */
public class NormalRafale extends PlaneStructure {

    /* --------------------- */
    /* --- Constructors --- */
    /* --------------------- */

    /**
     * Constructs a new NormalRafale entity with predefined attributes and behaviors.
     *
     * @param type  The {@link EntityType} of the NormalRafale.
     * @param world The {@link Level} in which the NormalRafale exists.
     */
    public NormalRafale(EntityType<? extends PlaneStructure> type, Level world) {
        super(type, world);

        this.drop = NORMAL_RAFALE_SPAWN_ITEM.get();
        this.health = 1f;
        this.maxSpeed = 4f;
        this.acceleration = 0.03f;
        this.deceleration = 0.02f;
        this.invertSubtlety = 0.3f;
        this.yRiderOffset = 0.0f;
        this.cameraOffset = 0.8f;
        this.invisibleRider = true;
        this.cameraDistance = 24D;
    }

    /* --------------------- */
    /* --- Overridden Methods --- */
    /* --------------------- */

    /**
     * Custom behavior for the NormalRafale, called every game tick.
     * Currently, no specific tick-based logic is implemented for this aircraft.
     */
    @Override
    protected void addingTick() {
        // No additional behavior defined for NormalRafale during ticks.
        // Add custom logic here if needed in the future.
    }
}
