package net.platzhaltergaming.immutatioobstructum.modules;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PlayerJoinQuitModule implements Listener {

    private final JavaPlugin plugin;

    public void onEnable() {
        getPlugin().getServer().getPluginManager().registerEvents(this, getPlugin());
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        event.joinMessage(null);
    }

    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent event) {
        event.quitMessage(null);
    }

    @EventHandler
    public void onPlayerKickEvent(PlayerKickEvent event) {
        event.leaveMessage(null);
    }

}
