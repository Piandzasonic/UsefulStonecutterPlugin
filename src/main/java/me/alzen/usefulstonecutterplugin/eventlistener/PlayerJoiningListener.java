package me.alzen.usefulstonecutterplugin.eventlistener;

import me.alzen.usefulstonecutterplugin.UsefulStonecutterPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;

public class PlayerJoiningListener implements Listener {

    private final UsefulStonecutterPlugin plugin;

    public PlayerJoiningListener(UsefulStonecutterPlugin instance){
        plugin = instance;
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        if(plugin.getConfig().getInt("EnableResourcePack") == 1){
            Player player = event.getPlayer();
            player.setResourcePack(Objects.requireNonNull(plugin.getConfig().getString("ResourcePackURL")));
        }
    }
}
