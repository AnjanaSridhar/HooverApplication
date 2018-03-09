package com.hoover.backend.service;

import com.hoover.backend.model.Hoover;
import com.hoover.backend.model.Room;

public interface HooverService {
    public Hoover startHoover(Hoover hoover, Room room, String directions);
}
