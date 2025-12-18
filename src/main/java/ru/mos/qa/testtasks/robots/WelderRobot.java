package ru.mos.qa.testtasks.robots;


import ru.mos.qa.testtasks.robots.energy.CombustionEnergy;
import ru.mos.qa.testtasks.robots.movement.Drivable;
import ru.mos.qa.testtasks.robots.tasks.RobotTask;
import ru.mos.qa.testtasks.robots.tasks.WelderTask;

public class WelderRobot extends Robot {
    public WelderRobot(String name) {
        super(name, new CombustionEnergy(50), new Drivable());
        this.tasks = new RobotTask[]{new WelderTask()};
    }
}
