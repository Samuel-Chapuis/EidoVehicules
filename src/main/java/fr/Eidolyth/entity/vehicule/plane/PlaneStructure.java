package fr.Eidolyth.entity.vehicule.plane;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundTeleportEntityPacket;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

/**
 * Abstract class representing the structure and behavior of a plane entity within the game.
 * This class extends the base {@link Entity} class and provides custom functionalities
 * such as movement control, passenger management, and interaction handling specific to planes.
 */
public abstract class PlaneStructure extends Entity {

    /* --------------------- */
    /* --- Variables --- */
    /* --------------------- */

    private float currentSpeed = 0.0f;             // Current speed of the plane
    private float minSpeed = 0.0f;                 // Minimum speed of the plane
    private float targetYaw;                       // Target rotation on the Y-axis (yaw) based on player input
    private float targetPitch;                     // Target rotation on the X-axis (pitch) based on player input
    private float yawSpeed = 2.0f;                 // Speed at which the plane interpolates towards the target yaw
    private float pitchSpeed = 2.0f;               // Speed at which the plane interpolates towards the target pitch
    private float previousRoll = 0.0f;             // Previous roll angle of the plane
    private float roll = 0.0f;                     // Current roll angle of the plane
    private float interpolate_roll = 0.0f;         // Interpolated roll angle for smooth transitions
    private float interpolate_pitch = 0.0f;        // Interpolated pitch angle for smooth transitions
    protected float health;                        // Health of the plane
    protected float maxSpeed;                      // Maximum speed the plane can achieve
    protected double cameraDistance;               // Distance of the camera from the plane
    protected float acceleration;                  // Acceleration rate of the plane
    protected float deceleration;                  // Deceleration (braking) rate of the plane
    protected float invertSubtlety;                // Factor influencing subtle inversions in movement
    public float xRiderOffset = 0;              // X-axis offset for the passenger's position
    public float yRiderOffset = 0;                 // Y-axis offset for the passenger's position
    public float zRiderOffset = 0;              // Z-axis offset for the passenger's position
    public float cameraOffset = 0;                 // Camera offset for the passenger's position
    protected boolean invisibleRider = false;      // Flag to determine if the passenger is invisible
    protected Item drop = Blocks.DIRT.asItem();    // Item dropped by the plane upon destruction
    protected Level level;                         // Reference to the current game level
    protected float red = 1.0F;                    // Red tint value for colorable texture
    protected float green = 1.0F;                  // Green tint value for colorable texture
    protected float blue = 1.0F;                   // Blue tint value for colorable texture
    protected float alpha = 1.0F;                  // Alpha value for colorable texture

    /* --------------------- */
    /* --- Abstract Methods --- */
    /* --------------------- */

    /**
     * Abstract method to be implemented by subclasses.
     * Intended for adding custom tick-based logic specific to the plane.
     */
    protected abstract void addingTick();

    /* --------------------- */
    /* --- Constructors --- */
    /* --------------------- */

    /**
     * Constructs a new PlaneStructure entity.
     *
     * @param type  The {@link EntityType} of the plane.
     * @param world The current {@link Level} in which the plane exists.
     */
    public PlaneStructure(EntityType<? extends Entity> type, Level world) {
        super(type, world);
        this.level = world;
    }

    /* --------------------- */
    /* --- Private Methods --- */
    /* --------------------- */

    /**
     * Calculates the maximum pitch angle based on the current speed of the plane.
     * Higher speeds allow for greater pitch angles, simulating more dynamic maneuvers.
     *
     * @return The calculated maximum pitch angle.
     */
    private float calculateMaxPitchBasedOnSpeed() {
        /* The higher the speed, the greater the maximum pitch angle */
        return this.currentSpeed * 20f;
    }

    /**
     * Stabilizes the roll of the plane by adjusting its yaw rotation.
     * Gradually reduces the roll angle towards zero to maintain level flight.
     */
    private void stabilizeRoll() {
        this.roll = this.getRoll();

        if (Math.abs(roll) > 0.1f) { // Interpolation threshold to prevent minor fluctuations
            if (roll > 0) {
                // Adjust the yaw rotation to reduce positive roll
                this.setYRot(this.getYRot() - Math.min(2.0f, roll));
            } else {
                // Adjust the yaw rotation to reduce negative roll
                this.setYRot(this.getYRot() + Math.min(2.0f, -roll));
            }
        } else {
            // Directly counteract the remaining roll to achieve level flight
            this.setYRot(this.getYRot() - roll);
        }
    }

