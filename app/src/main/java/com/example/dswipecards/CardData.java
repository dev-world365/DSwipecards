package com.example.dswipecards;

/**
 * POJO class for storing data in swipe cards
 */

public class CardData {

    private String shortNameAge,imagePath, videoPath, workStudyLocation, distanceAway,
            description, rating;

    public CardData(String imagePath, String videoPath, String shortNameAge,
                    String workStudyLocation, String distanceAway, String description, String rating) {
        this.imagePath = imagePath;
        this.videoPath = videoPath;
        this.shortNameAge = shortNameAge;
        this.workStudyLocation = workStudyLocation;
        this.distanceAway = distanceAway;
        this.description = description;
        this.rating = rating;
    }

    public String getShortNameAge() {
        return shortNameAge;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getVideoPath() { return videoPath; }

    public String getWorkStudyLocation() {
        return workStudyLocation;
    }

    public String getDistanceAway() {
        return distanceAway;
    }

    public String getDescription() {
        return description;
    }

    public String getRating() {
        return rating;
    }
}
