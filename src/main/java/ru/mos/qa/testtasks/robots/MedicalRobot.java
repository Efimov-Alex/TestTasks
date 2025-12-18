package ru.mos.qa.testtasks.robots;

import ru.mos.qa.testtasks.robots.energy.ElectricEnergy;
import ru.mos.qa.testtasks.robots.movement.Walkable;
import ru.mos.qa.testtasks.robots.tasks.MedicalTask;
import ru.mos.qa.testtasks.robots.tasks.RobotTask;

public class MedicalRobot extends Robot {
    public MedicalRobot(String name) {
        super(name, new ElectricEnergy(), new Walkable());
        this.tasks = new RobotTask[]{new MedicalTask()};
    }
}
