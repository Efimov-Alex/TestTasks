package ru.mos.qa.testtasks.tests.robotstests;

import org.junit.jupiter.api.Test;
import ru.mos.qa.testtasks.robots.CookRobot;

import static org.junit.jupiter.api.Assertions.*;

public class CookRobotTest {
    @Test
    public void testCookRobotCreation() {
        CookRobot robot = new CookRobot("ChefBot-300");

        assertEquals("ChefBot-300", robot.getName());
        assertEquals("Electric", robot.getEnergyType());
        assertEquals("Walking", robot.getMovementType());
        assertTrue(robot.hasEnergy());
    }

    @Test
    public void testCookRobotFunctionality() {
        CookRobot robot = new CookRobot("ChefBot-300");

        robot.performTasks();
        assertTrue(robot.getEnergyLevel() < 100);
    }
}
