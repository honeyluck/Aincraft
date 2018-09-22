package com.honeyluck.ain.events;


import com.honeyluck.ain.Aincraft;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = Aincraft.MOD_ID)
public class Registries {

    public static List<Item> ITEMS = new ArrayList<>();
    public static List<Block> BLOCKS = new ArrayList<>();

    //Items

    //Blocks


    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> e) {
        IForgeRegistry<Block> reg = e.getRegistry();
        reg.registerAll(BLOCKS.toArray(new Block[BLOCKS.size()]));
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> e) {
        IForgeRegistry<Item> reg = e.getRegistry();
        reg.registerAll(ITEMS.toArray(new Item[ITEMS.size()]));
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        for (Block block : BLOCKS) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "normal"));
        }
        for (Item item : ITEMS) {
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }
    }

    public static Item createItem(Item item, String name) {
        item.setUnlocalizedName(name);
        item.setRegistryName(name);
        ITEMS.add(item);
        return item;
    }

    public static Block createBlock(Block block, String name) {
        block.setUnlocalizedName(name);
        block.setRegistryName(name);
        BLOCKS.add(block);
        ITEMS.add(new ItemBlock(block).setRegistryName(name));
        return block;
    }
}
