public class GamePlay {
    private static final int WIDTH = 800;
    /** Window width */

    private static final int HEIGHT = 800;
    /** Window height */

    public static void main(String[] args) {
        StdDraw.setCanvasSize(WIDTH, HEIGHT);
        /** Sets the window to 512 x 512 by default. */

    }

    public int width() {
        return WIDTH;
    }

    public int height() {
        return HEIGHT;
    }


}
