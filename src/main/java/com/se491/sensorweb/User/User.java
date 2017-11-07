package com.se491.sensorweb.User;

import com.se491.sensorweb.Password;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.se491.sensorweb.Password.check;
import static com.se491.sensorweb.Password.getSaltedHash;

@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long userId;

    private String firstName;

    private String lastName;

    private boolean isActive;

    private String dateCreated;

    private String username;

    private String password;

    private String email;

    private String addressLine1;

    private String addressLine2;

    private String state;

    private String city;

    private String zip;

    public User(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        this.dateCreated = dateFormat.format(date);
        this.isActive = true;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void hashPassword() throws Exception {
        this.password = getSaltedHash(this.password);
    }

    public boolean checkPassword(String inputPass) throws Exception {
        return check(inputPass, this.password);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean validate() {
        if(this.password == null || this.password.equals("") || this.username == null || this.username.equals("")){
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        return "{" +
                "\'userId\'" + ": \'" + this.userId + "\'" +
                "\'firstName\'" + ": \'" + this.firstName + "\'" +
                "\'lastName\'" + ": \'" + this.lastName + "\'" +
                "\'username\'" + ": \'" + this.username + "\'" +
                "\'isActive\'" + ": \'" + this.isActive +
                "\'dateCreated\'" + ": \'" + this.dateCreated + "\'" +
                "\'email\'" + ": \'" + this.email + "\'" +
                "\'addressLine1\'" + ": \'" + this.addressLine1 + "\'" +
                "\'addressLine2\'" + ": \'" + this.addressLine2 + "\'" +
                "\'state\'" + ": \'" + this.state + "\'" +
                "\'city\'" + ": \'" + this.city + "\'" +
                "\'zip\'" + ": \'" + this.zip + "\'" +
                "}";

    }

}