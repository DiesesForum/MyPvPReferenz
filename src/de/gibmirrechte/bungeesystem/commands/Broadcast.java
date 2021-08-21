package de.gibmirrechte.bungeesystem.commands;

import de.gibmirrechte.bungeesystem.main.Main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Broadcast extends Command {

    public Broadcast() {
        super("broadcast", "perm.admin", "bc");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer) {
            ProxiedPlayer p = (ProxiedPlayer) sender;

            if(args.length == 0) {
                p.sendMessage(new ComponentBuilder(Main.Prefix + "§cBitte benutze /bc <Nachricht>").create());
                return;
            }

            String msg = "";
            for (String arg : args) {
                msg = String.valueOf(msg) + arg + " ";
            }

            for(ProxiedPlayer all : ProxyServer.getInstance().getPlayers()) {
                all.sendMessage(new ComponentBuilder("§8│").create());
                all.sendMessage(new ComponentBuilder(Main.Prefix + "§7" + msg.replace('&', '§')).create());
                all.sendMessage(new ComponentBuilder("§8│").create());
            }
        }
    }

}