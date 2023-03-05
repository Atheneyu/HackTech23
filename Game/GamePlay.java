import java.awt.*;
import java.util.Random;

public class GamePlay {
    private static final int WIDTH = 800;
    /** Window width */

    private static final int HEIGHT = 800;
    /** Window height */

    private static final double RADIUS = 80;

    public static void main(String[] args) {
      GamePlay game = new GamePlay(0);
      game.startMap();
      game.decreaseHealth(9);
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
        while (x <= a) {
            int randWidth = (int)(Math.random() * WIDTH);
            int randHeight = (int)(Math.random() * HEIGHT);
            if (StdDraw.getPenColor() == Color.GRAY) {
                randWidth = (int)(Math.random() * WIDTH);
                randHeight = (int)(Math.random() * HEIGHT);
            } else {
                StdDraw.setPenColor(Color.GRAY);
                StdDraw.filledSquare(randWidth, randHeight, 0.5);
                x++;
            }
        }
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

    public static void startMap() {
        Random random = new Random();
        int r = random.nextInt(1, 100);
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                if (r % 2 == 0) {
                    StdDraw.setPenColor(Color.GREEN);
                } else {
                    StdDraw.setPenColor(Color.BLUE);
                }
                StdDraw.filledSquare(x, y,0.5);
                r = random.nextInt(1, 100);
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
