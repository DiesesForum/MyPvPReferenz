package de.gibmirrechte.bungeesystem.listener;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class OnJoin implements Listener {

    @EventHandler
    public void onServerSwitch(ServerConnectEvent event){
        //Hier habe ich einfach mal das Tablist-Design von MyPvP.me eingehalten.
        event.getPlayer().setTabHeader((BaseComponent) new TextComponent("\n§6« §e§lMyPvP.me Netzwerk §6»\n§7Du spielst auf §a" + event.getTarget().getName() + "\n"), (BaseComponent) new TextComponent("\n§eTeamSpeak §8» §aMyPvP.me\n§eWebsite §8» §aMyPvP.me\n§eShop §8» §aMyPvP.shop\n§eTwitter §8» §a@MyPvPme\n"));
    }
}
