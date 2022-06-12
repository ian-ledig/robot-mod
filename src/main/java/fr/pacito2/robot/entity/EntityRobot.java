package fr.pacito2.robot.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class EntityRobot extends PathAwareEntity {
    public EntityRobot(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }
}
