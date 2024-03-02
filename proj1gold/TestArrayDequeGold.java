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
            Integer val = Integer.valueOf(StdRandom.uniform(100));

            if (flag == 0) {
                sad.addLast(val);
                ad.addLast(val);
                msg = msg + "addLast(" + i + ")" + "\n";
            } else {
                if (flag == 1) {
                    sad.addFirst(val);
                    ad.addFirst(val);
                    msg = msg + "addFirst(" + i + ")" + "\n";
                } else {
                    if (flag == 2) {
                        if (!ad.isEmpty()) {
                            assertEquals(msg, ad.isEmpty(), sad.isEmpty());
                            if (ad.isEmpty()) break;
                            Integer ac = sad.removeLast();
                            Integer exp = ad.removeLast();
                            msg = msg + "removeLast(" + ")" + "\n";
                            assertEquals(msg, exp, ac);
                        }
                    } else {
                        if (!ad.isEmpty()) {                        assertEquals(msg, ad.isEmpty(), sad.isEmpty());
                            if (ad.isEmpty()) break;
                            Integer ac = sad.removeFirst();
                            Integer exp = ad.removeFirst();
                            msg = msg + "removeFirst(" + ")" + "\n";
                            assertEquals(msg, exp, ac);
                        }
                    }
                }
            }
        }
    }
}
