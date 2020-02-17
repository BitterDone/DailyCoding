public class Main {
    public static void main(String[] args) {
        Workload w = new Workload();
        w.l();
//        System.out.println("3: " + "\n");
    }
}

class Workload {
    public void l() {
        int[] memory = new int[256];
        memory[0] = -1;
        memory[1] = 10;
        System.out.println("Value at 0: " + memory[0b0]);

        int nextAddr = 0b0^0b1;
        System.out.println("Value at 1: " + memory[nextAddr]);
    }
}

class Node {
    public byte both;
    public int value;

}
class xOrLl {
    int MEM_SIZE;
    Node[] MEMORY;

    Node root;
    public xOrLl(int _MEM_SIZE, Node[] _MEMORY) {
        MEM_SIZE = _MEM_SIZE;
        MEMORY = _MEMORY;
        root = new Node();
    };

    public void add(Node n) {
        byte memAddress = Byte.parseByte(Integer.toBinaryString((int) Math.random() * MEM_SIZE));
        if (MEMORY[memAddress] == null) {
            MEMORY[memAddress] = n;
        }
    }

    public Node get(int index) {
        int i = 0;

        Node n = MEMORY[0];
        int prev = 0;
        int curr = 0;
        int next = 0;
        while (i < index) {
            n = MEMORY[next];
            prev = curr;
            curr = n.both;
            next = curr ^ prev;
        }
        return n;
    }

}