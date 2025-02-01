package fr.thoridan.planes.entity.custom.models.tourist;

import fr.thoridan.planes.entity.custom.PlaneStructure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

import static fr.thoridan.planes.item.ModItems.NORMAL_RAFALE_SPAWN_ITEM;
import static fr.thoridan.planes.item.ModItems.YELLOW_PLANE_SPAWN_ITEM;

/**
 * Represents the YellowPlane entity, a specific type of PlaneStructure within the ForPlanes mod.
 * This class defines the properties and behaviors unique to the YellowPlane, such as propeller rotation.
 */
public class YellowPlane extends PlaneStructure {

    /* --------------------- */
    /* --- Variables --- */
    /* --------------------- */

    private float propellerRotation = 0.0F; // Rotation angle of the propeller in degrees

    /* --------------------- */
    /* --- Constructors --- */
    /* --------------------- */

    /**
     * Constructs a new YellowPlane entity.
     *
     * @param type  The {@link EntityType} of the YellowPlane.
     * @param world The current {@link Level} in which the YellowPlane exists.
     */
    public YellowPlane(EntityType<? extends PlaneStructure> type, Level world) {
        super(type, world);
        this.drop = YELLOW_PLANE_SPAWN_ITEM.get(); // Sets the item dropped when the plane is destroyed
        this.health = 1f;                 // Initializes the plane's health
        this.yRiderOffset = 0.2F;         // Sets the Y-axis offset for the passenger's position
        this.cameraOffset = 0.0F;         // Sets the camera offset for the passenger's view
        this.maxSpeed = 1.5f;              // Sets the maximum speed the plane can achieve
        this.acceleration = 0.02f;          // Sets the acceleration rate of the plane
        this.deceleration = 0.02f;          // Sets the deceleration (braking) rate of the plane
        this.invertSubtlety = 0.3f;        // Sets the subtlety factor influencing plane inversions
        this.cameraDistance = 6D;          // Sets the camera's distance from the plane
    }

    /* --------------------- */
    /* --- Overridden Methods --- */
    /* --------------------- */

    /**
     * Called each tick to perform custom logic specific to the YellowPlane.
     * If the plane is being controlled by a player, updates the propeller's rotation.
     */
    @Override
    protected void addingTick(){
        if (this.isBeingControlled()) {
            this.updatePropeller(); // Update the propeller's rotation based on current speed
        }
    }

    /* --------------------- */
    /* --- Custom Methods --- */
    /* --------------------- */

    /**
     * Updates the rotation angle of the propeller.
     * The rotation speed is influenced by the plane's current speed.
     * Ensures that the rotation angle wraps around upon reaching 360 degrees.
     */
    protected void updatePropeller() {
        this.propellerRotation += this.getCurrentSpeed() * 0.3F; // Adjust the factor to control propeller rotation speed
        if (this.propellerRotation > 360.0F) {
            this.propellerRotation -= 360.0F; // Reset the angle if it exceeds 360 degrees to maintain continuity
        }
    }

    /**
     * Retrieves the current rotation angle of the propeller.
     *
     * @return The propeller's rotation angle in degrees.
     */
    public float getPropellerRotation() {
        return this.propellerRotation;
    }
}
