package ru.mos.qa.testtasks.robots.tasks;

public class MedicalTask implements RobotTask {
    private String[] tools = {"Scanner", "Syringe", "Bandages"};

    @Override
    public void performTask() {
        System.out.println("Performing medical procedures with tools: " + String.join(", ", tools));
    }

    @Override
    public String getTaskDescription() {
        return "Medical robot with tools: " + String.join(", ", tools);
    }

    public void analyzePatient() {
        System.out.println("Analyzing patient's condition...");
    }

    public void performSurgery() {
        System.out.println("Performing surgery...");
    }
}
