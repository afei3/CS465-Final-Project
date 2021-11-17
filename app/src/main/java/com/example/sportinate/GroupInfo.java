package com.example.sportinate;


import java.security.acl.Group;
import java.util.ArrayList;

public class GroupInfo {
    public static ArrayList<GroupInfo> joined_groups = new ArrayList<>();
    public static ArrayList<GroupInfo> groups_create = new ArrayList<>();
    public static boolean test_bool = false;
    public  String sportName;
    public  String skillLevel;
    public String date;
    public String startTime;
    public String endTime;
    public String commitment;
    public String message;

    public int groupId;

    public GroupInfo(){
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

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCommitment() {
        return this.commitment;
    }

    public void setCommitment(String commitment) {
        this.commitment = commitment;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }









}
