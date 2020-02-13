import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;

// https://www.youtube.com/watch?v=suj1ro8TIVY
public class Main {
    public static void main(String[] args) {
        Node node = new Node("root",
                new Node("left",
                        new Node("left.left"),
                        null),
                new Node ("right"));
        // node = Node('root', Node('left', Node('left.left')), Node('right'))

        Workload w = new Workload();
        String serialized = w.serialize(node);
        System.out.println("serialized: " + serialized);
        // serialized: root left left.left null null  null  right null null
        // serialized: root left left.left right

        String test = w.deserialize(serialized).left.left.val;
        System.out.println("Expect true: " + test.equalsIgnoreCase("left.left"));
    }
}

class Workload {
    public String serialize(Node n) {
        String serld = "null";
        if (null != n) {
            serld = n.val + " "
                    + serialize(n.left) + " "
                    + serialize(n.right); // no trailing  + " " after the right leaf
        }

        return serld;
    }

    public Node deserialize(String s) {
        // root left left.left null null  null  right null null
        String[] parts = s.split(" ");

        LinkedList<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(s.split(" ")));

        Node root = deserializeHelper(queue);
        return root;
    }

    public Node deserializeHelper(LinkedList<String> queue) {
        try {
            String pop = queue.removeFirst();
            if (!pop.equalsIgnoreCase("null")) {
                Node first = new Node(pop);
                first.left = deserializeHelper(queue);
                first.right = deserializeHelper(queue);

                return first;
            }
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException");
        }
        return null;
    }
}

class Node {
    public Node left;
    public Node right;
    public String val;

    public Node() {
        this.left=null;
        this.right=null;
        this.val = "null";
    }

    public Node(String val) {
        this.left=null;
        this.right=null;
        this.val = val;
    }

    public Node(String val, Node left, Node right) {
        this.left=left;
        this.right=right;
        this.val = val;
    }
}
