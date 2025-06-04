package com.github.alexmodguy.alexscaves.mixin;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class FasterEatingMixin {

    @Inject(
            method = {"getUseDuration(Lnet/minecraft/world/item/ItemStack;)I"},
            remap = true,
            cancellable = true,
            at = @At(value = "RETURN")
    )
    public void ac_getUseDuration(ItemStack p_41454_, CallbackInfoReturnable<Integer> cir) {
        if (p_41454_.getItem().isEdible()) {
            cir.setReturnValue(p_41454_.getFoodProperties(null).isFastFood() ? 4 : 32);
        }
    }
}
