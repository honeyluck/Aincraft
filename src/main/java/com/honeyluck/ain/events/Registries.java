package com.honeyluck.ain.events;

import com.honeyluck.ain.Aincraft;
import com.honeyluck.ain.common.blocks.BlockBase;
import com.honeyluck.ain.common.items.ItemIngot;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = Aincraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Registries {

    public static List<Item> ITEMS = new ArrayList<>();
    public static List<Block> BLOCKS = new ArrayList<>();

    //Items
    public static Item blackIron = createItem(new ItemIngot(), "black_iron");
    //Blocks
    public static Block blackIronBlock = createBlock(new BlockBase(Block.Properties.create(Material.IRON), SoundType.METAL, 5.0F, 6.0F), "black_iron_block");
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> e) {
        e.getRegistry().registerAll(ITEMS.toArray(new Item[ITEMS.size()]));
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> e) {
        e.getRegistry().registerAll(BLOCKS.toArray(new Block[BLOCKS.size()]));
    }

    public static Item createItem(Item item, String name) {
        item.setRegistryName(name);
        ITEMS.add(item);
        return item;
    }

    public static Block createBlock(Block block, String name) {
        block.setRegistryName(name);
        BLOCKS.add(block);
        ITEMS.add(new BlockItem(block, new Item.Properties()).setRegistryName(name));
        return block;
    }
}
