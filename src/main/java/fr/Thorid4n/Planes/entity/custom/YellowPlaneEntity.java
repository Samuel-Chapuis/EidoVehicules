package fr.Thorid4n.Planes.entity.custom;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.LivingEntity;
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
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import java.util.Collections;

public class YellowPlaneEntity extends LivingEntity {

    private float health = 20.0f; // Points de vie de l’avion

    public YellowPlaneEntity(EntityType<? extends LivingEntity> type, Level world) {
        super(type, world);
    }

    // Enregistrement des attributs
    public static AttributeSupplier.Builder createAttributes() {
        return LivingEntity.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.0D);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected void defineSynchedData() {
        // Pas besoin de définir la bounding box ici
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        return EntityDimensions.scalable(3.0F, 2.0F); // Taille de l'avion
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (!this.level().isClientSide && this.isAlive()) {
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
        ItemStack itemStack = new ItemStack(Blocks.DIRT);
        ItemEntity itemEntity = new ItemEntity(this.level(), this.getX(), this.getY(), this.getZ(), itemStack);
        this.level().addFreshEntity(itemEntity);
    }

    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        return false;
    }

    @Override
    public boolean isPickable() {
        return true;
    }

    @Override
    public boolean isPushable() {
        return true;
    }

    @Override
    public AABB getBoundingBoxForCulling() {
        return this.getBoundingBox();
    }

    @Override
    public boolean canAddPassenger(Entity passenger) {
        return this.getPassengers().size() < 1;
    }

    @Override
    public InteractionResult interact(Player player, InteractionHand hand) {
        if (!this.level().isClientSide) {
            player.startRiding(this);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.CONSUME;
    }

    @Override
    public void travel(Vec3 travelVector) {
        if (this.isVehicle() && this.getControllingPassenger() instanceof Player) {
            Player player = (Player) this.getControllingPassenger();

            this.setYRot(player.getYRot());
            this.yRotO = this.getYRot();
            this.setXRot(player.getXRot() * 0.5F);
            this.setRot(this.getYRot(), this.getXRot());

            float speed = 0.1f;
            double motionX = -Math.sin(Math.toRadians(this.getYRot())) * speed;
            double motionZ = Math.cos(Math.toRadians(this.getYRot())) * speed;

            this.setDeltaMovement(motionX, this.getDeltaMovement().y, motionZ);
            this.move(MoverType.SELF, this.getDeltaMovement());
        } else {
            super.travel(travelVector);
        }
    }

    @Override
    protected void removePassenger(Entity passenger) {
        super.removePassenger(passenger);
    }

    // Méthodes abstraites de LivingEntity à implémenter
    @Override
    public Iterable<ItemStack> getArmorSlots() {
        return Collections.emptyList();
    }

    @Override
    public ItemStack getItemBySlot(EquipmentSlot slot) {
        return ItemStack.EMPTY;
    }

    @Override
    public void setItemSlot(EquipmentSlot slot, ItemStack stack) {
        // Rien à faire ici, l'avion ne porte pas d'équipement
    }

    @Override
    public HumanoidArm getMainArm() {
        return HumanoidArm.RIGHT;
    }
}
