package net.platzhaltergaming.immutatioobstructum.modules;

import org.bukkit.GameMode;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.Event.Result;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.vehicle.VehicleDamageEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.plugin.java.JavaPlugin;

import io.papermc.paper.event.player.PlayerItemFrameChangeEvent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ProtectionModule implements Listener {

    private final JavaPlugin plugin;

    public void onEnable() {
        getPlugin().getServer().getPluginManager().registerEvents(this, getPlugin());
    }

    // Player related Events ==================================================
    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        event.getPlayer().setGameMode(GameMode.ADVENTURE);
    }

    @EventHandler
    public void onPlayerArmorStandManipulateEvent(PlayerArmorStandManipulateEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerItemFrameChangeEvent(PlayerItemFrameChangeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        event.setUseInteractedBlock(Result.DENY);
        event.setCancelled(true);
    }

    @EventHandler
    public void onEntityDamageEvent(EntityDamageEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onFoodLevelChangeEvent(FoodLevelChangeEvent event) {
        event.setCancelled(true);
        HumanEntity entity = event.getEntity();
        if (entity instanceof Player) {
            Player player = (Player) entity;
            player.setFoodLevel(20);
        }
    }

    @EventHandler
    public void onPlayerBedEnterEvent(PlayerBedEnterEvent event) {
        event.setCancelled(true);
        event.setUseBed(Result.DENY);
    }

    @EventHandler
    public void onPlayerInteractEntityEvent(PlayerInteractEntityEvent event) {
        event.setCancelled(true);
    }

    // Block related Events ===================================================
    @EventHandler
    public void onBlockCanBuildEvent(BlockCanBuildEvent event) {
        event.setBuildable(false);
    }

    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent event) {
        event.setBuild(false);
        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event) {
        event.setDropItems(false);
        event.setExpToDrop(0);
        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockIgniteEvent(BlockIgniteEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockBurnEvent(BlockBurnEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockGrowEvent(BlockGrowEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockSpreadEvent(BlockSpreadEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockFadeEvent(BlockFadeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onHangingBreakByEntityEvent(HangingBreakByEntityEvent event) {
        event.setCancelled(true);
    }

    // Item related Events ====================================================
    @EventHandler
    public void onPlayerBucketEmptyEvent(PlayerBucketEmptyEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerBucketFillEvent(PlayerBucketFillEvent event) {
        event.setCancelled(true);
    }

    // Vehicle related Events =================================================
    @EventHandler
    public void onVehicleEnterEvent(VehicleEnterEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onVehicleDamageEvent(VehicleDamageEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onVehicleDestroyEvent(VehicleDestroyEvent event) {
        event.setCancelled(true);
    }
}
