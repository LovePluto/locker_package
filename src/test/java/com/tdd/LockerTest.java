package com.tdd;

import org.junit.Test;
import static org.junit.Assert.*;

public class LockerTest {


    @Test
    public void should_get_ticket_when_given_locker_and_pack_then_save_pack(){
        Locker locker = new Locker();
        Pack pack = new Pack();

        Ticket ticket = locker.save(pack);

        assertNotNull(ticket);
    }
}
