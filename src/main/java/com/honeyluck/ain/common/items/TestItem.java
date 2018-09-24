package com.honeyluck.ain.common.items;

import com.honeyluck.ain.common.capability.CapabilityFairy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.event.AttachCapabilitiesEvent;

public class TestItem extends Item {

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand hand) {
        if(CapabilityFairy.get(player) != null) {

        }
        return new ActionResult<>(EnumActionResult.PASS, player.getHeldItem(hand));
    }

}
