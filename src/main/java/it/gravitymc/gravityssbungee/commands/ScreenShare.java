package it.gravitymc.gravityssbungee.commands;

import it.gravitymc.gravityssbungee.utils.Format;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ScreenShare extends Command {
    public ScreenShare(String name) {
        super("ScreenShare");
    }

    public ScreenShare(String name, String permission, String... aliases) {
        super("ScreenShare", "gravityss.use", "ss");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer player = (ProxiedPlayer) sender;
        ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);
        ServerInfo controlli = ProxyServer.getInstance().getServerInfo("controlli");


        if(player.hasPermission("gravityss.staff")){
            if(args.length >=1 ){
                if(target.hasPermission("gravityss.bypass")){
                    player.sendMessage(Format.color("&cNon puoi portare un altro staff nel server controlli."));
                } else {
                    player.connect(controlli);
                    target.connect(controlli);
                    target.sendMessage(Format.color("&aSei stato portato nel server controlli, tieniti a rispettare l'addetto al controllo."));
                    player.sendMessage(Format.color("&aHai portato &2" + target.getName() + " &anel server controlli."));
                }
            }
        }
    }
}
