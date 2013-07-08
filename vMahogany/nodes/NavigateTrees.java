package vMahogany.nodes;

import org.powerbot.script.util.Timer;
import org.powerbot.script.wrappers.GameObject;
import vMahogany.fw.Node;
import vMahogany.fw.vMethodContext;
import vMahogany.util.Constants;

public class NavigateTrees extends Node {


    public NavigateTrees(vMethodContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.select().id(Constants.LOGS).count() == 0 && ctx.inventory.select().id(Constants.STICKS).count(true) > 100
                && !Constants.TREE_AREA.contains(ctx.players.getLocal());
    }

    @Override
    public void execute() {
        for (GameObject gate : ctx.objects.select().id(9038).nearest()) {
            if (gate != null) {
                if (!gate.isOnScreen()) {
                    ctx.movement.newTilePath(Constants.PATH_TO_TREES).traverse();
                } else {
                    if (gate.interact("Quick-pay(100)")) {
                        Timer x = new Timer(6000);
                        while (x.isRunning() && !Constants.TREE_AREA.contains(ctx.players.getLocal())) {
                            sleep(600, 720);
                        }
                    }
                }
            }
        }
    }
}
