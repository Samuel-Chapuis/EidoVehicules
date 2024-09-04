package fr.thoridan.planes.entity.custom.models.rafale;

import fr.thoridan.planes.entity.custom.PlaneStructure;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class GreenRafale extends PlaneStructure {

    protected float xOffset = 0;
    protected float yOffset = 0;
    protected float zOffset = 0;
    private double distanceBehind = -10.6;
    private double offsetX;
    private double offsetY;
    private double offsetZ;

    public GreenRafale(EntityType<? extends PlaneStructure> type, Level world) {
        super(type, world);
        this.health = 100f;
        this.maxSpeed = 3f;
        this.acceleration = 0.7f;
        this.deceleration = 0.5f;
        this.invertSubtlety = 0.3f;
        this.yRiderOffset = 1f;
        this.invisibleRider = false;
        this.cameraDistance = 64D; //64
    }

    @Override
    protected void addingTick(){
//        System.out.println("Aaaaaa");

        float yaw = (float) Math.toRadians(this.yRotO);
        float pitch = (float) Math.toRadians(this.xRotO);

        this.offsetX = -Math.sin(yaw) * Math.cos(pitch);
        this.offsetY = -Math.sin(pitch);
        this.offsetZ = Math.cos(yaw) * Math.cos(pitch);

        double particleX = this.getX() + offsetX * this.distanceBehind;
        double particleY = this.getY() + offsetY * this.distanceBehind;
        double particleZ = this.getZ() + offsetZ * this.distanceBehind;

        for (int i = 0; i < 5; i++) {
            this.level().addParticle(ParticleTypes.FLAME, particleX, particleY, particleZ, 0, 0, 0);
        }
    }
}

