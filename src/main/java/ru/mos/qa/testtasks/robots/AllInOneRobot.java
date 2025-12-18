package ru.mos.qa.testtasks.robots;

import ru.mos.qa.testtasks.robots.energy.ElectricEnergy;
import ru.mos.qa.testtasks.robots.energy.HybridEnergy;
import ru.mos.qa.testtasks.robots.energy.NuclearEnergy;
import ru.mos.qa.testtasks.robots.movement.Flyable;
import ru.mos.qa.testtasks.robots.tasks.CookTask;
import ru.mos.qa.testtasks.robots.tasks.MedicalTask;
import ru.mos.qa.testtasks.robots.tasks.RobotTask;
import ru.mos.qa.testtasks.robots.tasks.WelderTask;

public class AllInOneRobot extends Robot {
    public AllInOneRobot(String name) {
        super(name,
                new HybridEnergy(new NuclearEnergy(), new ElectricEnergy()),
                new Flyable());
        this.tasks = new RobotTask[]{new MedicalTask(), new WelderTask(), new CookTask()};
    }
}