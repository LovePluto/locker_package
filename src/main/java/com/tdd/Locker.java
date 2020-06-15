package com.tdd;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private int capacity;
    private Map<Ticket, Pack> savedPack = new HashMap<>();

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public Ticket save(Pack pack) {
        if (capacity == 0) {
            return null;
        }
        Ticket ticket = new Ticket();
        savedPack.put(ticket, pack);
        return ticket;
    }

    public Pack pickUp(Ticket ticket) {
        return savedPack.remove(ticket);
    }
}
