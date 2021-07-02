package zkyubz.huskimc.core.game.testing.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import zkyubz.huskimc.core.game.utils.ChatColor;
import zkyubz.huskimc.core.game.variables.GameTask;

public class TaskTwo implements GameTask {
    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()){
            player.sendMessage(ChatColor.format("&eThis is event 2!"));
        }
    }
}
