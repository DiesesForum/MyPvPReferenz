package de.gibmirrechte.bungeesystem.commands;

import de.gibmirrechte.bungeesystem.main.Main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class MSG extends Command {

    public MSG() {
        super("msg");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(args.length == 0) {
            sender.sendMessage(new ComponentBuilder(Main.Prefix + "§cBitte benutze /msg <Spieler> <Nachricht>").create());
            return;
        }

        ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);

        if(target == null) {
            sender.sendMessage(new ComponentBuilder(Main.Prefix + "§cDieser Spieler ist zurzeit offline!").create());
            return;
        }

        if(target.getName().equalsIgnoreCase(sender.getName())) {
            sender.sendMessage(new ComponentBuilder(Main.Prefix + "§cDu kannst dir selber keine Nachrichten §cschreiben!").create());
            return;
        }

        String msg = "";
        for (int i = 1; i < args.length; i++){
            msg = String.valueOf(msg) + args[i] + " ";
        }


        target.sendMessage(new ComponentBuilder(Main.Prefix + sender.getName() + " §8➡ " + target.getName() + " §8» §7" + msg).create());
        sender.sendMessage(new ComponentBuilder(Main.Prefix + sender.getName() + " §8➡ " + target.getName() + " §8» §7" + msg).create());

    }

}