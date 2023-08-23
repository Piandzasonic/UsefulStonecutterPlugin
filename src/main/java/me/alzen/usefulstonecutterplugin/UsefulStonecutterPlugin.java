package me.alzen.usefulstonecutterplugin;

import me.alzen.usefulstonecutterplugin.model.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class UsefulStonecutterPlugin extends JavaPlugin {

    private final String line = "===========================";

    @Override
    public void onEnable() {
        // Plugin startup logic

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

        if(getServer().getBukkitVersion().contains("1.19")){
            Mangrove mangrove = new Mangrove(this);
            mangrove.registerRecipe();
        }

        if(getServer().getBukkitVersion().contains("1.20")){
            Mangrove mangrove = new Mangrove(this);
            mangrove.registerRecipe();

            Cherry cherry = new Cherry(this);
            cherry.registerRecipe();
        }


        getLogger().info(line);
        getLogger().info("Woodcutter Plugin Enabled!");
        getLogger().info(line);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        getLogger().info(line);
        getLogger().info("Woodcutter Plugin Disabled!");
        getLogger().info(line);
    }
}
