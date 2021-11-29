package com.example.sportinate;
import java.io.Serializable;

public class TimeSlot implements Serializable  {
    public String date;
    public String startHour;
    public String startMinute;
    public String startAmpm;

    public String endHour;
    public String endMinute;
    public String endAmpm;


    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartHour() {
        return this.startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getStartMinute() {
        return this.startMinute;
    }

    public void setStartMinute(String startMinute) {
        this.startMinute = startMinute;
    }


    public String getStartAmpm() {
        return this.startAmpm;
    }

    public void setStartAmpm(String startAmpm) {
        this.startAmpm = startAmpm;
    }

    public String getEndHour() {
        return this.endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    public String getEndMinute() {
        return this.endMinute;
    }

    public void setEndMinute(String endMinute) {
        this.endMinute = endMinute;
    }

    public String getEndAmpm() {
        return this.endAmpm;
    }

    public void setEndAmpm(String endAmpm) {
        this.endAmpm = endAmpm;
    }

}
