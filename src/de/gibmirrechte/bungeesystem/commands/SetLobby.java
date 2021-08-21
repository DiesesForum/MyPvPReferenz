package de.gibmirrechte.bungeesystem.commands;

import de.gibmirrechte.bungeesystem.main.Main;
import de.gibmirrechte.bungeesystem.main.MySQLHandler;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.plugin.Command;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SetLobby extends Command {

    public SetLobby(){
        super("setlobby", "perm.admin");
    }

    MySQLHandler mySQLHandler = new MySQLHandler();

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        if(args.length != 1){
            commandSender.sendMessage(new ComponentBuilder(Main.Prefix + "§cBitte benutze /setlobby <Servername>").create());
        }else{
            try{
                PreparedStatement ps = mySQLHandler.getConnection().prepareStatement("UPDATE Settings SET Server=" + args[0]);
                ps.executeUpdate();
            }catch (SQLException ignored){
            }
            commandSender.sendMessage(new ComponentBuilder(Main.Prefix + "§aDer Lobbyserver wurde auf §e" + args[0] + " §agesetzt!").create());
        }
    }
}
