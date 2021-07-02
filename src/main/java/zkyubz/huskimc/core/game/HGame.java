package zkyubz.huskimc.core.game;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import zkyubz.huskimc.core.game.commands.MainCommand;
import zkyubz.huskimc.core.game.testing.testcmd.TestCommands;
import zkyubz.huskimc.core.game.match.map.RestartQueue;
import zkyubz.huskimc.core.game.utils.ChatColor;

public class HGame extends JavaPlugin {
    private static HGame instance;

    @Override
    public void onLoad(){
        //Message to console
        Bukkit.getConsoleSender().sendMessage(ChatColor.format(" "));
        Bukkit.getConsoleSender().sendMessage(ChatColor.format(" &e[!] Cargando game core...  "));
        Bukkit.getConsoleSender().sendMessage(ChatColor.format(" "));
    }

    @Override
    public void onEnable(){
        //Message to console
        Bukkit.getConsoleSender().sendMessage(ChatColor.format(" "));
        Bukkit.getConsoleSender().sendMessage(ChatColor.format("       &bHuskiCore-Game  "));
        Bukkit.getConsoleSender().sendMessage(ChatColor.format("  "));
        Bukkit.getConsoleSender().sendMessage(ChatColor.format(" ➜ &fCreado por &bNua#1962"));
        Bukkit.getConsoleSender().sendMessage(ChatColor.format(" ➜ &fPara: &aTodos uwu"));
        Bukkit.getConsoleSender().sendMessage(ChatColor.format(" "));

        //Setting instance
        setInstance(this);

        //Registering command
        this.getCommand("huskigame").setExecutor(new MainCommand());

        //Initializing Map Restart Queue
        RestartQueue.init();

        //Register test commands
        TestCommands.init();
    }

    @Override
    public void onDisable(){
        //Message to console
        Bukkit.getConsoleSender().sendMessage(ChatColor.format(" "));
        Bukkit.getConsoleSender().sendMessage(ChatColor.format("       &bHuskiCore-Game  "));
        Bukkit.getConsoleSender().sendMessage(ChatColor.format("  "));
        Bukkit.getConsoleSender().sendMessage(ChatColor.format(" ➜ &fDesactivando game core"));
        Bukkit.getConsoleSender().sendMessage(ChatColor.format(" "));
    }

    public static void setInstance(HGame ins){
        instance = ins;
    }

    public static HGame getInstance(){
        return instance;
    }
}
