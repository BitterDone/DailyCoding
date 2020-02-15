import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        In other words, find the lowest positive integer that does not exist in the array.
//                The array can contain duplicates and negative numbers as well.
//
//                For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
        Workload w = new Workload();
        int[] a1 = {3, 4, -1, 1}; // 2
        int[] a2 = {1, 2, 0}; // 3
        System.out.println("Lowest int for a1: " + w.lowestPosInt(a1) + "\n");
        System.out.println("Lowest int for a2: " + w.lowestPosInt(a2) + "\n");
    }
}

class Workload {
    public int lowestPosInt(int[] nums) {
        if (nums == null || nums.length < 1) return 0; // null or []
        if (nums.length == 1 && nums[0] < 0) return 0; // -1
        if (nums.length == 1 && nums[0] >= 0) return nums[0]+1; // 0 1

        Arrays.sort(nums);
        int step = 0;
        while (step < nums.length-1) {
            int diff = nums[step+1] - nums[step];
            System.out.println("step: " + step + " nums[" + step + "]: " + nums[step] + " diff: " + diff);
            if (nums[step] > 0 && diff > 1) break;
            step++;
        }

        return nums[step] + 1;
    }
}