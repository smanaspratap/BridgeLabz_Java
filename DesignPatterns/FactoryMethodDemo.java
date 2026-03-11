public class FactoryMethodDemo {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.getShape("circle");
        Shape rect = ShapeFactory.getShape("rectangle");

        circle.draw();
        rect.draw();
    }
}

interface Shape { void draw(); }

class Circle implements Shape {
    public void draw() { System.out.println("Drawing Circle"); }
}

class Rectangle implements Shape {
    public void draw() { System.out.println("Drawing Rectangle"); }
}

class ShapeFactory {
    public static Shape getShape(String type) {
        if (type == null) throw new IllegalArgumentException("type is null");
        return switch (type.trim().toLowerCase()) {
            case "circle" -> new Circle();
            case "rectangle", "rect" -> new Rectangle();
            default -> throw new IllegalArgumentException("Unknown shape: " + type);
        };
    }
}