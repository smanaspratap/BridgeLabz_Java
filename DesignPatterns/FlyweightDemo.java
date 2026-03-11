import java.util.*;

public class FlyweightDemo {
    public static void main(String[] args) {
        Font f1 = FontFactory.getFont("Arial", 12);
        Font f2 = FontFactory.getFont("Arial", 12);

        CharacterGlyph c1 = new CharacterGlyph('A', 10, 20, f1);
        CharacterGlyph c2 = new CharacterGlyph('B', 12, 20, f2);

        c1.draw();
        c2.draw();
        System.out.println("Same Font instance? " + (f1 == f2));
    }
}

final class Font {
    private final String name;
    private final int size;

    public Font(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String key() { return name + ":" + size; }
    public String desc() { return name + " " + size; }
}

class FontFactory {
    private static final Map<String, Font> CACHE = new HashMap<>();

    public static Font getFont(String name, int size) {
        String key = name + ":" + size;
        return CACHE.computeIfAbsent(key, k -> new Font(name, size));
    }
}

class CharacterGlyph {
    private final char ch;
    private final int x;
    private final int y;
    private final Font font; // shared flyweight

    public CharacterGlyph(char ch, int x, int y, Font font) {
        this.ch = ch;
        this.x = x;
        this.y = y;
        this.font = font;
    }

    public void draw() {
        System.out.println("Char '" + ch + "' at (" + x + "," + y + ") using font " + font.desc());
    }
}