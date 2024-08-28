package fr.thoridan.planes.entity.custom.models;

import fr.thoridan.planes.entity.custom.PlaneStructure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class YellowPlane extends PlaneStructure {

    protected float propellerRotation = 0.0F;   // Rotation de l'hélice
    public YellowPlane(EntityType<? extends PlaneStructure> type, Level world) {
        super(type, world);
        this.health = 20f;
        this.maxSpeed = 1.5f;
        this.acceleration = 0.2f;
        this.deceleration = 0.1f;
        this.invertSubtlety = 0.3f;
    }

    @Override
    protected void addingControlledTicks(){
        this.updatePropeller();
    }



    protected void updatePropeller() {
        this.propellerRotation += this.getCurrentSpeed() * 0.3F; // Ajustez le facteur pour contrôler la vitesse de rotation
        if (this.propellerRotation > 360.0F) {
            this.propellerRotation -= 360.0F; // Réinitialise l'angle si on dépasse 360 degrés
        }
    }

    public float getPropellerRotation() {
        return this.propellerRotation;
    }

}