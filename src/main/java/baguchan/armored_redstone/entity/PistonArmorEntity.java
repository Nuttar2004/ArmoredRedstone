package baguchan.armored_redstone.entity;

import baguchan.armored_redstone.ArmoredRedstone;
import baguchan.armored_redstone.message.ArmorAttackMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeMod;

public class PistonArmorEntity extends BaseArmorEntity{
	private static final EntityDataAccessor<Integer> DATA_ATTACK = SynchedEntityData.defineId(PistonArmorEntity.class, EntityDataSerializers.INT);

	public PistonArmorEntity(EntityType<? extends PistonArmorEntity> p_20966_, Level p_20967_) {
		super(p_20966_, p_20967_);
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_ATTACK, 0);
	}

	@Override
	public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
		super.onSyncedDataUpdated(p_21104_);
		if (DATA_ATTACK.equals(p_21104_)) {
			if(this.getAttackTick() == 1){
				this.playSound(SoundEvents.PISTON_CONTRACT, 1.1F, 1.15F);
			}
		}
	}

	@Override
	public void tick() {
		super.tick();
		if(this.getAttackTick() > 0) {
			this.setAttackTick(this.getAttackTick() - 1);
		}
	}

	@Override
	public void attack() {
		Vec3 vec3d = this.getViewVector(1.0F);
		if (this.getAttackTick() == 0) {
			for (Entity entity : this.level.getEntitiesOfClass(Entity.class, this.getBoundingBox().inflate(0.75D, 0.25D, 0.75D).move(vec3d.x * 1.6D, vec3d.y * 1.6D, vec3d.z * 1.6D))) {
				if (entity != this && (this.getControllingPassenger() == null || this.getControllingPassenger() != null && entity != this.getControllingPassenger()) && !this.isAlliedTo(entity) && (entity.isAttackable() && this.distanceTo(entity) < 26.0D)) {
					this.doHurtTarget(entity);
					entity.playSound(SoundEvents.PLAYER_ATTACK_KNOCKBACK, 2.0F, 1.0F);
				}
			}
			this.setAttackTick(24);
			this.playSound(SoundEvents.PISTON_EXTEND, 1.0F, 1.15F);
		}
	}

	@Override
	public void secondAttack() {

	}

	@OnlyIn(Dist.CLIENT)
	protected void updateClientControls() {
		Minecraft mc = Minecraft.getInstance();

		if (mc.player != null && this.hasPassenger(mc.player)) {

			if (mc.options.keyAttack.isDown()) {
				if (this.getAttackTick() == 0) {
					attackingStart();
				}
			}
		}
	}

	public void setAttackTick(int attackTick) {
		this.entityData.set(DATA_ATTACK, attackTick);
	}

	public int getAttackTick() {
		return this.entityData.get(DATA_ATTACK);
	}

	private void attackingStart() {
		ArmoredRedstone.CHANNEL.sendToServer(new ArmorAttackMessage(this));
	}

	protected boolean isAttacked(){
		return getAttackTick() > 0;
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 100.0D).add(ForgeMod.STEP_HEIGHT_ADDITION.get(), 1.0F).add(Attributes.ARMOR, 12.0F).add(Attributes.ARMOR_TOUGHNESS, 1.0F).add(Attributes.MOVEMENT_SPEED, 0.26D).add(Attributes.KNOCKBACK_RESISTANCE, 0.75D).add(Attributes.ATTACK_DAMAGE, 12.0D).add(Attributes.ATTACK_KNOCKBACK, 1.75D);
	}
}
