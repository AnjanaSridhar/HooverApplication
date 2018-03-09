package com.hoover.backend.model;

public class Hoover {
    private CoOrds position;
    private int patches;

    public Hoover(CoOrds position, int patches){
        this.position = position;
        this.patches = patches;
    }

    public CoOrds getPosition() {
        return position;
    }

    public void setPosition(CoOrds position) {
        this.position = position;
    }

    public int getCleanedPatches() {
        return patches;
    }

    public void setCleanedPatches(int cleanedPatches) {
        this.patches = cleanedPatches;
    }
}
