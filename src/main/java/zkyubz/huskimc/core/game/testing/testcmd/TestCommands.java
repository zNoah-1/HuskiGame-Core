package zkyubz.huskimc.core.game.testing.testcmd;

import zkyubz.huskimc.core.game.HGame;
import zkyubz.huskimc.core.game.testing.testcmd.cmds.*;

public class TestCommands {
    public static void init(){
        HGame.getInstance().getCommand("test1").setExecutor(new LoadTestMapCmd());
        HGame.getInstance().getCommand("test2").setExecutor(new JoinMatchCmd());
        HGame.getInstance().getCommand("test3").setExecutor(new StartMatchCmd());
        HGame.getInstance().getCommand("test4").setExecutor(new EndMatchCmd());
        HGame.getInstance().getCommand("test5").setExecutor(new GameListCmd());

        HGame.getInstance().getCommand("testevent").setExecutor(new TestEventCmd());
    }
}
