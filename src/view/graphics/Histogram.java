package view.graphics;

public class Histogram extends UIGraphic {

    public Histogram() {
        super("Histogram");
    }

    @Override
    public void draw(int idx, int n) {
        int width = (WIDTH - 2 * outerSpace - (QTD - 1) * innerSpace) / QTD;
        int height = (HEIGHT - 2 * outerSpace) / QTD;
        g.fillRect(idx * (width + innerSpace) + outerSpace, HEIGHT - n * height - outerSpace, width, n * height);
    }
}