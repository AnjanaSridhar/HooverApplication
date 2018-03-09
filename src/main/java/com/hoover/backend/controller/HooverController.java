package com.hoover.backend.controller;

import com.hoover.backend.model.CoOrds;
import com.hoover.backend.model.Hoover;
import com.hoover.backend.model.Room;
import com.hoover.backend.request.RequestWrapper;
import com.hoover.backend.service.HooverService;
import com.hoover.backend.util.JsonOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HooverController {
    @Autowired
    private HooverService hooverService;

    @RequestMapping(value = "/clean", consumes="application/json", produces = "application/json",
            method = RequestMethod.POST)
    public ResponseEntity clean(@RequestBody @NotNull RequestWrapper json){
        Hoover hoover = new Hoover(new CoOrds(json.getCoords()[0], json.getCoords()[1]), 0);
        List<CoOrds> dirtPatches = new ArrayList<>();
        for (int[] patch: json.getPatches()) {
            dirtPatches.add(new CoOrds(patch[0],patch[1]));
        }
        Room room = new Room(new CoOrds(json.getRoomSize()[0], json.getRoomSize()[1]));
        room.setDirtPatches(dirtPatches);
        hoover = hooverService.startHoover(hoover, room, json.getInstructions());
        return new ResponseEntity<>(JsonOperations.writeToJson(hoover), HttpStatus.OK);
    }
}
