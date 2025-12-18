package ru.mos.qa.testtasks.tests.robotstests;

import org.junit.jupiter.api.Test;
import ru.mos.qa.testtasks.robots.MedicalWelderRobot;

import static org.junit.jupiter.api.Assertions.*;

public class MedicalWelderRobotTest {
    @Test
    public void testHybridEnergyRobot() {
        MedicalWelderRobot robot = new MedicalWelderRobot("MedWeld-Hybrid");

        assertTrue(robot.getEnergyType().contains("Hybrid"));
        assertTrue(robot.getEnergyType().contains("Nuclear"));
        assertTrue(robot.getEnergyType().contains("Combustion"));
        assertEquals("Driving", robot.getMovementType());
    }

    @Test
    public void testMultipleTasks() {
        MedicalWelderRobot robot = new MedicalWelderRobot("MedWeld-Hybrid");

        robot.performTasks();
        assertTrue(robot.getEnergyLevel() < 100);
    }
}
