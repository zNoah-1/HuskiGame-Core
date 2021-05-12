package zkyubz.huskimc.core.game.commands.test;

import zkyubz.huskimc.core.game.HGame;
import zkyubz.huskimc.core.game.commands.test.*;

public class TestCommands {
    public static void init(){
        HGame.getInstance().getCommand("test1").setExecutor(new LoadTestMap());
        HGame.getInstance().getCommand("test2").setExecutor(new JoinMatch());
        HGame.getInstance().getCommand("test3").setExecutor(new StartMatch());
        HGame.getInstance().getCommand("test4").setExecutor(new EndMatch());
        HGame.getInstance().getCommand("test5").setExecutor(new GameList());
    }
}
