package ahodanenok.algs4.ch_1_4;

/**
 * Book, exercise 1.4.25
 */
public class ThrowingTwoEggs {

    public static int triesCount(int n, int floor) {
        int step = (int) Math.ceil(Math.sqrt(n));
        int tries = 1;

        int currentFloor = n;
        while (currentFloor > floor) {
            currentFloor -= step;
            tries++;
        }

        currentFloor = Math.max(currentFloor, 1);
        if (currentFloor == floor) {
            return tries;
        }

        for (int f = Math.min(currentFloor + step, n) - 1; f > currentFloor; f--) {
            tries++;
            if (f == floor) {
                return tries;
            }
        }

        throw new IllegalStateException("Failed to determine floor: n = " + n + ", floor = " + floor);
    }
}
