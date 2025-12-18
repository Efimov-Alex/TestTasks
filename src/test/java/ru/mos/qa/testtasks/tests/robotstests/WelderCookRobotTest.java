package ru.mos.qa.testtasks.tests.robotstests;

import org.junit.jupiter.api.Test;
import ru.mos.qa.testtasks.robots.WelderCookRobot;

import static org.junit.jupiter.api.Assertions.*;

public class WelderCookRobotTest {
    @Test
    public void testWelderCookRobotCreation() {
        WelderCookRobot robot = new WelderCookRobot("WeldCook-700");

        assertTrue(robot.getEnergyType().contains("Hybrid"));
        assertTrue(robot.getEnergyType().contains("Combustion"));
        assertTrue(robot.getEnergyType().contains("Electric"));
        assertEquals("Walking", robot.getMovementType());
    }

    @Test
    public void testEnergyConsumption() {
        WelderCookRobot robot = new WelderCookRobot("WeldCook-700");

        int initialEnergy = robot.getEnergyLevel();
        robot.move();
        robot.performTasks();

        assertTrue(robot.getEnergyLevel() < initialEnergy);
    }
}
