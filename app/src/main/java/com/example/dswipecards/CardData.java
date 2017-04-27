package com.example.dswipecards;

/**
 * POJO class for storing data in swipe cards
 */

public class CardData {

    private String shortNameAge;

    private String imagePath;

    private String videoPath;

    public CardData(String imagePath, String shortNameAge, String videoPath) {
        this.imagePath = imagePath;
        this.shortNameAge = shortNameAge;
        this.videoPath = videoPath;
    }

    public String getShortNameAge() {
        return shortNameAge;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getVideoPath() { return videoPath; }

}
