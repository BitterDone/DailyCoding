public class main {
    public static void main(String[] args) {
//        int[] nums = {3, 2, 1}; // 2 3 6
        int[] nums = {1, 2, 3, 4, 5}; // 120, 60, 40, 30, 24
        Workload w = new Workload();
        w.exclProd(nums);
    }
}

class Workload {
    public void exclProd(int[] nums) {
        int[] prods = new int[nums.length];
        int prod = 1;
        int exclIndex = 0;
        for (int i=0;i<nums.length;i++) {
            for (int j=0;j<nums.length;j++) {
//                System.out.println("excl:" + exclIndex + " j:" + j);
                if (j!=exclIndex) {
//                    System.out.println("prod:" + prod + " nums[j]" + nums[j]);
                    prod *= nums[j];
                }
                prods[exclIndex] = prod;
            }
            prod = 1;
            exclIndex++;
        }

        String in = "";
        String out = "";
        for (int i=0;i<prods.length;i++) {
            in += " " + nums[i];
            out += " " + prods[i];
        }
        System.out.println("input:  " + in);
        System.out.println("output: " + out);
    }

}