public class Main {
    public static void main(String[] args) {
        Workload w = new Workload();
        w.l();
    }
}

class Workload {

    public void l() {
        int sum = num_encodings("123");
        System.out.println("Finished " + sum);
    }

    public int num_encodings(String s) {
        if (s.startsWith("0")) return 0;
//        if s.startswith('0'): return 0
        else if (s.length() <= 1) return 1;
//        elif len(s) <= 1: # This covers empty string
//        return 1

        int total = 0;

        if (s.length() > 1 && Integer.valueOf(s.substring(s.length()-2)) <= 26)
//        if int(s[:2]) <= 26:
//        total += num_encodings(s[2:])
        total += num_encodings(s.substring(2));

//        total += num_encodings(s[1:])
        total += num_encodings(s.substring(1));
        return total;
    }

}
