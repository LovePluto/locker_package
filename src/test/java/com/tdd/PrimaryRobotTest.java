package com.tdd;

import com.sun.tools.javac.util.List;
import org.junit.Assert;
import org.junit.Test;

public class PrimaryRobotTest {
    // Given 管理两个都有位置的locker的robot，包，when 存包，then 存入locker1,返回票。
    @Test
    public void should_store_to_locker1_and_return_ticket_given_manage_two_not_fulled_locker_when_save_pack() {
        Locker locker1 = new Locker(10);
        Locker locker2 = new Locker(5);
        PrimaryRobot primaryRobot = new  PrimaryRobot(List.of(locker1, locker2));
        Pack pack = new Pack();

        Ticket ticket = primaryRobot.save(pack);

        Assert.assertNotNull(ticket);

        Pack pickedPack = locker1.pickUp(ticket);
        Assert.assertEquals(pack, pickedPack);
    }
}
