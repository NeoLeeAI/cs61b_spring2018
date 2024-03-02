import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void arrayDequeTest() {
        ArrayDequeSolution<Integer> ad = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        String msg = "";

        for (int i = 0; i < 100; i += 1) {
            int flag = StdRandom.uniform(0, 4);

            if (flag == 0) {
                Integer val = StdRandom.uniform(100);
                sad.addLast(val);
                ad.addLast(val);
                msg += "addLast(" + i + ")\n";
            } else if (flag == 1) {
                Integer val = StdRandom.uniform(100);
                sad.addFirst(val);
                ad.addFirst(val);
                msg += "addFirst(" + i + ")\n";
            } else if (flag == 2) {
                if (sad.isEmpty()) {
                    continue;
                }
                Integer ac = sad.removeLast();
                Integer exp = ad.removeLast();
                msg = msg + "removeLast(" + ")\n";
                assertEquals(msg, exp, ac);
            } else {
                if (sad.isEmpty()) {
                    continue;
                }
                Integer ac = sad.removeFirst();
                Integer exp = ad.removeFirst();
                msg = msg + "removeFirst(" + ")\n";
                assertEquals(msg, exp, ac);
            }
        }
    }
}