    /**
     * Drops an item from the plane upon its destruction.
     * Currently set to drop dirt blocks, but can be customized to drop specific items.
     */
    private void dropItem() {
        // TODO: Replace Blocks.DIRT with the desired drop item (e.g., a specific item for the plane)
        ItemStack itemStack = new ItemStack(drop);
        ItemEntity itemEntity = new ItemEntity(this.getCommandSenderWorld(), this.getX(), this.getY(), this.getZ(), itemStack);
        this.getCommandSenderWorld().addFreshEntity(itemEntity);
    }

    /* --------------------- */
    /* --- Overridden Methods --- */
    /* --------------------- */

    /**
     * Defines synchronized data parameters for the plane.
     * Used for data that needs to be synchronized between the client and server.
     */
    @Override
    protected void defineSynchedData() {
        /* Define synchronized data here if needed */
    }

    /**
     * Handles the removal of a passenger from the plane.
     * Adjusts the plane's state and ensures proper synchronization across client and server.
     *
     * @param passenger The entity being removed from the plane.
     */
    @Override
    protected void removePassenger(Entity passenger) {
        super.removePassenger(passenger);
        if (passenger instanceof Player) {
            if (this.onGround()) {
                // Reset movement and rotation if the plane is on the ground
                this.setDeltaMovement(0, 0, 0);
                this.setXRot(0);
                passenger.setInvisible(false);
            }

            // Update the plane's position and rotation
            this.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), this.getXRot());
            if (!this.level().isClientSide) {
                /* Force the entity to update on the client side */
                this.level().getServer().getPlayerList().broadcast(
                        null,
                        this.getX(),
                        this.getY(),
                        this.getZ(),
                        64.0,
                        this.level().dimension(),
                        new ClientboundTeleportEntityPacket(this)
                );
            }
            // this.stabilizeRoll(); // Uncomment if roll stabilization is needed upon passenger removal
//            System.out.println("Le joueur a quitté l'avion."); // Debug message indicating passenger exit
        }
    }

    /**
     * Reads additional save data from NBT when the plane entity is loaded.
     *
     * @param compound The {@link CompoundTag} containing saved data.
     */
    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {
        /* Read additional save data here if needed */
        this.health = compound.getFloat("Health");
    }

    /**
     * Writes additional save data to NBT when the plane entity is saved.
     *
     * @param compound The {@link CompoundTag} where data should be written.
     */
    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {
        /* Write additional save data here if needed */
        compound.putFloat("Health", this.health);
    }

    /**
     * Creates the network packet required to spawn the entity on the client.
     *
     * @return The {@link Packet} used to spawn the entity.
     */
    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    /**
     * Handles damage inflicted on the plane.
     * Reduces the plane's health and triggers item drops and entity removal if health depletes.
     *
     * @param source The {@link DamageSource} causing the damage.
     * @param amount The amount of damage to apply.
     * @return {@code true} indicating the damage was handled.
     */
    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (!level().isClientSide && this.isAlive()) {
            this.health -= amount;
            if (this.health <= 0.0f) {
                this.dropItem();
                this.remove(RemovalReason.KILLED);
            }
        }
        return true;
    }

    // Some mods or versions also have isAttackable():
    @Override
    public boolean isAttackable() {
        return true; // indicates that the entity can be attacked
    }

    @Override
    public boolean skipAttackInteraction(Entity attacker) {
        return false; // means "don't skip", so allow normal attack handling
    }

    /**
     * Checks if the plane is currently moving forward.
     *
     * @return {@code true} if the plane's horizontal movement speed is above a threshold; {@code false} otherwise.
     */
    public boolean isMovingForward() {
        return this.getDeltaMovement().horizontalDistanceSqr() > 0.001;
    }

    /**
     * Retrieves the current camera distance from the plane.
     *
     * @return The camera distance.
     */
    public double getCameraDistance() {
        return this.cameraDistance;
    }

    /**
     * Gets the bounding box used for culling the plane entity.
     *
     * @return The axis-aligned bounding box (AABB) of the plane.
     */
    @Override
    public AABB getBoundingBoxForCulling() {
        return this.getBoundingBox();
    }

    /**
     * Adds a passenger to the plane.
     * Ensures that only one player can be the driver at a time and manages passenger visibility.
     *
     * @param passenger The entity to add as a passenger.
     */
    @Override
    public void addPassenger(Entity passenger) {
        /* If the passenger is a player and the plane has no driver yet */
        if (passenger instanceof Player && this.getPassengers().isEmpty()) {
            super.addPassenger(passenger);
//            System.out.println("Un joueur a été ajouté comme conducteur."); // Debug message indicating passenger addition
            this.positionRider(passenger); // Position the passenger within the plane
            passenger.setInvisible(invisibleRider); // Set passenger visibility based on the plane's settings
        }
    }

