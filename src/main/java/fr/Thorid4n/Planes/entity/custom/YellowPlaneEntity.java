package fr.Thorid4n.Planes.entity.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

public class YellowPlaneEntity extends Entity {
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
        // Gérer la sauvegarde de l'état de l'entité ici
    }

	@Override
    protected void addAdditionalSaveData(CompoundTag compound) {
        // Gérer la sauvegarde de l'état de l'entité ici
    }
}
