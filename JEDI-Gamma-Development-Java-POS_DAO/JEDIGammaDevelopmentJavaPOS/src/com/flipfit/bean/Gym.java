package com.flipfit.bean;

public class Gym {
    private int gymId;
    private String gymName;
    private String ownerId;

    // Default Constructor
    public Gym() {}

    // Parameterized Constructor
    public Gym(int gymId, String gymName, String ownerId) {
        this.gymId = gymId;
        this.gymName = gymName;
        this.ownerId = ownerId;
    }

    // Getters and Setters
    public int getGymId() { return gymId; }
    public void setGymId(int gymId) { this.gymId = gymId; }

    public String getGymName() { return gymName; }
    public void setGymName(String gymName) { this.gymName = gymName; }

    public String getOwnerId() { return ownerId; }
    public void setOwnerId(String ownerId) { this.ownerId = ownerId; }
}