package com.example.dswipecards;

/**
 * Created by cammy on 06-Nov-16.
 * POJO class for storing data in android swipe cards, i.e. image and description
 */

public class CardData {

    private String description;

    private String imagePath;

    private String videoPath;

    public CardData(String imagePath, String description, String videoPath) {
        this.imagePath = imagePath;
        this.description = description;
        this.videoPath = videoPath;
    }

    public String getDescription() {
        return description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getVideoPath() { return videoPath; }

}
