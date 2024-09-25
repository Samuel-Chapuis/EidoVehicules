package fr.thoridan.planes.entity.custom.models.rafale;

import fr.thoridan.planes.entity.custom.PlaneStructure;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class NormalRafale extends PlaneStructure {



    public NormalRafale(EntityType<? extends PlaneStructure> type, Level world) {
        super(type, world);
        this.health = 100f;
        this.maxSpeed = 4f;
        this.acceleration = 0.7f;
        this.deceleration = 0.5f;
        this.invertSubtlety = 0.3f;
        this.yRiderOffset = 1f;
        this.invisibleRider = true;
        this.cameraDistance = 64D;
    }

    @Override
    protected void addingTick(){
//        System.out.println("Bbbbbb");
    }
}

