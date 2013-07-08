package vMahogany.fw;

import org.powerbot.script.methods.MethodContext;

public class vMethodContext extends MethodContext {
    public vMethodContext(MethodContext ctx) {
        super(ctx.getBot());
        this.init(ctx);
    }
}


