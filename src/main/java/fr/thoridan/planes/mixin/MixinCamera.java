package fr.thoridan.planes.mixin;

import fr.thoridan.planes.ForPlanes;
import fr.thoridan.planes.entity.custom.PlaneStructure;
import net.minecraft.client.Camera;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Mixin for the Minecraft Camera class to adjust camera behavior when the player is in a PlaneStructure vehicle.
 */
@OnlyIn(Dist.CLIENT)
@Mixin(Camera.class)
public abstract class MixinCamera {

	/**
	 * Injects custom camera adjustments after the standard setup method executes.
	 *
	 * @param area         The current block getter area.
	 * @param entity       The entity for which the camera is being set up.
	 * @param thirdPerson  Flag indicating if the camera is in third-person view.
	 * @param inverseView  Flag for inverse view settings.
	 * @param tickDelta    The partial tick time.
	 * @param ci           Callback information for the injection.
	 */
	@Inject(method = "setup", at = @At("TAIL"))
	public void ia$setup(BlockGetter area, Entity entity, boolean thirdPerson, boolean inverseView, float tickDelta, CallbackInfo ci) {
		// Check if the entity is riding a PlaneStructure
		if (entity.getVehicle() instanceof PlaneStructure vehicle) {
			if (thirdPerson) {
				// Adjust the camera distance for third-person view based on the vehicle's camera settings
				move(-getMaxZoom(vehicle.getCameraDistance()), 0.0, 0.0);
			} else {
				// Compute the rotation in radians
				double offsetX;
				double offsetZ;
				double offsetY;

				if(vehicle.cameraOffset == 0){
					move(0.0D, vehicle.cameraOffset, 0.0D);
				}else {
					offsetX = Math.abs(vehicle.getInterpolate_roll() % 180) / (vehicle.cameraOffset * 100);
					offsetZ = vehicle.getInterpolate_roll() % 180 / (vehicle.cameraOffset * 100);
					offsetY = vehicle.yRiderOffset + vehicle.cameraOffset - Math.abs(vehicle.getRoll() % 180) / 80;
					move(offsetX, offsetY, offsetZ);
				}
			}

			// Optional: Integrate Cartridge functionality if applicable
			// For example, adjust camera based on active cartridge
			// Cartridge activeCartridge = vehicle.getActiveCartridge();
			// if (activeCartridge != null) {
			//     activeCartridge.applyCameraEffects(this);
			// }
		}
	}

	/**
	 * Moves the camera by the specified x, y, and z offsets.
	 *
	 * @param x The movement along the X-axis.
	 * @param y The movement along the Y-axis.
	 * @param z The movement along the Z-axis.
	 */
	@Shadow
	protected abstract void move(double x, double y, double z);

	/**
	 * Calculates the maximum zoom level based on the desired camera distance.
	 *
	 * @param desiredCameraDistance The desired distance for the camera zoom.
	 * @return The calculated maximum zoom level.
	 */
	@Shadow
	protected abstract double getMaxZoom(double desiredCameraDistance);
}