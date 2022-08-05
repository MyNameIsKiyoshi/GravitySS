package it.gravitymc.gravityss.commands;

import it.gravitymc.gravityss.manager.PluginManager;
import it.gravitymc.gravityss.utils.abs.UTILS;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.checkerframework.checker.nullness.qual.NonNull;

import static it.gravitymc.gravityss.GravitySS.targetName;

public class SSFinish extends UTILS implements CommandExecutor {

    private final PluginManager pluginManager;

    public SSFinish(PluginManager pluginManager){
        this.pluginManager = pluginManager;
    }

    @Override
    public boolean onCommand(@NonNull CommandSender sender, @NonNull Command command, @NonNull String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(format.color("&cAzione bloccata in console."));
        }

        Player player = (Player) sender;

        if(command.getName().equals("ssfinish")){
            if(args.length >= 1){

                Player target = Bukkit.getPlayer(args[0]);

                if(perms.hasPermission(perms.getUser(player), "gravityss.staff")){
                    Inventory inv = Bukkit.createInventory(null, 27, format.color("&a&lVerdetto..."));

                    for (int i = 0; i < inv.getSize(); i++) {
                        if (inv.getItem(i) == null || inv.getItem(i).getType().equals(Material.AIR)) {
                            inv.setItem(i, stack.getSpacer(player));

                            inv.setItem(10, stack.getClean(player));

                            inv.setItem(12, stack.getAmmission(player));

                            inv.setItem(14, stack.getBlatant(player));
                        }
                    }

                    sounds.openGuiOre(player);
                    player.openInventory(inv);
                    targetName.put("target", target.getName());
                } else {
                    sounds.accessDenied(player);
                    player.sendMessage(format.color("&cAutorizzazioni mancanti, non hai il permesso per eseguire questo comando."));
                }
            }
        }
        return false;
    }
}
