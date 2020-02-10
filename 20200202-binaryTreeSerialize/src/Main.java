import java.util.Arrays;

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

//        String test = w.deserialize(serialized).left.left.val;
//        System.out.println("Expect true: " + test.equalsIgnoreCase("left.left"));
    }
}

class Workload {
    public String serialize(Node n) {
        String serld = "null";
        if (null != n) {
            serld = String.valueOf(n.val) + " "
//                + String.valueOf(n.left.val)
//                + String.valueOf(n.right.val);
                    + serialize(n.left) + " "
                    + serialize(n.right) + " ";
        }

        return serld;
    }

    public Node deserialize(String s) {
        // root left left.left null null  null  right null null
        String[] parts = s.split(" ");

        if (parts[0].equalsIgnoreCase("null")) {
            return new Node();
        }

        Node n = new Node(parts[0],
                deserialize(String.join(" ", parts)),
                deserialize(String.join(" ", parts))
        );
        return new Node();
    } // return a joined string array of next stuff?
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
