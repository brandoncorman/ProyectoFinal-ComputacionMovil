package com.example.proyectofinal.Model;

import java.util.List;

public class VoiceLine {

    private float minDuration;
    private float maxDuration;
    private List<MediaList> mediaList;

    public float getMinDuration() {
        return minDuration;
    }

    public float getMaxDuration() {
        return maxDuration;
    }

    public List<MediaList> getMediaList() {
        return mediaList;
    }
}
