package iterator;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        int TARGET = 10;
        Sequence sequence = new FibonacciSequence(TARGET);
        Iterator<Integer> iterator = sequence.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
