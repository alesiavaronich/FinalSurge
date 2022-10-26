package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserProfileModel {

    private String firstName;
    private String lastName;
    private String birthday;
    private String city;
    private String zip;
}
