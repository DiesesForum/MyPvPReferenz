package de.gibmirrechte.bungeesystem.commands;

import de.gibmirrechte.bungeesystem.main.Main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.plugin.Command;

public class Forum extends Command {
	
	
	public Forum() {
		super("forum");
	}
	
	@Override
	public void execute(CommandSender sender, String[] args) {
		sender.sendMessage(new ComponentBuilder(Main.Prefix + "Unser Forum: §bhttps://mypvp.me/forum/" + sender.getName()).create());
	}


}
