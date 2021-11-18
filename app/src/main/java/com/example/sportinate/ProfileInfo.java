package com.example.sportinate;

import java.util.ArrayList;
import java.io.Serializable;

public class ProfileInfo implements Serializable {
    public static ArrayList<GroupInfo> joined_groups = new ArrayList<>();
    public static ArrayList<GroupInfo> groups_create = new ArrayList<>();
    public static boolean test_bool = false;
    public static boolean group_test_bool = false;
    public  String sportName;
    public  String skillLevel;
    public String date;
    public String startHour;
    public String startMinute;
    public String startAmpm;

    public String endHour;
    public String endMinute;
    public String endAmpm;

    public String location;
    public String commitment;
    public String message;

    public int groupId;

    public ProfileInfo(){
    }

    public String getSportName() {
        return this.sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getSkillLevel() {
        return this.skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

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


    public String getCommitment() {
        return this.commitment;
    }

    public void setCommitment(String commitment) {
        this.commitment = commitment;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
