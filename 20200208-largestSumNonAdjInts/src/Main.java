import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Workload w = new Workload();
        w.l();
    }
}

class Workload {

    public void l() {
//        int[] s = new int[]{2, 4, 6, 2, 5};
        int[] s = new int[]{5, 1, 1, 5};
        int x = largest_non_adjacent(s);
        System.out.println("Finished " + x);
    }

    public int largest_non_adjacent(int[] list) {
//        def largest_non_adjacent(arr):
        if (list == null || list.length < 1) { return 0; }
//        if not arr:
//        return 0

        return Math.max(largest_non_adjacent(getSubArray(list, 1)),
                list[0] + largest_non_adjacent(getSubArray(list, 2)));
    }

    public int[] getSubArray(int[] arr, int index) {
        if (arr != null && arr.length > index) {
            return Arrays.copyOfRange(arr, index, arr.length);
        } else {
            return new int[]{};
        }
    }

//            return max(
//            largest_non_adjacent(arr[1:]),
//    arr[0] + largest_non_adjacent(arr[2:]))
}
