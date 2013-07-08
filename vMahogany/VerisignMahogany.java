package vMahogany;

import org.powerbot.script.Manifest;
import org.powerbot.script.PollingScript;
import org.powerbot.script.methods.MethodContext;
import vMahogany.fw.Node;
import vMahogany.fw.vMethodContext;
import vMahogany.nodes.*;

@Manifest(authors = "Verisign", name = "vMahogany v5", description = "Testing")
public class VerisignMahogany extends PollingScript {
    public vMethodContext ctx;

    private Node[] nodes = new Node[] {new Chopping(ctx), new NavigateBank(ctx), new NavigateTrees(ctx),
            new OpenBank(ctx), new PackLogs(ctx)};

    @Override
    public void setContext(MethodContext mc) {
        if (mc instanceof vMethodContext) {
            super.setContext(this.ctx = (vMethodContext) mc);
        } else {
            setContext(new vMethodContext(mc));
        }
    }

    @Override
    public vMethodContext getContext() {
        return ctx;
    }

    @Override
    public int poll() {
        for (Node n : nodes) {
            if (n.activate()) {
                n.execute();
            }
        }
        return 500;
    }
}
