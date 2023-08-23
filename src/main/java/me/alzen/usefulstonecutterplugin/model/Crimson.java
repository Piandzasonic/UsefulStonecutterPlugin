package me.alzen.usefulstonecutterplugin.model;

import me.alzen.usefulstonecutterplugin.UsefulStonecutterPlugin;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class Crimson extends InputPlank{
    public Crimson(UsefulStonecutterPlugin plugin){
        keys = new ArrayList<>();
        String keyPrefix = "custom_crimson_";
        keys.add(new NamespacedKey(plugin, keyPrefix + "slab"));
        keys.add(new NamespacedKey(plugin, keyPrefix + "stair"));
        keys.add(new NamespacedKey(plugin, keyPrefix + "fence"));
        keys.add(new NamespacedKey(plugin, keyPrefix + "fence_gate"));
        keys.add(new NamespacedKey(plugin, keyPrefix + "trapdoor"));
        keys.add(new NamespacedKey(plugin, keyPrefix + "pressure_plate"));
        keys.add(new NamespacedKey(plugin, keyPrefix + "sign"));

        inputPlank = new ItemStack(Material.CRIMSON_PLANKS);

        outputBlocks = new ArrayList<>();
        outputBlocks.add(new ItemStack(Material.CRIMSON_SLAB, 2));
        outputBlocks.add(new ItemStack(Material.CRIMSON_STAIRS));
        outputBlocks.add(new ItemStack(Material.CRIMSON_FENCE, 2));
        outputBlocks.add(new ItemStack(Material.CRIMSON_FENCE_GATE, 2));
        outputBlocks.add(new ItemStack(Material.CRIMSON_TRAPDOOR, 3));
        outputBlocks.add(new ItemStack(Material.CRIMSON_PRESSURE_PLATE, 4));
        outputBlocks.add(new ItemStack(Material.CRIMSON_SIGN, 2));

        if(plugin.getServer().getBukkitVersion().contains("1.20")){
            keys.add(new NamespacedKey(plugin, keyPrefix + "hanging_sign"));
            outputBlocks.add(new ItemStack(Material.CRIMSON_HANGING_SIGN, 2));
        }
    }
}
