package zkyubz.huskimc.core.game.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerDisconnect implements Listener {
    @EventHandler()
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        if (true){
            //PlayerDisconnectEvent e = new PlayerDisconnectEvent(player, 1);
            //Bukkit.getPluginManager().callEvent(e);
        }
        //Check if player is on match
        /*
            Event call
            -Player Disconnected
            -Match where he was disconnected
         */
    }
}
