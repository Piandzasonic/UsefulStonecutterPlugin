package me.alzen.usefulstonecutterplugin.model;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.StonecuttingRecipe;

import java.util.List;

public class InputPlank {
    protected List<NamespacedKey> keys;
    protected ItemStack inputPlank;
    protected List<ItemStack> outputBlocks;

    public void registerRecipe(){
        for(int ptr = 0; ptr < keys.size(); ptr++){
            Bukkit.addRecipe(new StonecuttingRecipe(keys.get(ptr), outputBlocks.get(ptr), inputPlank.getType()));
        }
    }
}
