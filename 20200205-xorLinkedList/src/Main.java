public class Main {
    public static void main(String[] args) {
        Workload w = new Workload();
        int three = w.car(w.cons(3, 4));
        int four = w.cdr(w.cons(3, 4));
        System.out.println("3: " + three + "\n");
        System.out.println("4: " + four + "\n");
    }
}

class Workload {
    public Pair cons(int f, int l) {
        return new Pair(f, l);
    }
    public int car(Pair p) {
        return p.first;
    }
    public int cdr(Pair p) {
        return p.last;
    }
}

class Pair {
    int first;
    int last;
    public Pair(int f, int l) {
        this.first = f;
        this.last = l;
    }
}