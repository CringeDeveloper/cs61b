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
        AListNoResizing<Integer> correct = new AListNoResizing<Integer>();
        BuggyAList<Integer> buggy = new BuggyAList<Integer>();

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
}
