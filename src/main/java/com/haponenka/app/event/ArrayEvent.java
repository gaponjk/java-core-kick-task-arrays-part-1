package com.haponenka.app.event;

import com.haponenka.app.entity.CustomArray;

public class ArrayEvent {
    private final CustomArray source;

    public ArrayEvent(CustomArray source) {
        this.source = source;
    }

    public CustomArray getSource() {
        return this.source;
    }
}