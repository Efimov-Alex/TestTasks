package ru.mos.qa.testtasks.robots.energy;
import java.time.LocalDate;

public class NuclearEnergy extends EnergySource {
    private LocalDate lastRefuelDate;
    private static final int REFUEL_YEARS = 50;

    public NuclearEnergy() {
        this.fuelType = "Nuclear";
        this.maxLevel = 100;
        this.currentLevel = 100;
        this.lastRefuelDate = LocalDate.now();
    }

    @Override
    public boolean needsRefueling() {
        return lastRefuelDate.plusYears(REFUEL_YEARS).isBefore(LocalDate.now());
    }

    @Override
    public void refuel() {
        this.currentLevel = maxLevel;
        this.lastRefuelDate = LocalDate.now();
        System.out.println("Nuclear energy refueled. Next refuel in 50 years.");
    }
}