package it.gravitymc.gravityss.commands;

import it.gravitymc.gravityss.GravitySS;
import it.gravitymc.gravityss.manager.PluginManager;
import it.gravitymc.gravityss.utils.abs.UTILS;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;

public class SSSettings extends UTILS implements CommandExecutor, TabCompleter {

    private final PluginManager pluginManager;

    public SSSettings(PluginManager pluginManager){
        this.pluginManager = pluginManager;
    }

    @Override
    public boolean onCommand(@NonNull CommandSender sender, @NonNull Command command, @NonNull String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(format.color("&cAzione bloccata in console."));
        }

        Player player = (Player) sender;

        if(command.getName().equals("sssettings")){
            if(perms.hasPermission(perms.getUser(player), "gravityss.admin")){
                if(args.length >= 1){
                    if(args[0].equals("setsuspectlocation")){
                        GravitySS.getInstance().getConfig()
                                .set("Locations.Suspect.World",
                                        player.getLocation().getWorld().getName());
                        GravitySS.getInstance().getConfig()
                                .set("Locations.Suspect.X",
                                        player.getLocation().getBlockX());
                        GravitySS.getInstance().getConfig()
                                .set("Locations.Suspect.Y",
                                        player.getLocation().getBlockY());
                        GravitySS.getInstance().getConfig()
                                .set("Locations.Suspect.Z",
                                        player.getLocation().getBlockZ());
                        GravitySS.getInstance().getConfig()
                                .set("Locations.Suspect.YAW",
                                        player.getLocation().getYaw());
                        GravitySS.getInstance().getConfig()
                                .set("Locations.Suspect.PITCH",
                                        player.getLocation().getPitch());
                        GravitySS.getInstance().saveConfig();
                        player.sendMessage(format.color("&aImpostata la posizione di spawn per il sospetto."));
                    }

                    if(args[0].equals("setstafferlocation")){
                        GravitySS.getInstance().getConfig()
                                .set("Locations.Staffer.World",
                                        player.getLocation().getWorld().getName());
                        GravitySS.getInstance().getConfig()
                                .set("Locations.Staffer.X",
                                        player.getLocation().getBlockX());
                        GravitySS.getInstance().getConfig()
                                .set("Locations.Staffer.Y",
                                        player.getLocation().getBlockY());
                        GravitySS.getInstance().getConfig()
                                .set("Locations.Staffer.Z",
                                        player.getLocation().getBlockZ());
                        GravitySS.getInstance().getConfig()
                                .set("Locations.Staffer.YAW",
                                        player.getLocation().getYaw());
                        GravitySS.getInstance().getConfig()
                                .set("Locations.Staffer.PITCH",
                                        player.getLocation().getPitch());
                        GravitySS.getInstance().saveConfig();
                        player.sendMessage(format.color("&aImpostata la posizione di spawn per lo staffer."));
                    }
                }
            }
        }

        return false;
    }

    private void a(List<String> s, String arg, String test) {
        if (test.startsWith(arg.toLowerCase()))
            s.add(test);
    }

    @Override
    public List<String> onTabComplete(@NonNull CommandSender arg0, Command arg1, @NonNull String arg2, String[] args) {
        List<String> s = new ArrayList<>();
        if(arg1.getName().equals("sssettings")) {
            if(args.length == 1) {
                a(s, args[0], "setsuspectlocation");
                return s;
            }
            if(args.length == 1) {
                a(s, args[0], "setstafferlocation");
                return s;
            }
        }
        return null;
    }
}
