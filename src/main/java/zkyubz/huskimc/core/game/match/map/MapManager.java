package zkyubz.huskimc.core.game.match.map;

import com.grinderwolf.swm.api.SlimePlugin;
import com.grinderwolf.swm.api.exceptions.CorruptedWorldException;
import com.grinderwolf.swm.api.exceptions.NewerFormatException;
import com.grinderwolf.swm.api.exceptions.UnknownWorldException;
import com.grinderwolf.swm.api.exceptions.WorldInUseException;
import com.grinderwolf.swm.api.loaders.SlimeLoader;
import com.grinderwolf.swm.api.world.SlimeWorld;
import com.grinderwolf.swm.api.world.properties.SlimeProperties;
import com.grinderwolf.swm.api.world.properties.SlimePropertyMap;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import zkyubz.huskimc.core.game.HGame;
import zkyubz.huskimc.core.game.utils.ChatColor;

import java.io.IOException;

public class MapManager {
    public static void loadMap(String worldName){
        slimeLoad(worldName, 1);
    }

    public static void reloadMap(String worldName){
        Bukkit.unloadWorld(Bukkit.getWorld(worldName), true);
        slimeLoad(worldName,2);
    }

    private static void slimeLoad(String worldName, int mode){
        //Load world async with SWM
        new BukkitRunnable() {
            @Override
            public void run() {
                SlimePlugin plugin = (SlimePlugin) Bukkit.getPluginManager().getPlugin("SlimeWorldManager");
                SlimeLoader fileLoader = plugin.getLoader("file");

                SlimePropertyMap properties = new SlimePropertyMap();
                properties.setString(SlimeProperties.DIFFICULTY, "normal");
                properties.setInt(SlimeProperties.SPAWN_X, 0);
                properties.setInt(SlimeProperties.SPAWN_Y, 120);
                properties.setInt(SlimeProperties.SPAWN_Z, 0);
                properties.setBoolean(SlimeProperties.ALLOW_ANIMALS, false);
                properties.setBoolean(SlimeProperties.ALLOW_MONSTERS, false);
                properties.setBoolean(SlimeProperties.PVP, true);
                properties.setString(SlimeProperties.ENVIRONMENT, "normal");
                properties.setString(SlimeProperties.WORLD_TYPE, "default");

                try {
                    // Note that this method should be called asynchronously
                    SlimeWorld world = plugin.loadWorld(fileLoader, worldName, true, properties);

                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            // This method must be called synchronously
                            plugin.generateWorld(world);
                        }
                    }.runTask(HGame.getInstance());

                } catch (UnknownWorldException | IOException | CorruptedWorldException | NewerFormatException | WorldInUseException ex) {
                    /* Exception handling */
                    Bukkit.getConsoleSender().sendMessage(ChatColor.format(" "));
                    Bukkit.getConsoleSender().sendMessage(ChatColor.format(" &c[!] HuskiCore-Game Error"));

                    if (mode == 1) {
                        Bukkit.getConsoleSender().sendMessage(ChatColor.format(" &f  Error trying to load the map"));
                    } else if (mode == 2) {
                        Bukkit.getConsoleSender().sendMessage(ChatColor.format(" &f  Error trying to reload the map"));
                    }

                    Bukkit.getConsoleSender().sendMessage(ChatColor.format(" "));
                    Bukkit.getConsoleSender().sendMessage(ex.getMessage());
                    Bukkit.getConsoleSender().sendMessage(ChatColor.format(" "));
                    Bukkit.getConsoleSender().sendMessage(ChatColor.format(" &f  SlimeWorldManager Error"));
                    Bukkit.getConsoleSender().sendMessage(ChatColor.format(" &c[!] HuskiCore-Game Error"));
                    Bukkit.getConsoleSender().sendMessage(ChatColor.format(" "));
                }
            }
        }.runTaskAsynchronously(HGame.getInstance());
    }
}
