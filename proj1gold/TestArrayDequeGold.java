import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void arrayDequeTest() {
        ArrayDequeSolution<Integer> ad = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        String msg = "";

        for (int i = 0; i < 100; i += 1) {
            int numberBetweenZeroAndFour = StdRandom.uniform(0, 4);

            if (numberBetweenZeroAndFour == 0) {
                sad.addLast(i);
                ad.addLast(i);
                msg = msg + "addLast(" + i + ")" + "\n";
            } else if (numberBetweenZeroAndFour == 1) {
                sad.addFirst(i);
                ad.addFirst(i);
                msg = msg + "addFirst(" + i + ")" + "\n";
            } else if (numberBetweenZeroAndFour == 2) {
                assertEquals(msg, ad.isEmpty(), sad.isEmpty());
                if (ad.isEmpty()) break;
                Integer sadLast = sad.removeLast();
                Integer adLast = ad.removeLast();
                msg = msg + "removeLast(" + ")" + "\n";
                assertEquals(msg, sadLast, adLast);
            } else {
                assertEquals(msg, ad.isEmpty(), sad.isEmpty());
                if (ad.isEmpty()) break;
                Integer sadFirst = sad.removeFirst();
                Integer adFirst = ad.removeFirst();
                msg = msg + "removeFirst(" + ")" + "\n";
                assertEquals(msg, sadFirst, adFirst);
            }
        }
    }
}
