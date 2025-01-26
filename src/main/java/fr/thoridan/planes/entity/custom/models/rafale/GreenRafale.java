package fr.thoridan.planes.entity.custom.models.rafale;

import fr.thoridan.planes.Globals;
import fr.thoridan.planes.entity.custom.PlaneStructure;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * Represents the GreenRafale entity, a variation of the Rafale aircraft in the ForPlanes mod.
 * This class inherits from {@link PlaneStructure} and defines unique properties for the GreenRafale.
 */
public class GreenRafale extends PlaneStructure {

    /* --------------------- */
    /* --- Constructors --- */
    /* --------------------- */

    /**
     * Constructs a new GreenRafale entity with predefined attributes and behaviors.
     *
     * @param type  The {@link EntityType} of the GreenRafale.
     * @param world The {@link Level} in which the GreenRafale exists.
     */
    public GreenRafale(EntityType<? extends PlaneStructure> type, Level world) {
        super(type, world);

        // Initialize default attributes for the GreenRafale
        this.health = 100f;                // Sets the health of the GreenRafale
        this.maxSpeed = 4f;                // Maximum speed the GreenRafale can achieve
        this.acceleration = 0.7f;          // Acceleration rate of the GreenRafale
        this.deceleration = 0.5f;          // Deceleration (braking) rate of the GreenRafale
        this.invertSubtlety = 0.3f;        // Subtlety factor influencing control inversions
        this.yRiderOffset = 0.8f;          // Vertical offset for rider positioning
        this.invisibleRider = false;       // Keeps the rider visible when in the GreenRafale
        this.cameraDistance = 64D;         // Sets the camera's distance from the GreenRafale
    }

    /* --------------------- */
    /* --- Overridden Methods --- */
    /* --------------------- */

    /**
     * Custom behavior for the GreenRafale, called every game tick.
     * Currently, no specific tick-based logic is implemented for this aircraft.
     */
    @Override
    protected void addingTick() {
        // No additional behavior defined for GreenRafale during ticks.
        // Add custom logic here if needed in the future.
    }
}
