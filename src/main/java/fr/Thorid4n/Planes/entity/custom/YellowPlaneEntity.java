package fr.Thorid4n.Planes.entity.custom;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import org.jetbrains.annotations.Nullable;

public class YellowPlaneEntity extends Entity {

    private float health = 20.0f; // Points de vie de l’avion
	private float currentSpeed = 0.0f;
	private final float maxSpeed = 1.5f; // Vitesse maximale de l'avion
	private final float acceleration = 0.02f; // Vitesse d'accélération
	private final float deceleration = 0.01f; // Vitesse de décélération
	private float minSpeed = 0.4f;

    public YellowPlaneEntity(EntityType<? extends Entity> type, Level world) {
        super(type, world);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected void defineSynchedData() {
        // Méthode obligatoire pour les entités ; à implémenter selon tes besoins
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {
        this.health = compound.getFloat("Health"); // Charge la santé lors de la sauvegarde
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putFloat("Health", this.health); // Sauvegarde la santé
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
        return super.hurt(source, amount);
    }

    private void dropItem() {
        // Remplace Blocks.DIRT par l'item que tu veux faire tomber (par exemple, un item spécifique à l'avion)
        ItemStack itemStack = new ItemStack(Blocks.DIRT);
        ItemEntity itemEntity = new ItemEntity(this.getCommandSenderWorld(), this.getX(), this.getY(), this.getZ(), itemStack);
        this.getCommandSenderWorld().addFreshEntity(itemEntity);
    }

    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        return false; // Assure-toi que l'entité n'est pas invulnérable
    }

	public boolean isMovingForward() {
		return this.getDeltaMovement().horizontalDistanceSqr() > 0.001;
	}

    @Override
    public boolean isPickable() {
        return true; // Rend l'entité "attrapable"
    }

    @Override
    public boolean isPushable() {
        return true; // Rend l'entité "poussable"
    }

    @Override
    public AABB getBoundingBoxForCulling() {
        return this.getBoundingBox();
    }

    // Gérer l'ajout du conducteur uniquement
    @Override
    public void addPassenger(Entity passenger) {
        // Si le passager est un joueur et que l'avion n'a pas encore de conducteur
        if (passenger instanceof Player && this.getPassengers().isEmpty()) {
            super.addPassenger(passenger);
            System.out.println("Un joueur a été ajouté comme conducteur.");
            this.customPositionRider(passenger);
        }
    }

    // Positionner le conducteur dans l'avion
    protected void customPositionRider(Entity passenger) {
        if (this.hasPassenger(passenger)) {
            // System.out.println("Le joueur est bien reconnu comme conducteur.");
            double xOffset = 0.0D;
            double yOffset = 0.6D; // Ajuste la hauteur pour que le joueur soit assis correctement
            double zOffset = 0.0D;

            passenger.setPos(this.getX() + xOffset, this.getY() + yOffset, this.getZ() + zOffset);
        } else {
            // System.out.println("Le joueur n'est pas reconnu comme conducteur.");
        }
    }

    @Override
    public boolean canAddPassenger(Entity passenger) {
        // Limite à un seul passager pour cet avion (le conducteur)
        return this.getPassengers().isEmpty();
    }

    @Override
    public double getPassengersRidingOffset() {
        return 0.6D; // Ajuste la hauteur à laquelle le joueur est assis
    }

    // Permettre au joueur de monter dans l'avion
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
		return player.zza > 0; // `zza` est le champ qui correspond au mouvement vers l'avant
	}

	@Override
	public void tick() {
		super.tick();
	

		if (this.onGround()) {
			minSpeed = 0.0f; // L'avion peut rester immobile au sol
		} else {
			minSpeed = 0.4f; // L'avion doit maintenir une vitesse minimale en vol
		}


		if (this.isVehicle() && this.getControllingPassenger() instanceof Player) {
			Player player = (Player) this.getControllingPassenger();
	
			// Mise à jour des valeurs de rotation pour une interpolation fluide
			this.yRotO = this.getYRot(); // Ancien angle Yaw (gauche/droite)
			this.setYRot(player.getYRot()); // Nouvel angle Yaw (gauche/droite)
	
			// Synchroniser l'inclinaison X (pitch, verticale) de l'avion avec celle du joueur
			this.setXRot(player.getXRot()); // Le pitch est directement lié à l'inclinaison avant/arrière
			this.setRot(this.getYRot(), this.getXRot());
	
			// Gestion de l'accélération et de la décélération
			if (isPlayerMovingForward(player)) { // Vérifie si le joueur avance
				this.currentSpeed += this.acceleration;
				if (this.currentSpeed > this.maxSpeed) {
					this.currentSpeed = this.maxSpeed;
				}
			} else { // Le joueur ne maintient pas la touche pour avancer
				this.currentSpeed -= this.deceleration;
				if (this.currentSpeed < 0) {
					this.currentSpeed = 0;
				}
			}
	
			// Calcul du mouvement en fonction de la rotation actuelle de l'avion
			double motionX = -Math.sin(Math.toRadians(this.getYRot())) * this.currentSpeed;
			double motionZ = Math.cos(Math.toRadians(this.getYRot())) * this.currentSpeed;
			double motionY = -Math.sin(Math.toRadians(this.getXRot())) * this.currentSpeed; // Utilise l'inclinaison (pitch) pour déterminer la montée ou la descente
	

			if (this.currentSpeed < 0.3f) {
				motionY -= 0.15;
			}

			this.setDeltaMovement(motionX, motionY, motionZ);
			this.move(MoverType.SELF, this.getDeltaMovement());
		}
	}

    @Override
    protected void removePassenger(Entity passenger) {
        super.removePassenger(passenger);
        if (passenger instanceof Player) {
            System.out.println("Le joueur a quitté l'avion.");
            // Code pour gérer la descente, si nécessaire
        }
    }

    @Override
    @Nullable
    public LivingEntity getControllingPassenger() {
        return (LivingEntity) this.getFirstPassenger(); // Retourne le premier passager comme LivingEntity
    }

	public boolean isBeingControlled() {
		return this.getControllingPassenger() instanceof Player;
	}
}
