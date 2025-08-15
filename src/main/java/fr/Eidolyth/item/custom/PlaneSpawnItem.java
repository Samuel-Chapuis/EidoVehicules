package fr.Eidolyth.item.custom;

import fr.Eidolyth.entity.vehicule.plane.PlaneStructure;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.function.Supplier;

public class PlaneSpawnItem<T extends PlaneStructure> extends Item {

    // Use a Supplier so we don't call get() on the RegistryObject prematurely
    private final Supplier<EntityType<T>> planeTypeSupplier;

    public PlaneSpawnItem(Supplier<EntityType<T>> planeTypeSupplier, Properties properties) {
        super(properties);
        this.planeTypeSupplier = planeTypeSupplier;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            // Retrieve the EntityType *now*, after registration has completed
            EntityType<T> planeType = planeTypeSupplier.get();

            // Decide where the plane spawns (in front of the player, for example)
            Vec3 lookVec = player.getLookAngle().scale(2);
            double spawnX = player.getX() + lookVec.x;
            double spawnY = player.getY() + 1.0;  // just above player's feet
            double spawnZ = player.getZ() + lookVec.z;

            // Create plane instance from the stored EntityType
            T plane = planeType.create(level);
            if (plane != null) {
                plane.setPos(spawnX, spawnY, spawnZ);
                plane.setYRot(player.getYRot()); // Orient plane to player's yaw

                level.addFreshEntity(plane);
            }
        }

        return new InteractionResultHolder<>(InteractionResult.SUCCESS, stack);
    }
}
