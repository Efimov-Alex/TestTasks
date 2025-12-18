package ru.mos.qa.testtasks.robots.movement;

public class Drivable implements MovementType {
    @Override
    public void move() {
        System.out.println("Driving on wheels...");
    }

    @Override
    public String getMovementType() {
        return "Driving";
    }
}