//    @Override
//    protected void positionRider(Entity passenger, MoveFunction moveFunction) {
//        // If we're only dealing with one rider
//        if (!this.hasPassenger(passenger)) return;
//
//        // Convert degrees to radians for math
//        float yawRad = (float) Math.toRadians(this.getYRot());
//        float pitchRad = (float) Math.toRadians(this.getXRot());
//
//        // Example seat offsets (the seat is behind the plane’s origin by 1.2 blocks,
//        // up 0.3 blocks, etc). You can tweak these to your liking.
//        // Usually you read them from your entity fields or from a seat array if multiple seats.
//        double localX = this.xRiderOffset;
//        double localY = this.yRiderOffset;
//        double localZ = this.zRiderOffset;
//
//        // If your plane can roll, you may need more advanced rotation logic,
//        // but often yaw + pitch is enough. Or build a small rotation matrix
//        // that includes roll as well if your plane is truly 3D in motion.
//
//        // The simplest version: rotate around yaw, then pitch.
//        // (Ignoring roll for demonstration, but you can incorporate it if you like.)
//        // 1) Apply yaw
//        double seatPosX = localX * Math.cos(yawRad) - localZ * Math.sin(yawRad);
//        double seatPosZ = localX * Math.sin(yawRad) + localZ * Math.cos(yawRad);
//        double seatPosY = localY; // If you want pitch to affect seat Y, do more trig.
//
//        // Optionally incorporate pitch
//        // seatPosY += -seatPosZ * Math.sin(pitchRad);
//        // seatPosZ *= Math.cos(pitchRad);
//
//        // Now translate the result by the plane’s absolute world position
//        double finalX = this.getX() + seatPosX;
//        double finalY = this.getY() + seatPosY;
//        double finalZ = this.getZ() + seatPosZ;
//
//        passenger.setPos(finalX, finalY, finalZ);
//        // If you want the passenger to face the same yaw as the plane:
//        passenger.setYRot(this.getYRot());
//        passenger.setXRot(this.getXRot());
//    }


    /**
     * Determines if a passenger can be added to the plane.
     * Currently limits the plane to one passenger (the driver).
     *
     * @param passenger The entity attempting to mount the plane.
     * @return {@code true} if no passengers are currently present; {@code false} otherwise.
     */
    @Override
    public boolean canAddPassenger(Entity passenger) {
        /* Limit to one passenger for this plane (the driver) */
        return this.getPassengers().isEmpty();

        //TODO: Add logic to allow more passengers if needed
    }

    /**
     * Gets the vertical offset for where passengers sit within the plane.
     *
     * @return The Y-axis offset for passenger positioning.
     */
    @Override
    public double getPassengersRidingOffset() {
        /* Adjust the height at which the player is sitting */
        return 0.8D;
    }

    /**
     * Determines if the plane entity can be picked (interacted with) by players.
     *
     * @return {@code true} to allow player interactions with the plane.
     */
    @Override
    public boolean isPickable() {
        /* Allow player to interact with the plane */
        return true;
    }

    /**
     * Handles interaction events when a player interacts with the plane.
     * Allows players to mount the plane if it has no current driver.
     *
     * @param player The player interacting with the plane.
     * @param hand   The hand (main or offhand) used for interaction.
     * @return The result of the interaction.
     */
    @Override
    public InteractionResult interact(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (!this.getCommandSenderWorld().isClientSide) {
            if (this.getPassengers().isEmpty()) {
//                System.out.println("Le joueur tente de monter dans l'avion."); // Debug message indicating mounting attempt
                player.startRiding(this); // Player mounts the plane
                return InteractionResult.SUCCESS;
            } else {
//                System.out.println("L'avion a déjà un conducteur."); // Debug message indicating the plane already has a driver
            }
        }

        if (player.isShiftKeyDown() && itemStack.getItem() instanceof DyeItem dyeItem) {
            // Get the color from the dye
            DyeColor dyeColor = dyeItem.getDyeColor();
            float[] rgb = dyeColor.getTextureDiffuseColors(); // Directly gets normalized RGB values

            // Update the plane's color
            setColor(rgb[0], rgb[1], rgb[2], 1.0F);

            // Reduce the dye item stack by 1 (unless in creative mode)
            if (!player.getAbilities().instabuild) {
                itemStack.shrink(1);
            }

            // Provide feedback to the player
            player.displayClientMessage(Component.literal("Plane color updated to " + dyeColor.getName() + "!"), true);

            return InteractionResult.SUCCESS;
        }

        return InteractionResult.CONSUME;
    }

    /**
     * Checks if the player is moving forward.
     *
     * @param player The player entity to check.
     * @return {@code true} if the player is moving forward; {@code false} otherwise.
     */
    private boolean isPlayerMovingForward(Player player) {
        /* 'zaa' is the field that corresponds to moving forward */
        return player.zza > 0;
    }

    /**
     * Checks if the player is moving backward.
     *
     * @param player The player entity to check.
     * @return {@code true} if the player is moving backward; {@code false} otherwise.
     */
    private boolean isPlayerMovingBackward(Player player) {
        /* 'zaa' is the field that corresponds to moving backward */
        return player.zza < 0;
    }

    /**
     * Controls the plane's movement and rotation based on player input and current state.
     * Manages acceleration, deceleration, rotation smoothing, and speed constraints.
     */
    private void control() {

        if (this.onGround()) {
            /* If the plane is on the ground, the minimum speed is 0 to allow clear landing */
            minSpeed = 0.0f;

        } else {
            /* To add a realistic effect, the plane must maintain a minimum speed in flight */
            minSpeed = invertSubtlety;
        }

        if (this.isVehicle() && this.getControllingPassenger() instanceof Player) {
            Player player = (Player) this.getControllingPassenger();

            /* Update the target rotation values based on the player's head rotation */
            targetYaw = player.getYHeadRot();
            targetPitch = player.getXRot();

            /* Limit the pitch based on the current speed to simulate realistic physics */
            float maxPitch = calculateMaxPitchBasedOnSpeed();
            if (targetPitch > maxPitch) {
                /* No need to block the descent angle */
                // Additional logic can be added here if needed
            }
            else if (targetPitch < -maxPitch) {
                /* Limit the climb angle to prevent unrealistic pitch */
                //TODO: Improve the logic to limit the climb angle
                targetPitch = -maxPitch;
            }
            if(this.onGround() && targetPitch < 0){
                /* Prevent the plane from pitching downward when on the ground */
                targetPitch = 0;
            }

            /* Smoothly interpolate to the target rotation */
            float yawDifference = targetYaw - this.getYRot();
            if (Math.abs(yawDifference) > 180.0f) {
                /* Manage the transition to 360° to prevent abrupt rotation changes */
                //TODO: Improve the logic to manage the transition to 360°
                yawDifference -= Math.signum(yawDifference) * 360.0f;
            }

            float newYaw = this.getYRot() + Math.min(yawSpeed, Math.abs(yawDifference)) * Math.signum(yawDifference);
            this.setYRot(newYaw);

            float pitchDifference = targetPitch - this.getXRot();
            float newPitch = this.getXRot() + Math.min(pitchSpeed, Math.abs(pitchDifference)) * Math.signum(pitchDifference);
            this.setXRot(newPitch);

            /* Acceleration and braking management based on player input */
            if (isPlayerMovingForward(player)) {
                /* Player is accelerating the plane forward */
                this.currentSpeed += this.acceleration;
                if (this.currentSpeed > this.maxSpeed) {
                    this.currentSpeed = this.maxSpeed; // Cap the speed to the maximum limit
                }
            } else if (isPlayerMovingBackward(player)) {
                /* Player is decelerating the plane */

                if (this.onGround()){
                    this.currentSpeed -= this.acceleration * 7;
                }
                else{
                    this.currentSpeed -= this.deceleration * 0.7;
                }
                if (this.currentSpeed < minSpeed) {
                    this.currentSpeed = minSpeed; // Prevent the plane from moving backward beyond minSpeed
                }
            } else {
                /* If the player is not providing input, gradually decelerate the plane */
                this.currentSpeed -= this.deceleration * 0.2;
                if (this.currentSpeed < minSpeed) {
                    this.currentSpeed = minSpeed; // Maintain minimum speed to prevent reversing
                }
            }

        } else {
            /* If there is no controlling passenger, gradually decelerate and stabilize the plane's roll */
            this.currentSpeed -= this.deceleration;
            if (this.currentSpeed < minSpeed) {
                this.currentSpeed = minSpeed;
            }
            this.stabilizeRoll();
        }

        /* Prevent the speed from becoming negative */
        if (this.currentSpeed < 0.0f) {
            this.currentSpeed = 0.0f;
        }

        /* Calculate the plane's movement based on its current rotation and speed */
        double motionX = -Math.sin(Math.toRadians(this.getYRot())) * this.currentSpeed;
        double motionZ = Math.cos(Math.toRadians(this.getYRot())) * this.currentSpeed;
        double motionY = -Math.sin(Math.toRadians(this.getXRot())) * this.currentSpeed;

        /* Add a slight downward force to simulate gravity and prevent the plane from staying aloft at low speeds */
        if (this.currentSpeed < invertSubtlety * 1.3) {
            motionY -= invertSubtlety;
        }

        /* Apply the calculated movement to the plane */
        this.setDeltaMovement(motionX, motionY, motionZ);
        this.move(MoverType.SELF, this.getDeltaMovement());

    }

    /**
     * Retrieves the current speed of the plane.
     *
     * @return The current speed.
     */
    public float getCurrentSpeed() {
        return this.currentSpeed;
    }

    /**
     * Retrieves the controlling passenger of the plane.
     *
     * @return The {@link LivingEntity} controlling the plane, or {@code null} if none.
     */
    @Override
    @Nullable
    public LivingEntity getControllingPassenger() {
        /* Return the first passenger as a LivingEntity */
        return (LivingEntity) this.getFirstPassenger();
    }

    /**
     * Checks if the plane is currently being controlled by a player.
     *
     * @return {@code true} if the controlling passenger is a player; {@code false} otherwise.
     */
    public boolean isBeingControlled() {
        return this.getControllingPassenger() instanceof Player;
    }

    /**
     * Calculates the current roll angle of the plane based on its yaw rotation.
     *
     * @return The current roll angle.
     */
    public float getRoll() {
        if (this.onGround()) {
            /* No roll when the plane is on the ground */
            return 0.0f;
        }
        float yawDifference = this.targetYaw - this.getYRot();
        if (Math.abs(yawDifference) > 180.0f) { // Manage 360° rotation transitions
            yawDifference -= Math.signum(yawDifference) * 360.0f;
        }
        return -yawDifference; // Negative sign to invert the roll direction
    }

    /**
     * Retrieves the previous roll angle of the plane.
     *
     * @return The previous roll angle.
     */
    public float getPreviousRoll(){
        return this.previousRoll;
    }

    /**
     * Updates the plane's state each tick.
     * Handles movement control, roll stabilization, and custom tick logic.
     */
    @Override
    public void tick() {
        super.tick();
        this.previousRoll = this.getRoll(); // Update the previous roll angle
        this.control();                      // Apply movement and rotation controls

        addingTick();                        // Invoke custom tick logic from subclasses

        if (!this.level().isClientSide) {
            /* Update the plane's position and rotation on the server side */
            this.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), this.getXRot());
        } else {
            /* Client-side specific logic can be added here if needed */
        }
    }

    /**
     * Sets the interpolated roll angle for the plane.
     *
     * @param interpolate_roll The new interpolated roll angle.
     */
    public void setInterpolate_roll(float interpolate_roll) {
        this.interpolate_roll = interpolate_roll;
    }

    /**
     * Retrieves the interpolated roll angle of the plane.
     *
     * @return The interpolated roll angle.
     */
    public float getInterpolate_roll() {
        return this.interpolate_roll;
    }

    public float getRed() {
        return red;
    }
    public float getGreen() {
        return green;
    }
    public float getBlue() {
        return blue;
    }
    public float getAlpha() {
        return alpha;
    }
    public void setColor(float red, float green, float blue, float alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    public void setInterpolate_pitch(float interpolate_pitch) {
        this.interpolate_pitch = interpolate_pitch;
    }

    public float getInterpolate_pitch() {
        return this.interpolate_pitch;
    }
}
