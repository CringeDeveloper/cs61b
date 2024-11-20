package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        AList<Integer> ns = new AList<Integer>();
        AList<Double> times = new AList<Double>();
        AList<Integer> opCounts = new AList<Integer>();
        int start = 1000;

        for (int j = 1; j <= 8; j++) {
            AList<Integer> L = new AList<Integer>();

            Stopwatch sw = new Stopwatch();
            for (int i = 0; i < start; i++) {
                L.addLast(0);
            }
            double time = sw.elapsedTime();
            ns.addLast(start);
            times.addLast(time);
            opCounts.addLast(start);

            start = start * 2;
        }

        printTimingTable(ns, times, opCounts);
    }
}
