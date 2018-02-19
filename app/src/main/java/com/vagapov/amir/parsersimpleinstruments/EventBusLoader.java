package com.vagapov.amir.parsersimpleinstruments;

import java.util.ArrayList;


public class EventBusLoader {

    private ArrayList<User> event;

    public EventBusLoader(ArrayList<User> event) {
        this.event = event;
    }

    public ArrayList<User> getEvent() {
        return event;
    }
}
