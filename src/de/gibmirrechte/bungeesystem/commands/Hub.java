package de.gibmirrechte.bungeesystem.commands;

import de.gibmirrechte.bungeesystem.main.Main;
import de.gibmirrechte.bungeesystem.main.MySQLHandler;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Hub extends Command {
	
	public Hub() {
		super("hub", "", "lobby", "l");
	}

	MySQLHandler mySQLHandler = new MySQLHandler();

	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer player = (ProxiedPlayer) sender;
		try{
			PreparedStatement preparedStatement = mySQLHandler.getConnection().prepareStatement("SELECT Server FROM Settings WHERE 1");
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				if (player.getServer().getInfo().getName().equalsIgnoreCase(resultSet.getString("Server"))) {
					player.sendMessage(new ComponentBuilder(Main.Prefix + "§cDu bist bereits in der Lobby!").create());
					return;
				}

				ServerInfo target = ProxyServer.getInstance().getServerInfo(resultSet.getString("Server"));
				player.connect(target);
			}
		}catch (SQLException ignored){
		}
	}
}