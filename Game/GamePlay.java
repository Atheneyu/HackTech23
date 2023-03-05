import java.awt.*;
import java.util.Random;

public class GamePlay {
    private static final int WIDTH = 800;
    /** Window width */

    private static final int HEIGHT = 800;
    /** Window height */

    private static final double RADIUS = 80;

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
      GamePlay game = new GamePlay(0);
      game.startMap();
      game.decreaseHealth(0);
      game.digBox();
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

    /**
    public void titleScreen() {
        StdDraw.clear();
        StdDraw.setPenColor(Color.BLACK);
        Font fontBig = new Font("Monaco", Font.BOLD, 23);
        StdDraw.setFont(fontBig);
        StdDraw.textLeft(120, 120, "PlanetEarth");
        globeAnimation();
        StdDraw.show();
    }
     */
    public static void decreaseHealth(int a) {
        int x = 0;
        int w = RANDOM.nextInt(1, WIDTH);
        int h = RANDOM.nextInt(1, HEIGHT);
        while (x <= a) {
            StdDraw.setPenColor(Color.GRAY);
            StdDraw.filledSquare(w, h, 10);
            w = RANDOM.nextInt(1, WIDTH);
            h = RANDOM.nextInt(1, HEIGHT);
            x++;
        }
        StdDraw.show();
    }
    public void titleScreen() {
        boolean up = false;
        for (int i = 0; i < 20; i += 1) {

            /** Below: Loop for up-and-down animation. */
            StdDraw.clear();
            StdDraw.setPenColor(Color.BLUE);
            if (!up) {
                StdDraw.filledCircle(WIDTH / 2, HEIGHT / 2, RADIUS);
                up = true;
            } else {
                StdDraw.filledCircle(WIDTH / 2, (HEIGHT / 2) + 10, RADIUS);
                up = false;
            }
            /** Text below. */
            StdDraw.setPenColor(Color.BLACK);
            Font fontBig = new Font("Monaco", Font.BOLD, 23);
            StdDraw.setFont(fontBig);
            StdDraw.textLeft(120, 120, "PlanetEarth");
            StdDraw.show();
            StdDraw.pause(700);
        }
    }

    public void gameStart() {
        startMap();
    }
    public void globe(double x, double y) {
        StdDraw.setPenColor(Color.BLUE);
        StdDraw.filledCircle(x, y, RADIUS);
        StdDraw.setPenColor(Color.GREEN);
        StdDraw.filledCircle(x + 20, y + 20, RADIUS/10);
    }

    public void startOrQuit() {
        Character input = solicitMenuInput();
        switch(input) {
            case 'y':
                //start game
                break;
            case 'n':
                System.exit(0);
                break;
        }
    }
    public void digBox() {
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.filledRectangle(WIDTH / 2, HEIGHT / 4, WIDTH / 2.5, HEIGHT / 10);
        StdDraw.show();
    }
    public static void startMap() {
        int r = RANDOM.nextInt(1, 3);
        for (int x = 0; x < WIDTH; x += 10) {
            for (int y = 0; y < HEIGHT; y += 10) {
                if (r % 2 == 0) {
                    StdDraw.setPenColor(102, 255, 102);
                } else {
                    StdDraw.setPenColor(77,166,255);
                }
                StdDraw.filledSquare(x, y,10);
                r = RANDOM.nextInt(1, 3);
            }
        }
        StdDraw.show();
    }
    public Character solicitMenuInput() {
        Character input = null;
        while (input == null) {
            if (StdDraw.hasNextKeyTyped()) {
                Character nextKeyTyped = StdDraw.nextKeyTyped();
                nextKeyTyped = Character.toLowerCase(nextKeyTyped);
                if (nextKeyTyped == 'y' || nextKeyTyped == 'n') {
                    input = nextKeyTyped;
                }
            }
        }
        return input;
    }

    public static int width() {
        return WIDTH;
    }

    public static int height() {
        return HEIGHT;
    }

}
