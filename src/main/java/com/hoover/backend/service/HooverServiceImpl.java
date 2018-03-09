package com.hoover.backend.service;

import com.hoover.backend.model.CoOrds;
import com.hoover.backend.model.Hoover;
import com.hoover.backend.model.Room;
import org.apache.commons.lang3.Range;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HooverServiceImpl implements HooverService{
    private Range<Integer> roomX;
    private Range<Integer> roomY;

    public Hoover startHoover(Hoover hoover, Room room, String directions){
        roomX = Range.between(0, room.getSize().getX()-1);
        roomY = Range.between(0, room.getSize().getY()-1);
        List<CoOrds> dirtPatches = room.getDirtPatches();
        int dirtCounter = hoover.getCleanedPatches();
        CoOrds hooverPosition = hoover.getPosition();

        for(int i=0; i<directions.length(); i++){
            switch(directions.charAt(i)){
                case 'N':
                    hooverPosition = moveNorthOrSouth(hooverPosition, 1);
                    break;
                case 'S':
                    hooverPosition = moveNorthOrSouth(hooverPosition, -1);
                    break;
                case 'E':
                    hooverPosition = moveEastOrWest(hooverPosition, 1);
                    break;
                case 'W':
                    hooverPosition = moveEastOrWest(hooverPosition, -1);
                    break;
            }
            if(dirtPatches.contains(hooverPosition)){
                dirtCounter++;
                dirtPatches.remove(hooverPosition);
                room.setDirtPatches(dirtPatches);
            }
        }
        hoover.setCleanedPatches(dirtCounter);
        hoover.setPosition(hooverPosition);
        return hoover;
    }

    private CoOrds moveNorthOrSouth(CoOrds position, int direction){
        if(roomY.contains(position.getY()+direction)){
            position.setY(position.getY()+direction);
        }
        return position;
    }

    private CoOrds moveEastOrWest(CoOrds position, int direction){
        if(roomX.contains(position.getX()+direction)){
            position.setX(position.getX()+direction);
        }
        return position;
    }
}
