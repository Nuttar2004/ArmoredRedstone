package baguchan.armored_redstone.register;

import baguchan.armored_redstone.entity.BaseArmorEntity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.IndirectEntityDamageSource;
import net.minecraft.world.entity.LivingEntity;

public class ModDamageSource {
	public static DamageSource fire(BaseArmorEntity p_19350_, LivingEntity controllingPassenger) {
		return (new IndirectEntityDamageSource("armored_redstone.onFire", p_19350_, controllingPassenger)).setIsFire();
	}
}