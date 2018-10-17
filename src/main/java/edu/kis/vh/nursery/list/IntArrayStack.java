package edu.kis.vh.nursery.list;

public class IntArrayStack {

    private static final int STACK_CAPACITY = 12;
    private static final int EMPTY_STACK_VALUE = -1;
    private static final int STACK_FULL_VALUE = 11;

    private final int[] NUMBERS = new int[STACK_CAPACITY];
    private int total = EMPTY_STACK_VALUE;

    public int getTotal() {
        return total;
    }

    public void countIn(int in) {
        if (!isFull()) {
            NUMBERS[++total] = in;
        }
    }

    public boolean callCheck() {
        return total == EMPTY_STACK_VALUE;
    }

    public boolean isFull() {
        return total == STACK_FULL_VALUE;
    }

    public int peekaboo() {
        if (callCheck()) {
            return EMPTY_STACK_VALUE;
        }
        return NUMBERS[total];
    }

    public int countOut() {
        if (callCheck()) {
            return EMPTY_STACK_VALUE;
        }
        return NUMBERS[total--];
    }
}