public class Main {
    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7, 18, -1, -32};

    }
}

class Workload {

}

class Node {
    private Node left;
    private Node right;
    private int val;

    public Node(int val, Node left, Node right) {
        this.left=left;
        this.right=right;
        this.val = val;
    }
}
