package vMahogany.nodes;

import vMahogany.fw.Node;
import vMahogany.fw.vMethodContext;
import vMahogany.util.Constants;

public class PackLogs extends Node {

    public PackLogs(vMethodContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.widgets.get(323, 5).isVisible() && ctx.inventory.select().id(Constants.LOGS).count() > 1
                && ctx.inventory.select().id(Constants.STICKS).count(true) > 100;
    }

    @Override
    public void execute() {
        for(int i=0; i<28; i++) {
            if (checkItem(ctx.widgets.get(323,5).getChild(i).getId())) {
                ctx.widgets.get(323,5).getChild(i).interact("Pack All");
            }
        }
    }

    private boolean checkItem(int id) {
        for(int log : Constants.LOGS)
            if(log==id)
                return true;
        return false;
    }

}
