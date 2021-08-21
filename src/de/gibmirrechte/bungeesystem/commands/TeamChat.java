package de.gibmirrechte.bungeesystem.commands;

import de.gibmirrechte.bungeesystem.main.Main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class TeamChat extends Command {

    public TeamChat() {
        super("teamchat", "perm.team", "tc");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(args.length == 0) {
            sender.sendMessage(new ComponentBuilder(Main.Prefix + "§cBitte benutze /tc <Nachricht>").create());
            return;
        }

        String msg = "";
        for (String arg : args) msg = String.valueOf(msg) + arg + " ";

        for(ProxiedPlayer team : ProxyServer.getInstance().getPlayers()) {
            if(team.hasPermission("perm.team")) {
                team.sendMessage(new ComponentBuilder("§8│ §cTeam §8» §7" + sender.getName() + " §8» §c" + msg).create());
            }
        }

    }
}
