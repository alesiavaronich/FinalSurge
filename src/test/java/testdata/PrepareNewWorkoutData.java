package testdata;

import lombok.extern.log4j.Log4j;
import models.NewWorkoutModel;
import utils.FakeMessageGenerator;

@Log4j
public class PrepareNewWorkoutData {

    public static NewWorkoutModel getValidData() {
        log.info("getValidData method starts generating test data to populate New Walk Workout form");
        return NewWorkoutModel
                .builder()
                .date(FakeMessageGenerator.generateCurrentDate())
                .timeOfDay("07:00 AM")
                .workoutName("My workout")
                .workoutDescription(FakeMessageGenerator.generateWorkoutDescription())
                .distance(FakeMessageGenerator.generateDistance())
                .duration("00:51:16")
                .minHr(FakeMessageGenerator.generateMinNum())
                .maxHr(FakeMessageGenerator.generateMaxNum())
                .build();
    }
}
