package com.tdd;

import com.sun.tools.javac.util.List;

public class PrimaryRobot {
    private List<Locker> lockers;
    public PrimaryRobot(List<Locker> lockerList) {
        this.lockers = lockerList;
    }

    public Ticket save(Pack pack) {
        return lockers.get(0).save(pack);
    }
}
