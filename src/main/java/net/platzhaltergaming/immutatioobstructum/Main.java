package net.platzhaltergaming.immutatioobstructum;

import org.bukkit.plugin.java.JavaPlugin;

import net.platzhaltergaming.immutatioobstructum.modules.PlayerJoinQuitModule;
import net.platzhaltergaming.immutatioobstructum.modules.ProtectionModule;

public class Main extends JavaPlugin {

    public void onEnable() {
        PlayerJoinQuitModule playerJoinQuitModule = new PlayerJoinQuitModule(this);
        playerJoinQuitModule.onEnable();
        ProtectionModule protectionModule = new ProtectionModule(this);
        protectionModule.onEnable();
    }

}
