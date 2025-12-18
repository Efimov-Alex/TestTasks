package ru.mos.qa.testtasks.robots.tasks;

public class WelderTask implements RobotTask {
    @Override
    public void performTask() {
        System.out.println("Welding metal parts...");
    }

    @Override
    public String getTaskDescription() {
        return "Welding robot";
    }

    public void weldParts(String material) {
        System.out.println("Welding " + material + " parts together...");
    }
}