package com.se491.sensorweb.DTO;

public class UserDTO {
    private Long userId;

    private String firstName;

    private String lastName;

    private boolean isActive;

    private String dateCreated;

    private String username;

    private String email;

    private String addressLine1;

    private String addressLine2;

    private String state;

    private String city;

    private String zip;

    public UserDTO( String firstName, String lastName, boolean isActive, String dateCreated, String username, String email, String addressLine1, String addressLine2, String state, String city, String zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.dateCreated = dateCreated;
        this.username = username;
        this.email = email;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.state = state;
        this.city = city;
        this.zip = zip;
    }

    public UserDTO() {

    }

    @Override
    public String toString() {
        return "UserDTO {" +
                "fistName='" + firstName + '\'' +
                "\n\tlastName=" + lastName + '\'' +
                "\n\tisActive=" + isActive + '\'' +
                "\n\tdateCreate=" + dateCreated + '\'' +
                "\n\tusername=" + username + '\'' +
                "\n\temail=" + email + '\'' +
                "\n\taddressLine1=" + addressLine1 + '\'' +
                "\n\taddressLine2=" + addressLine2 + '\'' +
                "\n\tstate=" + state + '\'' +
                "\n\tcity=" + city + '\'' +
                "\n\tzip=" + zip + '\'' +
                "}";
    }
}