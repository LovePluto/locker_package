package com.tdd;

import org.junit.Test;

import static org.junit.Assert.*;

public class LockerTest {


    @Test
    public void should_get_ticket_given_locker_and_pack_when_save_pack() {
        Locker locker = new Locker(10);
        Pack pack = new Pack();

        Ticket ticket = locker.save(pack);

        assertNotNull(ticket);
    }

    @Test
    public void should_get_null_given_locker_no_location_and_pack_when_save_pack() {
        Locker locker = new Locker(0);
        Pack pack = new Pack();

        Ticket ticket = locker.save(pack);

        assertNull(ticket);
    }

    @Test
    public void should_get_pack_given_locker_has_pack_and_ticket_when_pick_up_pack() {
        Locker locker = new Locker(10);
        Pack pack = new Pack();
        Ticket ticket = locker.save(pack);

        Pack pickedPack = locker.pickUp(ticket);

        assertNotNull(pickedPack);
    }

    @Test
    public void should_get_null_given_locker_has_pack_and_ticket_when_pick_up_pack_and_pick_up_pack() {
        Locker locker = new Locker(10);
        Pack pack = new Pack();
        Ticket ticket = locker.save(pack);

        locker.pickUp(ticket);
        Pack secondPickedPack = locker.pickUp(ticket);

        assertNull(secondPickedPack);
    }
}
