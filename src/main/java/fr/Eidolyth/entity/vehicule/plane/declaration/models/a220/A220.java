package fr.Eidolyth.entity.vehicule.plane.declaration.models.a220;

import fr.Eidolyth.entity.vehicule.plane.PlaneStructure;
import fr.Eidolyth.item.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;


/**
 * Represents the NormalRafale entity, a high-performance aircraft in the ForPlanes mod.
 * Extends the {@link PlaneStructure} class to inherit base functionalities for planes,
 * with specific values and behaviors defined for the NormalRafale.
 */
public class A220 extends PlaneStructure {

    /* --------------------- */
    /* --- Constructors --- */
    /* --------------------- */

    /**
     * Constructs a new NormalRafale entity with predefined attributes and behaviors.
     *
     * @param type  The {@link EntityType} of the NormalRafale.
     * @param world The {@link Level} in which the NormalRafale exists.
     */
    public A220(EntityType<? extends PlaneStructure> type, Level world) {
        super(type, world);

        this.drop = ModItems.A220_SPAWN_ITEM.get();
        this.health = 1f;
        this.maxSpeed = 4f;
        this.acceleration = 0.03f;
        this.deceleration = 0.02f;
        this.invertSubtlety = 0.3f;
        this.yRiderOffset = 1.0f;
        this.cameraOffset = 0.2f;
        this.invisibleRider = true;
        this.cameraDistance = 48D;
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