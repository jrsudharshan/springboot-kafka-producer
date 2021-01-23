package com.jr.kafka.springbootkafkaproducer.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Message {

    private String name;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dob;
    private String email;
    private String mobileNumber;

    public Message(String name, Date dob, String email, String mobileNumber) {
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = getDate(dob);

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "Message{" +
                "name='" + name + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }

    private Date getDate(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date newDate = new Date();
        try {
             newDate = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newDate;
    }
}
