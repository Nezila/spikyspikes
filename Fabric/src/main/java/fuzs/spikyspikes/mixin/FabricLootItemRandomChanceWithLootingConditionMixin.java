package fuzs.spikyspikes.mixin;

import fuzs.spikyspikes.api.event.entity.living.LootingLevelCallback;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithLootingCondition;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(LootItemRandomChanceWithLootingCondition.class)
public abstract class FabricLootItemRandomChanceWithLootingConditionMixin {

    @ModifyVariable(method = "test", at = @At("LOAD"), ordinal = 0)
    public int test$modifyVariable$load$lootingLevel(int lootingLevel, LootContext lootContext) {
        Entity target = lootContext.getParamOrNull(LootContextParams.THIS_ENTITY);
        if (!(target instanceof LivingEntity livingEntity)) return lootingLevel;
        DamageSource damageSource = lootContext.getParamOrNull(LootContextParams.DAMAGE_SOURCE);
        return LootingLevelCallback.EVENT.invoker().onLootingLevel(livingEntity, damageSource, lootingLevel).orElseThrow();
    }
}
