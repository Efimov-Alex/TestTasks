package ru.mos.qa.testtasks.robots.energy;

public class HybridEnergy extends EnergySource {
    private EnergySource primaryEnergy;
    private EnergySource secondaryEnergy;

    public HybridEnergy(EnergySource primary, EnergySource secondary) {
        this.fuelType = "Hybrid (" + primary.getFuelType() + "/" + secondary.getFuelType() + ")";
        this.primaryEnergy = primary;
        this.secondaryEnergy = secondary;
        this.maxLevel = 100;
        this.currentLevel = 100;
    }

    @Override
    public boolean needsRefueling() {
        return primaryEnergy.needsRefueling() || secondaryEnergy.needsRefueling();
    }

    @Override
    public void refuel() {
        if (primaryEnergy.needsRefueling()) {
            primaryEnergy.refuel();
        }
        if (secondaryEnergy.needsRefueling()) {
            secondaryEnergy.refuel();
        }
        this.currentLevel = 100;
        System.out.println("Hybrid system refueled.");
    }

    @Override
    public void consumeEnergy(int amount) {
        primaryEnergy.consumeEnergy(amount / 2);
        secondaryEnergy.consumeEnergy(amount / 2);
        super.consumeEnergy(amount);
    }
}
