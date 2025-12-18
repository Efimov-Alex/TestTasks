package ru.mos.qa.testtasks.robots.energy;

public class CombustionEnergy extends EnergySource {
    private final int tankVolume;

    public CombustionEnergy(int tankVolume) {
        this.fuelType = "Combustion";
        this.tankVolume = tankVolume;
        this.maxLevel = tankVolume;
        this.currentLevel = tankVolume;
    }

    @Override
    public boolean needsRefueling() {
        return currentLevel <= 0;
    }

    @Override
    public void refuel() {
        this.currentLevel = maxLevel;
        System.out.println("Combustion fuel tank filled to " + tankVolume + " liters.");
    }

    public void consumeFuel(int liters) {
        consumeEnergy(liters);
    }
}
