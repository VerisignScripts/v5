package vMahogany.nodes;

import org.powerbot.script.util.Timer;
import org.powerbot.script.wrappers.GameObject;
import vMahogany.fw.Node;
import vMahogany.fw.vMethodContext;
import vMahogany.util.Constants;

public class NavigateBank extends Node {

    public NavigateBank(vMethodContext ctx) {
        super(ctx);
    }


    @Override
    public boolean activate() {
        return ctx.inventory.select().count() == 28 && ctx.inventory.select().id(Constants.STICKS).count(true) > 100
                && !Constants.BANK_AREA.contains(ctx.players.getLocal());
    }

    @Override
    public void execute() {
        for (GameObject gate : ctx.objects.select().id(9038).nearest()) {
            if (gate != null && gate.isValid() && gate.isOnScreen() && Constants.TREE_AREA.contains(ctx.players.getLocal())) {
                if (gate.interact("Quick-pay(100)")) {
                    Timer g = new Timer(6000);
                    while (g.isRunning() && Constants.TREE_AREA.contains(ctx.players.getLocal())) {
                        sleep(500);
                    }
                }
            } else if (gate != null && !gate.isOnScreen() && Constants.TREE_AREA.contains(ctx.players.getLocal())) {
                ctx.camera.turnTo(gate);
            }
            if (!Constants.TREE_AREA.contains(ctx.players.getLocal())) {
                ctx.movement.newTilePath(Constants.PATH_TO_BANK).traverse();
            }
        }
    }
}
