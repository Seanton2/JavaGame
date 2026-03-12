import java.util.Random;

public class Randomizer {
    private static final Random random = new Random();

    public static int calculateDamage(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    public static boolean checkCritical(double chance) {
        return random.nextDouble() < chance;
    }

    public static int getRandomIndex(int listSize) {
        if (listSize <= 0) return 0;
        return random.nextInt(listSize);
    }
}
