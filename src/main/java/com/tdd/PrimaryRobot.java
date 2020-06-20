package com.tdd;


import java.util.List;

public class PrimaryRobot {
    private List<Locker> lockers;

    public PrimaryRobot(List<Locker> lockerList) {
        this.lockers = lockerList;
    }

    public Ticket save(Pack pack) {

//        Optional<Locker> first = lockers.stream().parallel().filter(item -> !item.isFull()).findFirst();
//        if (!first.isPresent()) {
//            throw new LockerException("The locker is full");
//        }
//        return first.get().save(pack);
        for (Locker locker : lockers) {
            if (locker.isFull()) {
                continue;
            }

            return locker.save(pack);
        }
        throw new LockerException("The locker is full");

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
