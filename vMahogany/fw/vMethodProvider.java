package vMahogany.fw;


import org.powerbot.script.methods.MethodProvider;

public class vMethodProvider extends MethodProvider {
    public vMethodContext ctx;

    public vMethodProvider(vMethodContext c) {
        super(c);
        this.ctx = c;
    }
}





