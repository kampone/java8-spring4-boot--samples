package concurrent8;

import java.awt.font.NumericShaper;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

/**
 * Created by Uladzislau_Kaminski on 2/18/2017.
 */
public class LongAdderSample {
    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
        longAdder.add(2);
        longAdder.increment();
        System.out.println(longAdder.longValue());
    }
}
