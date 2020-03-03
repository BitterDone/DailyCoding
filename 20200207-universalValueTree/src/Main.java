public class Main {
    public static void main(String[] args) {
        Workload w = new Workload();
        w.l();
    }
}

class Workload {

    public void l() {
        System.out.println("Finished");
    }

    public Node generateSampleTree() {
        Node root = new Node(0);
        Node left = new Node(1);
        Node right = new Node(0);
        Node rightLeft = new Node(1);
        Node rightLeftLeft = new Node(1);
        Node rightLeftRight = new Node(1);
        Node rightRight = new Node(0);

        rightLeft.left = rightLeftLeft;
        rightLeft.right = rightLeftRight;

        right.left = rightLeft;
        right.right = rightRight;

        root.left = left;
        root.right = right;

        return root;
    }
}

class Node {
    public Node left = null;
    public Node right = null;
    public int value = -1;

    public Node (){}
    public Node (int val){ this.value = val; }
}