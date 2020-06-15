package com.tdd;

import com.sun.tools.javac.util.List;

public class PrimaryRobot {
    private List<Locker> lockers;
    public PrimaryRobot(List<Locker> lockerList) {
        this.lockers = lockerList;
    }

    public Ticket save(Pack pack) {
        for (Locker locker : lockers) {
            if (locker.isFull()) {
                continue;
            }

            return locker.save(pack);
        }
        throw  new LockerException("The locker is full");
    }
}
