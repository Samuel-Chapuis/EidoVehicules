package fr.thoridan.planes.entity.custom.models.rafale;

import fr.thoridan.planes.entity.custom.PlaneStructure;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

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

        // Setting default attributes for the NormalRafale
        this.health = 100f;                 // Health of the Rafale, representing durability
        this.maxSpeed = 4f;                 // Maximum speed achievable by the Rafale
        this.acceleration = 0.09f;          // Sets the acceleration rate of the plane
        this.deceleration = 0.07f;          // Sets the deceleration (braking) rate of the planeafale
        this.invertSubtlety = 0.3f;         // Subtlety factor influencing control inversions
        this.yRiderOffset = 0.8f;           // Vertical offset for rider positioning
        this.cameraOffset = 0.8f;           // Camera offset for the rider's view
        this.invisibleRider = true;         // Makes the rider invisible when inside the Rafale
        this.cameraDistance = 64D;          // Distance of the camera from the Rafale
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
