package ru.mos.qa.testtasks.robots;

import ru.mos.qa.testtasks.robots.energy.EnergySource;
import ru.mos.qa.testtasks.robots.movement.MovementType;
import ru.mos.qa.testtasks.robots.tasks.RobotTask;

public abstract class Robot {
    protected String name;
    protected EnergySource energySource;
    protected MovementType movementType;
    protected RobotTask[] tasks;

    public Robot(String name, EnergySource energySource, MovementType movementType) {
        this.name = name;
        this.energySource = energySource;
        this.movementType = movementType;
    }

    public void move() {
        if (hasEnergy()) {
            movementType.move();
            energySource.consumeEnergy(5);
        } else {
            System.out.println("Not enough energy to move!");
        }
    }

    public void performTasks() {
        if (hasEnergy()) {
            for (RobotTask task : tasks) {
                task.performTask();
                energySource.consumeEnergy(10);
            }
        } else {
            System.out.println("Not enough energy to perform tasks!");
        }
    }

    public void refuel() {
        if (energySource.needsRefueling()) {
            energySource.refuel();
        } else {
            System.out.println("Refueling not needed yet.");
        }
    }

    public boolean hasEnergy() {
        return energySource.getCurrentLevel() > 0;
    }

    public String getName() {
        return name;
    }

    public String getEnergyType() {
        return energySource.getFuelType();
    }

    public String getMovementType() {
        return movementType.getMovementType();
    }

    public int getEnergyLevel() {
        return energySource.getCurrentLevel();
    }
}
