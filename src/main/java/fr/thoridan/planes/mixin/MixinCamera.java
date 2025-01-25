package fr.thoridan.planes.mixin;

import fr.thoridan.planes.entity.custom.PlaneStructure;
import fr.thoridan.planes.entity.custom.models.YellowPlane;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.client.Camera.class)
public abstract class MixinCamera {

	@Inject(method = "setup", at = @At("TAIL"))
	public void ia$setup(BlockGetter area, Entity entity, boolean thirdPerson, boolean inverseView, float tickDelta, CallbackInfo ci) {

		if( entity.getVehicle() instanceof PlaneStructure vehicle) {
			if (thirdPerson) {
				move(-getMaxZoom(vehicle.getCameraDistance()), 0.0, 0.0);
			}else{
				move(0.0D, vehicle.yRiderOffset, 0.0D);
			}
		}
	}
	@Shadow
	protected abstract void move(double x, double y, double z);

	@Shadow
	protected abstract double getMaxZoom(double desiredCameraDistance);

}
