package fr.thoridan.planes.entity.custom.models.rafale;

import fr.thoridan.planes.entity.custom.PlaneStructure;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class GreenRafale extends PlaneStructure {

    protected float xOffset = 0;
    protected float yOffset = 0;
    protected float zOffset = 0;

    public GreenRafale(EntityType<? extends PlaneStructure> type, Level world) {
        super(type, world);
        this.health = 100f;
        this.maxSpeed = 3f;
        this.acceleration = 0.7f;
        this.deceleration = 0.5f;
        this.invertSubtlety = 0.3f;
        this.yRiderOffset = 1f;
        this.invisibleRider = false;
    }

    @Override
    protected void addingTick(){
//        System.out.println("Aaaaaa");
        this.level().addParticle(ParticleTypes.FLAME, this.getX() , this.getY() , this.getZ() , 0, 0, 0);
    }
}

