package ru.mos.qa.testtasks.robots;


import ru.mos.qa.testtasks.robots.energy.CombustionEnergy;
import ru.mos.qa.testtasks.robots.energy.HybridEnergy;
import ru.mos.qa.testtasks.robots.energy.NuclearEnergy;
import ru.mos.qa.testtasks.robots.movement.Drivable;
import ru.mos.qa.testtasks.robots.tasks.MedicalTask;
import ru.mos.qa.testtasks.robots.tasks.RobotTask;
import ru.mos.qa.testtasks.robots.tasks.WelderTask;

public class MedicalWelderRobot extends Robot {
    public MedicalWelderRobot(String name) {
        super(name,
                new HybridEnergy(new NuclearEnergy(), new CombustionEnergy(30)),
                new Drivable());
        this.tasks = new RobotTask[]{new MedicalTask(), new WelderTask()};
    }
}