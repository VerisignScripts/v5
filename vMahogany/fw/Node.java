package vMahogany.fw;

public abstract class Node extends vMethodProvider {

    public vMethodContext ctx = null;

    public Node(final vMethodContext ctx) {
        super(ctx);
        this.ctx = ctx;
    }

    public abstract boolean activate();
    public abstract void execute();

}
