public class Main {
    public static void main(String[] args) {
//        new Worker().w();
        new Soln();

//        int res = 1^3;
//        System.out.println(res == 2);
    }
}

class Worker {
    public void w() {
        XorLinkList x = new XorLinkList();

        x.printMem();

        Node ex1 = new Node(); ex1.value = 311;
        Node ex2 = new Node(); ex2.value = 312;
        Node ex3 = new Node(); ex3.value = 313;
        Node ex4 = new Node(); ex4.value = 314;

        x.add(ex1);
        x.add(ex2);
        x.add(ex3);
        x.add(ex4);

        x.printMem();
    }
}


class XorLinkList {
    int diskSize = 256;
    public Node[] memory = new Node[diskSize];
    int headIndex = 0;
    int tailIndex = 0;

    Node head;
//    Node tail;
    public XorLinkList() {
        System.out.println("xor ctor start");
        head = new Node(); head.value = 10;
//        tail = new Node(); tail.value = 11;

        headIndex = addToMemGetPointer(head);
//        tailIndex = addToMemGetPointer(tail);

        System.out.println("Head, Tail indices: " + headIndex + ", " + tailIndex + "\n");
        memory[headIndex].both = (0^tailIndex);
        System.out.println("memory[headIndex].both = " + memory[headIndex].both);

//        memory[tailIndex].both = (0^headIndex);
//        System.out.println("memory[tailIndex].both = " + memory[tailIndex].both);

        System.out.println("xor ctor end");
    };

    public int getPrev(int candidate) { if (candidate > -1) { return candidate; } else { return 0; } }

    public void add(Node nodeToAddAsTail) {
        System.out.println("\n--------------------------------\nAdding " + nodeToAddAsTail.value);
        int prev = -1;
        int temp = 0;
        int next = headIndex;
        Node node = memory[next];

//        do {
        while (node != null && node.both != prev) {
            System.out.println("\nWe are at index " + next + " with value " + node.value);
            System.out.println("The prev index is " + prev);

            temp = next;
            next = (int)( getPrev(prev) ^ node.both);
            System.out.println("Move to XOR index " + next);

            prev = temp;
            node = memory[next];
//        } while (node != null && prev != next);
        }

//        nodeToAddAsTail.index = next;
//        System.out.println("Adding " + nodeToAddAsTail.value + " at " + nodeToAddAsTail.index + "\n--------------------------------");
        addToMemGetPointer(nodeToAddAsTail);
//        System.out.println("Added " + nodeToAddAsTail.value + " at " + nodeToAddAsTail.index + "\n--------------------------------");
    }

    public int addToMemGetPointer(Node n) { // sequential
        int index = 0;
        while (memory[index] != null) {
            index++;
        }
//        n.index = index;
        memory[index] = n;
//        System.out.println("Added " + n.value + " at index " + index);
        System.out.println("Added " + n.value);
        return index;
    }

//    public int addToMemGetPointer_random(Node n) {
//        int index = (int) (Math.random() * diskSize);
//        while (memory[index] != null) {
//            index = (int) (Math.random() * diskSize);
//        }
//        n.index = index;
//        memory[index] = n;
//        System.out.println("Added " + n.value + " at index " + index);
//        return index;
//    }

//    public Node get(int index) {
//        Node head = memory[headIndex];
//        int prev = 0;
//        int next = (byte) prev^head.both;
//
//        while (next < memory.length && memory[next] != null && memory[next].value != -1) {
//            prev = next;
//            next = memory[next].both^next;
//        }
//        return null;
//    }


    public void printMem() {
        System.out.println("\n<memory>");
        for (Node n: memory) {
            if (n != null) {
//                System.out.println("Value " + n.value + " at index " + n.index);
                System.out.println("Value " + n.value);
            }
        }
        System.out.println("</memory>\n");
    }
}
