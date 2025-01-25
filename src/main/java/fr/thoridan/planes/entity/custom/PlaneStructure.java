package fr.thoridan.planes.entity.custom;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;

import javax.swing.text.LabelView;

public abstract class PlaneStructure extends Entity {

    private float currentSpeed = 0.0f;
    private float minSpeed = 0.0f;                  // Minimale plane speed
    private float targetYaw;                        // Rotation on Y axis ( where the player is looking at)
    private float targetPitch;                      // Rotation on X axis ( where the player is looking at)
    private float yawSpeed = 2.0f;                  // Interpolation speed for yaw
    private float pitchSpeed = 2.0f;                // Interpolation speed for pitch
    private float previousRoll = 0.0f;              // Previous roll angle
    private float roll = 0.0f;                      // Roll angle
    private float interpolate_roll = 0.0f;                  // Max pitch angle
    protected float health;                         // Plane health
    protected float maxSpeed;                       // Max plane speed
    protected double cameraDistance;
    protected float acceleration;                   // Acceleration speed
    protected float deceleration;                   // Braking speed
    protected float invertSubtlety;                 // Sorte of inverted subtlety
    protected float xRiderOffset = 0;               // X offset of the player
    public float yRiderOffset = 0;               // Y offset of the player
    protected float zRiderOffset = 0;               // Z offset of the player
    protected boolean invisibleRider = false;      // Is the rider invisible
    protected Block drop = Blocks.DIRT;             // Item to drop when the plane is destroyed
    protected Level level;

    public Quaternionf Q_Client = new Quaternionf();
    public Quaternionf Q_Prev = new Quaternionf();

    public Quaternionf getQ_Client() {
        return Q_Client;
    }

    public Quaternionf getQ_Prev() {
        return Q_Prev;
    }

    public void setQ_Client(Quaternionf q) {
        Q_Client = q;
    }

    public void setQ_prev(Quaternionf q) {
        Q_Prev = q;
    }

    protected abstract void addingTick();

    public PlaneStructure(EntityType<? extends Entity> type, Level world) {
        super(type, world);
        this.level = world;
    }

    private float calculateMaxPitchBasedOnSpeed() {
        /* More the speed is high, more the max pitch is high */
        return this.currentSpeed * 20f;
    }

    private void stabilizeRoll() {
        this.roll = this.getRoll();

        if (Math.abs(roll) > 0.1f) { // Interpolation limit to 0.1f
            if (roll > 0) {
                this.setYRot(this.getYRot() - Math.min(2.0f, roll)); // Ajust the rotation to bring the roll back to 0
            } else {
                this.setYRot(this.getYRot() + Math.min(2.0f, -roll)); // Same
            }
        } else {
            this.setYRot(this.getYRot() - roll); // Go back to the previous roll -> 0
        }
    }

    private void dropItem() {
        // TODO: Replace Blocks.DIRT by the item you want to drop (e.g. a specific item for the plane)
        ItemStack itemStack = new ItemStack(drop);
        ItemEntity itemEntity = new ItemEntity(this.getCommandSenderWorld(), this.getX(), this.getY(), this.getZ(), itemStack);
        this.getCommandSenderWorld().addFreshEntity(itemEntity);
    }

    @Override
    protected void defineSynchedData() {
        /* This is where you define the synchronized data, to include if needed */
    }

