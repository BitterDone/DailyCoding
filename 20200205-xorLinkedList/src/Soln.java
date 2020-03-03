public class Soln {
    int DISK_SIZE = 16;
    Node[] memory = null;
    Node head = null;
    Node tail = null;

    public Soln () {
        System.out.println("Soln");
        printMem();

        Node n1 = new Node(1);
        add(n1);
        Node n2 = new Node(2);
        add(n2);
        Node n3 = new Node(3);
        add(n3);

        printMem();

//        Node[] nums = new Node[5];
//        nums[0] = new Node();
//        nums[1] = new Node();
//        System.out.println(getLength(nums));
//        System.out.println(nums.length);
    }

    public Node get(int index) {
//        prev_id = 0
        int prev = 0;

//        node = self.head
        Node node = head;

//        for i in range(index):
        int next = -1;
        for (int i=0;i<index;i++) {

//        next_id = prev_id ^ node.both
            next = prev ^ node.both;

//        if next_id:
            if (next > -1) {

//              prev_id = id(node)
                prev = getIndex(node);
//              node = _get_obj(next_id)
                node = memory[next];

//            else:
            } else {

//              raise IndexError('Linked list index out of range')
                System.out.println("ERROR - Linked list index out of range");
                break;
            }
        }
//        return node
        return node;
    }

    public void add(Node nodeToAdd) {
        if (head == null && tail == null) {
            head = nodeToAdd;
            tail = nodeToAdd;
            memory = new Node[DISK_SIZE];
            saveNode(nodeToAdd, tail.both);
        } else {
            int nodeToAddPtr = saveNode(nodeToAdd, tail.both);

//            self.tail.both = id(node) ^ self.tail.both
            tail.both = nodeToAddPtr ^ tail.both;

//            node.both = id(self.tail)
//            self.tail = node
            tail = nodeToAdd;
        }
    }

    public int saveNode(Node n, int prevTailBoth) {
        int len = getLength(memory);
        if (len < DISK_SIZE) {
//            node.both = id(self.tail)
            n.both = prevTailBoth;

            memory[len] = n;
            System.out.println("Saved at index " + len);
            return len;
        } else {
            System.out.println("Disk full");
            return -1;
        }
    }

    public void printMem() {
        System.out.println("\n<memory>");
        if(memory != null) {
            for (Node n : memory) {
                if (n != null) {
                    System.out.println("Value " + n.value);
                }
            }
        } else {
            System.out.println("[ ]");
        }
        System.out.println("</memory>\n");
    }

    public int getIndex(Node seeking) {
        System.out.println("\n<memory>");
        if(memory == null) { return -1; }

        for (int i=0;i<memory.length;i++) {
            if (memory[i] != null && memory[i].value == seeking.value) {
                System.out.println("Value " + memory[i].value + " at index " + i);
                return i;
            }
        }
        
        return -1;
    }

    public int getLength(Node[] a) {
        int len = 0;
        while (a[len] != null) {
            len++;
        }
        return len;
    }
}
