package models;

import lombok.*;

@Data
@RequiredArgsConstructor
public class User_Lombok {
    @NonNull
    String firstName;
    @NonNull
    String lastName;
    String email;
    boolean isEmailNotifications;
    String language;
    String password;
}
