package ru.mos.qa.testtasks.tests.robotstests;


import org.junit.jupiter.api.Test;
import ru.mos.qa.testtasks.robots.AllInOneRobot;

import static org.junit.jupiter.api.Assertions.*;

public class AllInOneRobotTest {
    @Test
    public void testAllInOneRobotCreation() {
        AllInOneRobot robot = new AllInOneRobot("OmniBot-9000");

        assertTrue(robot.getEnergyType().contains("Hybrid"));
        assertTrue(robot.getEnergyType().contains("Nuclear"));
        assertTrue(robot.getEnergyType().contains("Electric"));
        assertEquals("Flying", robot.getMovementType());
    }

    @Test
    public void testAllCapabilities() {
        AllInOneRobot robot = new AllInOneRobot("OmniBot-9000");

        robot.move();
        robot.performTasks();

        assertTrue(robot.getEnergyLevel() < 100);
        assertTrue(robot.hasEnergy());
    }

    @Test
    public void testEnergyManagement() {
        AllInOneRobot robot = new AllInOneRobot("OmniBot-9000");

        for (int i = 0; i < 10; i++) {
            robot.move();
            robot.performTasks();
        }

        assertTrue(robot.getEnergyLevel() < 50);
    }
}
