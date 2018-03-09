package com.hoover.backend.model;

import java.util.List;

public class Room {
    private CoOrds size;
    private List<CoOrds> dirtPatches;
    public Room(CoOrds size){
        this.size = size;
    }

    public List<CoOrds> getDirtPatches() {
        return dirtPatches;
    }

    public void setDirtPatches(List<CoOrds> dirtPatches) {
        this.dirtPatches = dirtPatches;
    }

    public CoOrds getSize() {
        return size;
    }
}
