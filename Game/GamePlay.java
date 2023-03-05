import java.awt.*;
import java.util.Random;

public class GamePlay {
    private static final int WIDTH = 800;
    /** Window width */

    private static final int HEIGHT = 800;
    /** Window height */

    private static final double RADIUS = 80;

    private static final Random RANDOM = new Random();

    private static final Font digFont = new Font("Century", Font.ITALIC, 18);


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
        for (int i = 0; i < 5; i += 1) {
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
        startOrQuit();
    }

    public void gameStart() {
        startMap();
        digBox(true, "Hi! I'm Earth and I'm looking for a friend!");
        earthClear();
        digBox(true, "Oh, look! Someone's approaching.");
        humanClear();
        /** TODO: Loop through dialogue list(?) */
        digBox(false, "I'm humanity. I promise I'll treat you right.");
        humanClear();
        digBox(false, "I'm trying to make you better. I'm making cars to make life easier!");
        earthClear();
        digBox(true, "Oh? But the fumes are hurting me :(");
        humanClear();
        digBox(false, "Don't worry! I have a plan. Tell me which will help you:");
        choices("Doing lots of emissions testing!", "Promoting hybrid vehicles as an alternative to gas cars");
        correct('1', "They don't help when companies like Volkswagen can cheat!", "It won't happen again, we promise.", "You lied! Hybrid vehicles release almost the same emissions as gas!", "Oh, well. We still tried making them better, and that's what counts.");
        humanClear();
        digBox(false, "Why don't we talk about something else instead, like your oceans!");
        humanClear();
        digBox(false, "So full of life! Now, we're working a bunch to help.");
        earthClear();
        digBox(true, "Hmm, like what?");
        choices("Having no more plastic bottles in the ocean.", "Having more recyclable and compostable plastic.");
        correct('2', "There are still so many! Didn't CocaCola promise to have this done by 2023.", "Well, they're actually the number 1 plastic polluter.", "Were you just lying? Barely any got recycled!", "We can't control what happens after we put our things in the recycling bin.");
        earthClear();
        digBox(true, "Why are you hurting me so much :( I'm in so much pain...");
        humanClear();
        digBox(false, "I'm sorry. Just trust me, I'm doing this for you!");
        choices("Trust Humanity", "Get Rid of Humanity");
        ending();
    }

    public void ending() {
        Character input = solicitMenuInput();
        if (input.equals('1')) {
            StdDraw.clear(Color.BLACK);
        } else {
            StdDraw.clear(Color.ORANGE);
        }
        StdDraw.pause(400);
        Font font = new Font("Arial", Font.BOLD, 60);
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.text(WIDTH / 2, HEIGHT / 2, "BAD ENDING.");
        StdDraw.show();
    }
    public void correct(Character cor, String response1, String human1, String response2, String human2) {
        Character input = solicitMenuInput();
        String response;
        String human;
        if (input.equals(cor)) {
            decreaseHealth(250);
            response = response1;
            human = human1;
        } else {
            decreaseHealth(500);
            response = response2;
            human = human2;
        }
        earthClear();
        digBox(true, response);
        humanClear();
        digBox(false, human);
        StdDraw.show();
    }

    public void earthClear() {
        StdDraw.pause(2000);
        clearDig(true);
    }

    public void humanClear() {
        StdDraw.pause(2000);
        clearDig(false);
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
                gameStart();
                break;
            case 'n':
                System.exit(0);
                break;
        }
    }

    public void choices(String one, String two) {
        earthClear();
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.setFont(digFont);
        StdDraw.text(WIDTH / 2, HEIGHT / 4 + 10, "(1) " + one);
        StdDraw.text(WIDTH / 2, HEIGHT / 4 - 10, "(2) " + two);
        StdDraw.show();
    }



    public void clearDig(boolean earthTalk) {
        /** TODO: fix repetitive code! */
        if (earthTalk) {
            StdDraw.setPenColor(77,166,255);
            StdDraw.filledRectangle(6 * WIDTH / 7, HEIGHT / 4 + HEIGHT / 10, 50, 15);
            StdDraw.setPenColor(Color.WHITE);
            StdDraw.filledRectangle(WIDTH / 2, HEIGHT / 4, WIDTH / 2.5, HEIGHT / 10);

            StdDraw.setPenColor(Color.BLACK);
            StdDraw.filledRectangle(WIDTH / 7, HEIGHT / 4 + HEIGHT / 10, 50, 15);
            StdDraw.setPenColor(77,166,255);
            StdDraw.setFont(digFont);
            StdDraw.text(WIDTH / 7, HEIGHT / 4 + HEIGHT / 10, "Earth");
        } else {
            StdDraw.setPenColor(77,166,255);
            StdDraw.filledRectangle(WIDTH / 7, HEIGHT / 4 + HEIGHT / 10, 50, 15);
            StdDraw.setPenColor(Color.WHITE);
            StdDraw.filledRectangle(WIDTH / 2, HEIGHT / 4, WIDTH / 2.5, HEIGHT / 10);

            StdDraw.setPenColor(Color.BLACK);
            StdDraw.filledRectangle(6 * WIDTH / 7, HEIGHT / 4 + HEIGHT / 10, 50, 15);
            StdDraw.setPenColor(Color.red);
            StdDraw.setFont(digFont);
            StdDraw.text(6 * WIDTH / 7, HEIGHT / 4 + HEIGHT / 10, "Humanity");
        }
        StdDraw.show();
    }
    public void digBox(boolean earthTalk, String str) {
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.filledRectangle(WIDTH / 2, HEIGHT / 4, WIDTH / 2.5, HEIGHT / 10);
        if (earthTalk) {
            StdDraw.setPenColor(Color.BLACK);
            StdDraw.filledRectangle(WIDTH / 7, HEIGHT / 4 + HEIGHT / 10, 50, 15);
            StdDraw.setPenColor(77,166,255);
            StdDraw.setFont(digFont);
            StdDraw.text(WIDTH / 7, HEIGHT / 4 + HEIGHT / 10, "Earth");
            StdDraw.text(WIDTH / 2, HEIGHT / 4, str);
        } else {
            StdDraw.setPenColor(Color.BLACK);
            StdDraw.filledRectangle(6 * WIDTH / 7, HEIGHT / 4 + HEIGHT / 10, 50, 15);
            StdDraw.setPenColor(Color.red);
            StdDraw.setFont(digFont);
            StdDraw.text(6 * WIDTH / 7, HEIGHT / 4 + HEIGHT / 10, "Humanity");
            StdDraw.text(WIDTH / 2, HEIGHT / 4, str);
        }
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
                if (nextKeyTyped == 'y' || nextKeyTyped == 'n' || nextKeyTyped == '1' || nextKeyTyped =='2' ) {
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
