import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7, 18, -1, -32};
//        int target = 17;
//        int target = 20;
//        int target = 33;
//        int target = 6;
        int target = -17;
        Workload w = new Workload();
        boolean sumsToTarget = w.anyInArrSumsToTarget(arr, target);
        System.out.println("\nSums to target: " + sumsToTarget);

    }
}

class Workload {
    public boolean anyInArrSumsToTarget(int[] array, int target) {
        if (array == null || array.length < 1) return false;
        System.out.println("Target: " + target);

        boolean[] bits = newBoolArrayOfFalse(array.length);

        int step = 0;
        while(!wholeArrayIsTrue(bits)) {
            bits = flipBitsBasedOnTick(bits, step);

            int sum = 0;
            String idx = "";
            String els  = "";
            for (int i=bits.length-1; i>-1; i--) {
                if(bits[i]) {
                    sum += array[i];
                    idx += " " + i;
                    els += " " + array[i];
                }
            }
            if (sum == target) {
                printArray(bits);
                System.out.println(idx);
                System.out.println(els);
                return true;
            }

            step++;
        }
        return false;
    }

    private boolean[] flipBitsBasedOnTick(boolean[] bits, int tick) {
        for (int i=bits.length-1; i>-1; i--) {
            double num = (double) tick+1;
            double denom = Math.pow(2.0, bits.length -1 - i);
            if (num % denom == 0) {
                bits[i] = !bits[i];
            }
        }
        return bits;
    }

    private void printArray(boolean[] b) {
        String array = "";
        for (boolean _b: b) {
            array = array.concat(_b ? " 1" : " 0");
        }
        System.out.println(array);
    }

    private boolean wholeArrayIsTrue(boolean[] b) {
        for (boolean bol: b) {
            if (!bol) return false;
        }
        return true;
    }

    private boolean[] newBoolArrayOfFalse(int numBits) {
        boolean[] bits = new boolean[numBits];
        for (int i=0; i<bits.length; i++) {
            bits[numBits-1] = false;
        }
        return bits;
    }
}
