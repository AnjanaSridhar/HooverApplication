package com.hoover.backend.request;

import java.util.List;

public class RequestWrapper {
    private int[] roomSize;
    private int[] coords;
    private List<int[]> patches;
    private String instructions;

    public int[] getRoomSize() {
        return roomSize;
    }

    public int[] getCoords() {
        return coords;
    }

    public List<int[]> getPatches() {
        return patches;
    }

    public String getInstructions() {
        return instructions;
    }
}
