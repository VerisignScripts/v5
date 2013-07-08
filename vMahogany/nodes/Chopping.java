package vMahogany.nodes;

import org.powerbot.script.util.Timer;
import org.powerbot.script.wrappers.GameObject;
import vMahogany.fw.Node;
import vMahogany.fw.vMethodContext;
import vMahogany.util.Constants;

public class Chopping extends Node {

    public Chopping(vMethodContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.players.getLocal().getInteracting() == null &&
                Constants.TREE_AREA.contains(ctx.players.getLocal())
                &&
                ctx.inventory.select().id(Constants.LOGS).count() != 27
                &&
                ctx.inventory.select().id(Constants.STICKS).count(true) > 100;
    }

    @Override
    public void execute() {
        for (GameObject tree : ctx.objects.id(Constants.TREE).select().nearest().limit(1).first()) {
            if (!ctx.players.getLocal().isInMotion()) {
                if (tree.interact("Chop, Mahogany")) {
                    Timer t = new Timer(6000);
                    while (t.isRunning() && ctx.players.getLocal().getInteracting() != null) {
                        sleep(500);
                    }
                }
            }
        }
    }
}



