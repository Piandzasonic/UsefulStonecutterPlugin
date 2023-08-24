package me.alzen.usefulstonecutterplugin;

import me.alzen.usefulstonecutterplugin.bstats.Metrics;
import me.alzen.usefulstonecutterplugin.eventlistener.PlayerJoiningListener;
import me.alzen.usefulstonecutterplugin.model.*;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.StonecuttingRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.List;

public final class UsefulStonecutterPlugin extends JavaPlugin {

    private final String line = "===========================";

    @Override
    public void onEnable() {
        // Plugin startup logic
        int pluginId = 19619;
        Metrics metrics = new Metrics(this, pluginId);

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        List<Material> planks = new ArrayList<>();
        planks.add(Material.OAK_PLANKS);
        planks.add(Material.SPRUCE_PLANKS);
        planks.add(Material.BIRCH_PLANKS);
        planks.add(Material.JUNGLE_PLANKS);
        planks.add(Material.ACACIA_PLANKS);
        planks.add(Material.DARK_OAK_PLANKS);
        planks.add(Material.CRIMSON_PLANKS);
        planks.add(Material.WARPED_PLANKS);

        Acacia acacia = new Acacia(this);
        acacia.registerRecipe();

        Oak oak = new Oak(this);
        oak.registerRecipe();

        Spruce spruce = new Spruce(this);
        spruce.registerRecipe();

        Birch birch = new Birch(this);
        birch.registerRecipe();

        Jungle jungle = new Jungle(this);
        jungle.registerRecipe();

        DarkOak darkOak = new DarkOak(this);
        darkOak.registerRecipe();

        Crimson crimson = new Crimson(this);
        crimson.registerRecipe();

        Warped warped = new Warped(this);
        warped.registerRecipe();

        if(getServer().getBukkitVersion().contains("1.19")){
            Mangrove mangrove = new Mangrove(this);
            mangrove.registerRecipe();
            planks.add(Material.MANGROVE_PLANKS);
        }

        if(getServer().getBukkitVersion().contains("1.20")){
            Mangrove mangrove = new Mangrove(this);
            mangrove.registerRecipe();
            planks.add(Material.MANGROVE_PLANKS);

            Cherry cherry = new Cherry(this);
            cherry.registerRecipe();
            planks.add(Material.CHERRY_PLANKS);
        }

        ItemStack bowlOutput = new ItemStack(Material.BOWL);

        for (Material plank : planks) {
            NamespacedKey key = new NamespacedKey(this, plank.name().toLowerCase() + "_to_bowl");

            StonecuttingRecipe recipe = new StonecuttingRecipe(key, bowlOutput, plank);
            recipe.setGroup("planks_to_bowl");

            Bukkit.addRecipe(recipe);
        }

        getServer().getPluginManager().registerEvents(new PlayerJoiningListener(this), this);

        getLogger().info(line);
        getLogger().info("Useful Stonecutter Plugin Enabled!");
        getLogger().info(line);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        HandlerList.unregisterAll(this);

        getLogger().info(line);
        getLogger().info("Useful Stonecutter Plugin Disabled!");
        getLogger().info(line);
    }
}
