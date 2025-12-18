package ru.mos.qa.testtasks.robots.energy;

public class ElectricEnergy extends EnergySource {
    private static final int LOW_BATTERY_THRESHOLD = 20;

    public ElectricEnergy() {
        this.fuelType = "Electric";
        this.maxLevel = 100;
        this.currentLevel = 100;
    }

    @Override
    public boolean needsRefueling() {
        return currentLevel <= LOW_BATTERY_THRESHOLD;
    }

    @Override
    public void refuel() {
        this.currentLevel = maxLevel;
        System.out.println("Battery fully charged to 100%.");
    }

    public void consumeBattery(int percent) {
        consumeEnergy(percent);
    }
}
