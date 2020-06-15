package com.tdd;

import com.sun.tools.javac.util.List;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PrimaryRobotTest {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

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

    // Given 管理两个locker的robot，第一个locker满，第二个locker有位置，包，when 存包，then 存入locker2,返回票。
    @Test
    public void should_store_to_locker2_and_return_ticket_given_manage_two_locker_first_full_second_not_full_when_save_pack() {
        Locker locker1 = new Locker(0);
        Locker locker2 = new Locker(5);
        PrimaryRobot primaryRobot = new  PrimaryRobot(List.of(locker1, locker2));
        Pack pack = new Pack();

        Ticket ticket = primaryRobot.save(pack);

        Assert.assertNotNull(ticket);

        Pack pickedPack = locker2.pickUp(ticket);
        Assert.assertEquals(pack, pickedPack);
    }

    // Given 管理两个locker的robot，两个locker都满，包，when 存包，then 存入失败，提示柜子已满。
    @Test
    public void should_save_fail_with_message_given_manage_two_locker_both_are_full_when_save_pack() {
        Locker locker1 = new Locker(0);
        Locker locker2 = new Locker(0);
        PrimaryRobot primaryRobot = new  PrimaryRobot(List.of(locker1, locker2));
        Pack pack = new Pack();

        try {
            primaryRobot.save(pack);
        } catch (LockerException e) {
            Assert.assertEquals("The locker is full", e.getMessage());
        }
    }

    // Given 管理两个locker的robot，票，when 取包，then 取包成功。
    @Test
    public void should_get_saved_pack_given_saved_pack_locker_and_ticket_when_pick_up_pack() {
        Locker locker1 = new Locker(2);
        Locker locker2 = new Locker(3);
        PrimaryRobot primaryRobot = new  PrimaryRobot(List.of(locker1, locker2));
        Pack pack = new Pack();
        Ticket ticket = primaryRobot.save(pack);

        Pack savedPack = primaryRobot.pickUp(ticket);

        Assert.assertEquals(pack, savedPack);
    }

    // Given 管理两个locker的robot，无效票，when 取包，then 取包失败，提示票据无效。
    @Test
    public void should_pick_up_fail_with_message_given_saved_pack_locker_and_invalid_ticket_when_pick_up_pack() {
        Locker locker1 = new Locker(2);
        Locker locker2 = new Locker(3);
        PrimaryRobot primaryRobot = new  PrimaryRobot(List.of(locker1, locker2));

        expectedEx.expect(LockerException.class);
        expectedEx.expectMessage("Invalid ticket");

        primaryRobot.pickUp(new Ticket());
    }
}
