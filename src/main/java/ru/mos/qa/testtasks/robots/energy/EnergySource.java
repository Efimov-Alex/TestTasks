package ru.mos.qa.testtasks.robots.energy;

public abstract class EnergySource {
    protected String fuelType;
    protected int currentLevel;
    protected int maxLevel;

    public abstract boolean needsRefueling();
    public abstract void refuel();

    public String getFuelType() {
        return fuelType;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void consumeEnergy(int amount) {
        currentLevel = Math.max(0, currentLevel - amount);
    }
}