    @Override
    protected void removePassenger(Entity passenger) {
        super.removePassenger(passenger);
        if (passenger instanceof Player) {
            if(this.onGround()){
                this.setDeltaMovement(0, 0, 0);
                this.setXRot(0);
                passenger.setInvisible(false);
            }

            this.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), this.getXRot());
            if (!this.level().isClientSide) {
                /* Force the entity to update on the client */
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
//            this.stabilizeRoll();
            System.out.println("Le joueur a quitté l'avion.");
        }

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {
        /* This is where you read the additional save data, to include if needed */
        this.health = compound.getFloat("Health");
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {
        /* This is where you add the additional save data, to include if needed */
        compound.putFloat("Health", this.health);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (!this.getCommandSenderWorld().isClientSide && this.isAlive()) {
            this.health -= amount;
            System.out.println("Santé de l'avion : " + this.health);

            if (this.health <= 0.0f) {
                this.dropItem();
                this.remove(RemovalReason.KILLED);
            }
        }
        return true; //super.hurt(source, amount)
    }

	public boolean isMovingForward() {
		return this.getDeltaMovement().horizontalDistanceSqr() > 0.001;
	}

    public double getCameraDistance() {
        return this.cameraDistance;
    }
    @Override
    public AABB getBoundingBoxForCulling() {
        return this.getBoundingBox();
    }

//    @Override
//    protected void positionRider(Entity passenger, MoveFunction moveFunction) {
//        if (this.hasPassenger(passenger)) {
//            // Place passenger at the seat offset
//            double seatX = this.getX() + xRiderOffset;
//            double seatY = this.getY() + yRiderOffset;
//            double seatZ = this.getZ() + zRiderOffset;
//
//            moveFunction.accept(passenger, seatX, seatY, seatZ);
//
//            // Now forcibly set the passenger's rotation to match the plane
//            if (passenger instanceof Player p) {
//                float planeYaw = this.getYRot();
//
//                p.yBodyRot  = planeYaw;
//                p.yBodyRotO = planeYaw;
//            }
//        }
//    }



    /* This is where you can add the logic to add the driver only */
    @Override
    public void addPassenger(Entity passenger) {
        /* If the passenger is a player and the plane has no driver yet */
        if (passenger instanceof Player && this.getPassengers().isEmpty()) {
            super.addPassenger(passenger);
            System.out.println("Un joueur a été ajouté comme conducteur.");
            this.positionRider(passenger);
            passenger.setInvisible(invisibleRider);
        }
    }

    @Override
    public boolean canAddPassenger(Entity passenger) {
        /* Limit to one passenger for this plane (the driver) */
        return this.getPassengers().isEmpty();

        //TODO: Add logic to allow more passengers if needed
    }

    @Override
    public double getPassengersRidingOffset() {
        /* Adjust the height at which the player is sitting */
        return 0.6D;
    }

    @Override
    public boolean isPickable() {
        /* Allow player to interact with the plane */
        return true;
    }

    /* This is where you can add the logic to allow the player to interact with the plane */
    @Override
    public InteractionResult interact(Player player, InteractionHand hand) {
        if (!this.getCommandSenderWorld().isClientSide) {
            if (this.getPassengers().isEmpty()) {
                System.out.println("Le joueur tente de monter dans l'avion.");
                player.startRiding(this); // Le joueur monte dans l'avion
                return InteractionResult.SUCCESS;
            } else {
                System.out.println("L'avion a déjà un conducteur.");
            }
        }
        return InteractionResult.CONSUME;
    }

	private boolean isPlayerMovingForward(Player player) {
        /* zaa is the field that corresponds to moving forward */
		return player.zza > 0;
	}

    private boolean isPlayerMovingBackward(Player player) {
        /* zaa is the field that corresponds to moving backward */
        return player.zza < 0;
    }

    private void control(){

        if (this.onGround()) {
            /* If the plane is on the ground, the minimum speed is 0, to allow clear landing */
            minSpeed = 0.0f;
        } else {
            /* To add a realistic effect, the plane must maintain a minimum speed in flight */
            minSpeed = invertSubtlety;
        }

        if (this.isVehicle() && this.getControllingPassenger() instanceof Player) {
            Player player = (Player) this.getControllingPassenger();

            /* Update the target rotation values based on the player */
            targetYaw = player.getYHeadRot();
            targetPitch = player.getXRot();

            /* Limit the pitch based on the current speed to simulate realitic physics */
            float maxPitch = calculateMaxPitchBasedOnSpeed();
            if (targetPitch > maxPitch) {
                /* No need to block the descent angle */
            }
            else if (targetPitch < -maxPitch) {
                /* Limit the climb */
                //TODO: Improve the logic to limit the climb angle
                targetPitch = -maxPitch;
            }
            if(this.onGround() && targetPitch < 0){
                targetPitch = 0;
            }

            /* Smooth interpolation to the target rotation */
            float yawDifference = targetYaw - this.getYRot();
            if (Math.abs(yawDifference) > 180.0f) {
                /* To manage the transition to 360° */
                //TODO: Improve the logic to manage the transition to 360°
                yawDifference -= Math.signum(yawDifference) * 360.0f;
            }

            float newYaw = this.getYRot() + Math.min(yawSpeed, Math.abs(yawDifference)) * Math.signum(yawDifference);
            this.setYRot(newYaw);

            float pitchDifference = targetPitch - this.getXRot();
            float newPitch = this.getXRot() + Math.min(pitchSpeed, Math.abs(pitchDifference)) * Math.signum(pitchDifference);
            this.setXRot(newPitch);

            /* Acceleration and braking management */
            if (isPlayerMovingForward(player)) {
                this.currentSpeed += this.acceleration;
                if (this.currentSpeed > this.maxSpeed) {
                    this.currentSpeed = this.maxSpeed;
                }
            } else if (isPlayerMovingBackward(player)) {
                this.currentSpeed -= this.acceleration*0.1;
                if (this.currentSpeed < this.minSpeed) {
                    this.currentSpeed = this.minSpeed; // Bloc the speed to minSpeed to avoid going backwards
                }
            } else {
                /* If the player is not moving forward or backward, the plane decelerates slowly */
                this.currentSpeed -= this.deceleration*0.1;
                if (this.currentSpeed < this.minSpeed) {
                    this.currentSpeed = this.minSpeed; // Bloc the speed to minSpeed to avoid going backwards
                }
            }



        } else{
            this.currentSpeed -= this.deceleration;
            if (this.currentSpeed < this.minSpeed) {
                this.currentSpeed = this.minSpeed;
            }
            this.stabilizeRoll();
        }

        /* Prevent the speed from becoming negative 8 */
        if (this.currentSpeed < 0.0f) {
            this.currentSpeed = 0.0f;
        }

        /* Calculate the movement based on the current rotation of the plane */
        double motionX = -Math.sin(Math.toRadians(this.getYRot())) * this.currentSpeed;
        double motionZ = Math.cos(Math.toRadians(this.getYRot())) * this.currentSpeed;
        double motionY = -Math.sin(Math.toRadians(this.getXRot())) * this.currentSpeed;

        /* Add a slight downward force to avoid staying in the air at low speed, it acts like a simili gravity */
        if (this.currentSpeed < invertSubtlety*1.3) {
            motionY -= invertSubtlety;
        }

        this.setDeltaMovement(motionX, motionY, motionZ);
        this.move(MoverType.SELF, this.getDeltaMovement());

    }

    public float getCurrentSpeed() {
        return this.currentSpeed;
    }

    @Override
    @Nullable
    public LivingEntity getControllingPassenger() {
        /* Return the first passenger as a LivingEntity */
        return (LivingEntity) this.getFirstPassenger();
    }

    public boolean isBeingControlled() {
        return this.getControllingPassenger() instanceof Player;
    }

    public float getRoll() {
        if(this.onGround()){
            return 0.0f;
        }
        float yawDifference = this.targetYaw - this.getYRot();
        if (Math.abs(yawDifference) > 180.0f) { // Use to manage the 360° transition
            yawDifference -= Math.signum(yawDifference) * 360.0f;
        }
        return - yawDifference; //*this.getCurrentSpeed()
    }

    public float getPreviousRoll(){
        return this.previousRoll;
    }

    @Override
    public void tick() {
        super.tick();
        this.previousRoll = this.getRoll();
        this.control();

        addingTick();


        if (!this.level().isClientSide) {
            this.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), this.getXRot());
        } else {
        }
    }

    public void setInterpolate_roll(float interpolate_roll) {
        this.interpolate_roll = interpolate_roll;
    }

    public float getInterpolate_roll() {
        return this.interpolate_roll;
    }

}
