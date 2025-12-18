package ru.mos.qa.testtasks.tests.robotstests;


import org.junit.jupiter.api.Test;
import ru.mos.qa.testtasks.robots.WelderRobot;

import static org.junit.jupiter.api.Assertions.*;

public class WelderRobotTest {
    @Test
    public void testWelderRobotCreation() {
        WelderRobot robot = new WelderRobot("WeldMaster-500");

        assertEquals("WeldMaster-500", robot.getName());
        assertEquals("Combustion", robot.getEnergyType());
        assertEquals("Driving", robot.getMovementType());
        assertTrue(robot.hasEnergy());
    }

    @Test
    public void testWelderRobotEnergyConsumption() {
        WelderRobot robot = new WelderRobot("WeldMaster-500");
        int initialEnergy = robot.getEnergyLevel();

        robot.move();
        robot.performTasks();

        assertTrue(robot.getEnergyLevel() < initialEnergy);
    }
}
