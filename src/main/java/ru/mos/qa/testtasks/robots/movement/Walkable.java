package ru.mos.qa.testtasks.robots.movement;

public class Walkable implements MovementType {
    @Override
    public void move() {
        System.out.println("Walking on legs...");
    }

    @Override
    public String getMovementType() {
        return "Walking";
    }
}
