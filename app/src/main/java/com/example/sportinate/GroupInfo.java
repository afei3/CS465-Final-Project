package com.example.sportinate;

import java.security.acl.Group;
import java.sql.Time;
import java.util.ArrayList;
import java.io.Serializable;
import com.example.sportinate.TimeSlot;

public class GroupInfo implements Serializable {
    public static ArrayList<GroupInfo> joined_groups = new ArrayList<>();
    public static ArrayList<GroupInfo> groups_create = new ArrayList<>();
    public static boolean group_1_join = false;
    public static boolean group_2_join = false;
    public static boolean group_1_create = false;
    public static boolean deleted_user = false;
    public  String sportName;
    public String groupName;
    public  String skillLevel;

    public ArrayList<TimeSlot> timeSlots = new ArrayList<>();

    public String location;
    public String commitment;
    public String message;

    public int groupId;

    public GroupInfo(){
    }

    public GroupInfo(String groupName, String sportName, String skillLevel, String location, String commitment, String message, ArrayList<TimeSlot> times) {
        this.sportName = sportName;
        this.groupName = groupName;
        this.skillLevel = skillLevel;
        this.location = location;
        this.commitment = commitment;
        this.message = message;
        this.timeSlots.addAll(times);
    }

    public String getSportName() {
        return this.sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getSkillLevel() {
        return this.skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    public ArrayList<TimeSlot> getTimeSlots() {
        return this.timeSlots;
    }

    public void addTimeslot(TimeSlot ts) {
        this.timeSlots.add(ts);
    }
    public void clearTimeSlot(){this.timeSlots.clear();}

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

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }









}
