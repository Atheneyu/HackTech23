import java.awt.*;

public class GamePlay {
    private static final int WIDTH = 800;
    /** Window width */

    private static final int HEIGHT = 800;
    /** Window height */

    public static void main(String[] args) {
      GamePlay game = new GamePlay(0);
      game.titleScreen();
    }

    public GamePlay(int start) {
        StdDraw.setCanvasSize(WIDTH, HEIGHT);
        Font font = new Font("Monaco", Font.BOLD, 23);
        StdDraw.setFont(font);
        StdDraw.setXscale(0, WIDTH);
        StdDraw.setYscale(0, HEIGHT);
        StdDraw.clear();
        StdDraw.enableDoubleBuffering();
    }
    public void titleScreen() {
        StdDraw.setPenColor(Color.BLACK);
        Font fontBig = new Font("Monaco", Font.BOLD, 23);
        StdDraw.setFont(fontBig);
        StdDraw.textLeft(0.0, 50.0, "PlanetEarth");
        StdDraw.show();
    }
    public static int width() {
        return WIDTH;
    }

    public static int height() {
        return HEIGHT;
    }


}
