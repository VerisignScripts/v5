package vMahogany.nodes;

import org.powerbot.script.wrappers.Npc;
import vMahogany.fw.Node;
import vMahogany.fw.vMethodContext;
import vMahogany.util.Constants;

public class OpenBank extends Node {


    public OpenBank(vMethodContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.id(Constants.LOGS).count() == 27 && Constants.BANK_AREA.contains(ctx.players.getLocal())
                && !ctx.widgets.get(323,5).isVisible();
    }

    @Override
    public void execute() {
        for (Npc banker : ctx.npcs.id(2531).select()) {
            if (banker != null) {
                if (banker.isOnScreen()) {
                    if (!ctx.widgets.get(323, 5).isVisible()) {
                        if (banker.interact("Send-parcel")) {
                            sleep(1000,1200);
                        }
                    } else {
                        break;
                    }
                }  else {
                    ctx.camera.turnTo(banker);
                }
            }
        }
    }
}




