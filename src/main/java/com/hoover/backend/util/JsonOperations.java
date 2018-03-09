package com.hoover.backend.util;

import com.hoover.backend.model.Hoover;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonOperations {

    public static JSONObject writeToJson(Hoover hoover){

        JSONObject point = new JSONObject();
        point.put("patches", hoover.getCleanedPatches());
        JSONArray coord = new JSONArray();
        coord.add(0,hoover.getPosition().getX());
        coord.add(1,hoover.getPosition().getY());
        point.put("coords", coord);

        return point;
    }
}
