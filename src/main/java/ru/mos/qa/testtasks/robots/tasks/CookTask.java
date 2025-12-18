package ru.mos.qa.testtasks.robots.tasks;

public class CookTask implements RobotTask {
    @Override
    public void performTask() {
        System.out.println("Cooking food...");
    }

    @Override
    public String getTaskDescription() {
        return "Cooking robot";
    }

    public void prepareMeal(String dish) {
        System.out.println("Preparing " + dish + "...");
    }
}
