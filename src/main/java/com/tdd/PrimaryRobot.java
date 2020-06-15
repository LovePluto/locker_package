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

    public Pack pickUp(Ticket ticket) {
        for (Locker locker : lockers) {
            Pack pack = locker.pickUp(ticket);
            if (pack != null) {
                return pack;
            }
        }
        throw new LockerException("Invalid ticket");
    }
}
