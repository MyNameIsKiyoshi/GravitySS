package it.gravitymc.gravityss.events;

import it.gravitymc.gravityss.manager.PluginManager;
import it.gravitymc.gravityss.utils.abs.UTILS;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import static it.gravitymc.gravityss.GravitySS.targetName;

public class SSFinishGuiSwitch extends UTILS implements Listener {

    private final PluginManager pluginManager;

    public SSFinishGuiSwitch(PluginManager pluginManager){
        this.pluginManager = pluginManager;
    }

    @EventHandler
    @Deprecated
    public void PetsMove(InventoryClickEvent e) {

        if (e.getView().getTitle().equalsIgnoreCase(format.color("&a&lVerdetto..."))) {
            Player player = (Player) e.getWhoClicked();
            switch (e.getCurrentItem().getType()) {
                case GRAY_STAINED_GLASS_PANE:
                    break;
                case GREEN_STAINED_GLASS_PANE:
                    bungeeAPI.sendPlayerToServer(player, "hub");
                    bungeeAPI.sendPlayerToServer(Bukkit.getPlayer(targetName.get("target")), "hub");
                    break;
                case ORANGE_STAINED_GLASS_PANE:
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + targetName.get("target") + " 14d Ammissione Hack [GravitySS] -s");
                    targetName.clear();
                    bungeeAPI.sendPlayerToServer(player, "hub");
                    break;
                case RED_STAINED_GLASS_PANE:
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + targetName.get("target") + " 30d Blatant [GravitySS] -s");
                    targetName.clear();
                    bungeeAPI.sendPlayerToServer(player, "hub");
                    break;
            }
            sounds.clickInv(player);
            e.setCancelled(true);
        }
    }
}

