package ru.mos.qa.testtasks.robots;

import ru.mos.qa.testtasks.robots.energy.CombustionEnergy;
import ru.mos.qa.testtasks.robots.energy.ElectricEnergy;
import ru.mos.qa.testtasks.robots.energy.HybridEnergy;
import ru.mos.qa.testtasks.robots.movement.Walkable;
import ru.mos.qa.testtasks.robots.tasks.CookTask;
import ru.mos.qa.testtasks.robots.tasks.RobotTask;
import ru.mos.qa.testtasks.robots.tasks.WelderTask;

public class WelderCookRobot extends Robot {
    public WelderCookRobot(String name) {
        super(name,
                new HybridEnergy(new CombustionEnergy(40), new ElectricEnergy()),
                new Walkable());
        this.tasks = new RobotTask[]{new WelderTask(), new CookTask()};
    }
}
