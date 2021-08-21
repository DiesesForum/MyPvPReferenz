package de.gibmirrechte.bungeesystem.commands;

import de.gibmirrechte.bungeesystem.main.Main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.plugin.Command;

public class Discord extends Command {
	
	public Discord() {
		super("discord", "", "dc");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		sender.sendMessage(new ComponentBuilder(Main.Prefix + "Unser Discord: §bhttps://mypvp.me/discord" + sender.getName()).create());
	}

}
