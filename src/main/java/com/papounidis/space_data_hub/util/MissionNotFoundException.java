package com.papounidis.space_data_hub.util;

public class MissionNotFoundException extends RuntimeException {

    public MissionNotFoundException(int id) {
        super("Could not find mission with id: " + id + ", here is a link to all the missions: localhost:8080/missions");
    }
}
