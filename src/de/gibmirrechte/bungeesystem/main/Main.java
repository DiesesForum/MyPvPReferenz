package de.gibmirrechte.bungeesystem.main;

import de.gibmirrechte.bungeesystem.commands.*;
import de.gibmirrechte.bungeesystem.listener.OnJoin;
import de.gibmirrechte.bungeesystem.listener.OnProxyPing;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

import java.io.File;

public class Main extends Plugin {

    public static String Prefix = "§8│  §fBungeeSystem §8» §7";

    MySQLHandler mySQLHandler = new MySQLHandler();

    @Override
    public void onEnable() {
        mySQLHandler.connect();

        /*
        Registrierung der Commands.
         */
        getProxy().getPluginManager().registerCommand(this, new TeamChat());
        getProxy().getPluginManager().registerCommand(this, new Hub());
        getProxy().getPluginManager().registerCommand(this, new Ping());
        getProxy().getPluginManager().registerCommand(this, new MSG());
        getProxy().getPluginManager().registerCommand(this, new Broadcast());
        getProxy().getPluginManager().registerCommand(this, new Forum());
        getProxy().getPluginManager().registerCommand(this, new Discord());
        getProxy().getPluginManager().registerCommand(this, new SetLobby());

        /*
        Registrierung der Events/Listener.
         */

        getProxy().getPluginManager().registerListener(this, new OnJoin());
        getProxy().getPluginManager().registerListener(this, new OnProxyPing());
    }

    @Override
    public void onDisable() {
        mySQLHandler.disconnect();
    }
}
