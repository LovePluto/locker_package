package com.tdd;

public class Locker {
    private int size;

    public Locker(int size) {
        this.size = size;
    }

    public Ticket save(Pack pack) {
        if (size == 0) {
            return null;
        }
        return new Ticket();
    }
}
