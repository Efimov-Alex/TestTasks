package ru.mos.qa.testtasks.tests.robotstests;


import org.junit.jupiter.api.Test;
import ru.mos.qa.testtasks.robots.MedicalRobot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MedicalRobotTest {
    @Test
    public void testMedicalRobotCreation() {
        MedicalRobot robot = new MedicalRobot("MedBot-1000");

        assertEquals("MedBot-1000", robot.getName());
        assertEquals("Electric", robot.getEnergyType());
        assertEquals("Walking", robot.getMovementType());
        assertTrue(robot.hasEnergy());
    }

    @Test
    public void testMedicalRobotMovement() {
        MedicalRobot robot = new MedicalRobot("MedBot-1000");
        int initialEnergy = robot.getEnergyLevel();

        robot.move();

        assertTrue(robot.getEnergyLevel() < initialEnergy);
        assertTrue(robot.hasEnergy());
    }

    @Test
    public void testMedicalRobotTasks() {
        MedicalRobot robot = new MedicalRobot("MedBot-1000");

        robot.performTasks();

        assertTrue(robot.getEnergyLevel() < 100);
    }

    @Test
    public void testMedicalRobotRefuel() {
        MedicalRobot robot = new MedicalRobot("MedBot-1000");

        robot.refuel();

        for (int i = 0; i < 20; i++) {
            robot.move();
        }

        assertTrue(robot.getEnergyLevel() <= 20);
    }
}
