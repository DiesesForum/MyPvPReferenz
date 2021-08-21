package de.gibmirrechte.bungeesystem.commands;

import de.gibmirrechte.bungeesystem.main.Main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Ping extends Command {
	
	public Ping() {
		super("ping");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if(args.length == 0) {
			ProxiedPlayer player = (ProxiedPlayer) sender;
			player.sendMessage(new ComponentBuilder(Main.Prefix + "Dein Ping: §a" + player.getPing() + "ms").create());
			return;
		}
		
		if(args.length == 1) {
			ProxiedPlayer target = (ProxiedPlayer) ProxyServer.getInstance().getPlayer(args[0]);
			ProxiedPlayer player = (ProxiedPlayer) sender;
			if(target != null) {
				player.sendMessage(new ComponentBuilder(Main.Prefix + "§c" + target.getName() + "'s §7ping: §a" + target.getPing()).create());
			}else {
				player.sendMessage(new ComponentBuilder(Main.Prefix + "§cDieser Spieler ist nicht online!").create());
			}
		}
	}
}
