package fr.Thorid4n.Planes.mixin.client;

import net.minecraft.client.Camera;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import fr.Thorid4n.Planes.entity.custom.YellowPlaneEntity;

@Mixin(Camera.class)
public abstract class CameraMixin {
    @Inject(method = "setup", at = @At("HEAD"))
    private void onSetup(BlockGetter level, Entity entity, boolean detached, boolean thirdPersonReverse, float partialTick, CallbackInfo ci) {
        if (entity instanceof YellowPlaneEntity) { // Remplacez par votre entité d'avion
            // Manipulez la caméra ici
            this.move(0.0D, 2.0D, 5.0D); // Exemple de modification de la position de la caméra
        }
    }
}

