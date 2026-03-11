public class BridgeDemo {
    public static void main(String[] args) {
        Color red = new Red();
        Color blue = new Blue();

        ShapeBridge c1 = new CircleBridge(red);
        ShapeBridge s1 = new SquareBridge(blue);

        c1.draw();
        s1.draw();
    }
}

interface Color { String apply(); }

class Red implements Color { public String apply() { return "Red"; } }
class Blue implements Color { public String apply() { return "Blue"; } }

abstract class ShapeBridge {
    protected final Color color;
    protected ShapeBridge(Color color) { this.color = color; }
    abstract void draw();
}

class CircleBridge extends ShapeBridge {
    public CircleBridge(Color color) { super(color); }
    void draw() { System.out.println("Drawing Circle with " + color.apply()); }
}

class SquareBridge extends ShapeBridge {
    public SquareBridge(Color color) { super(color); }
    void draw() { System.out.println("Drawing Square with " + color.apply()); }
}