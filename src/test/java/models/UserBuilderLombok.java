package models;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Builder

public class UserBuilderLombok {
    String firstName;
    String lastName;
    String email;
    boolean isEmailNotifications;
    String language;
    String password;
}
