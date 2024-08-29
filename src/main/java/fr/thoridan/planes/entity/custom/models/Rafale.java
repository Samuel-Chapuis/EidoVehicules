package fr.thoridan.planes.entity.custom.models;

import fr.thoridan.planes.entity.custom.PlaneStructure;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class Rafale extends PlaneStructure {

    public Rafale(EntityType<? extends PlaneStructure> type, Level world) {
        super(type, world);
        this.health = 100f;
        this.maxSpeed = 3f;
        this.acceleration = 0.7f;
        this.deceleration = 0.5f;
        this.invertSubtlety = 0.3f;
        this.yRiderOffset = 1f;
        this.invisibleRider = true;
    }

    @Override
    protected void addingControlledTicks(){

    }
}