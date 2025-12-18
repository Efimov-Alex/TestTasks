package ru.mos.qa.testtasks.robots.movement;

public class Flyable implements MovementType {
    @Override
    public void move() {
        System.out.println("Flying with rotors...");
    }

    @Override
    public String getMovementType() {
        return "Flying";
    }
}
