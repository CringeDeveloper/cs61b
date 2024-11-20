package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> buggy = new BuggyAList<>();

        correct.addLast(1);
        correct.addLast(2);
        correct.addLast(3);

        buggy.addLast(1);
        buggy.addLast(2);
        buggy.addLast(3);

        assertEquals(correct.size(), buggy.size());

        assertEquals(correct.removeLast(), buggy.removeLast());
        assertEquals(correct.removeLast(), buggy.removeLast());
        assertEquals(correct.removeLast(), buggy.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int sizeL = L.size();
                int sizeB = B.size();
                System.out.println("size: " + sizeL);
                System.out.println("size: " + sizeB);

                assertEquals(sizeL, sizeB);
            } else if (operationNumber == 2) {
                // get last
                if (L.size() != 0 && B.size() != 0) {
                    int lastL = L.getLast();
                    int lastB = B.getLast();
                    System.out.println("last: " + lastL);
                    System.out.println("last: " + lastB);

                    assertEquals(lastL, lastB);
                }
            } else if (operationNumber == 3) {
                if (L.size() != 0 && B.size() != 0) {
                    int removedL = L.removeLast();
                    int removedB = B.removeLast();

                    assertEquals(removedL, removedB);
                }
            }
        }
    }
}
