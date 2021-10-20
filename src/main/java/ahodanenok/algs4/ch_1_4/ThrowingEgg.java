package ahodanenok.algs4.ch_1_4;

/**
 * Book, exercise 1.4.24
 */
public class ThrowingEgg {

    public static int eggsNeeded(int floor) {
        int eggsBroken = 1;
        int currentFloor = 1;
        while (currentFloor < floor) {
            eggsBroken++;
            currentFloor *= 2;
        }

        if (currentFloor == floor) {
            return eggsBroken;
        }

        int lo = currentFloor / 2;
        int hi = currentFloor;
        while (lo != floor) {
            int mid = lo + (hi - lo) / 2;
            if (floor < mid) {
                hi = mid - 1;
            } else if (floor > mid) {
                lo = mid + 1;
            } else {
                lo = mid;
            }

            eggsBroken++;
        }

        if (lo != floor) {
            throw new IllegalStateException(String.format("lo != floor: lo=%d, hi=%d, floor=%d", lo, hi, floor));
        }

        return eggsBroken;
    }
}
