package models;

public class User {
    String firstName;
    String lastName;
    String email;
    boolean isEmailNotifications;
    String language;
    String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEmailNotifications() {
        return isEmailNotifications;
    }

    public void setEmailNotifications(boolean emailNotifications) {
        isEmailNotifications = emailNotifications;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}