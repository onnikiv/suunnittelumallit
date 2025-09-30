package iterator;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {

    private int count = 0;
    private final int maxCount;
    private int prev = 1;
    private int curr = 1;

    public FibonacciIterator(int maxCount) {
        this.maxCount = maxCount;
    }

    @Override
    public boolean hasNext() {
        return count < maxCount;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        int result;
        if (count == 0 || count == 1) {
            result = 1;
        } else {
            result = prev + curr;
            prev = curr;
            curr = result;
        }
        count++;
        return result;
    }
}
