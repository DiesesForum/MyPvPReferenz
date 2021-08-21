package de.gibmirrechte.bungeesystem.listener;

import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.util.Random;

public class OnProxyPing implements Listener {

    @EventHandler
    public void onProxyPing(ProxyPingEvent event){
        switch (new Random().nextInt(3)){
            case 0:
                event.getResponse().setDescription("§e§lMyPvP 2.0 §8× §eMinigames §8& §6MyServer §8│ §b1§8.§b8 §8- §b1§8.§b17§8.§b1\n§8§l» §3§lNEU§8: §b§lMYSERVER-PANEL §8│ §bpvp.fyi/panel");
                break;
            case 1:
                event.getResponse().setDescription("§e§lMyPvP 2.0 §8× §eMinigames §8& §6MyServer §8│ §b1§8.§b8 §8- §b1§8.§b17§8.§b1\n§8§l» §3§lTESTPLUGIN VON §b§lGibMirRechte §4❤");
                break;
            case 2:
                event.getResponse().setDescription("§e§lMyPvP 2.0 §8× §eMinigames §8& §6MyServer §8│ §b1§8.§b8 §8- §b1§8.§b17§8.§b1\n§8§l» §3§lRABATT§8: §b§l0% RABATT AUF ALLES §8│ §b§lMyPvP.Shop");
                break;
        }
    }
}
