package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewWorkoutModel {

    private String date;
    private String timeOfDay;
    private String workoutName;
    private String workoutDescription;
    private String distance;
    private String duration;
    private String minHr;
    private String maxHr;
}
