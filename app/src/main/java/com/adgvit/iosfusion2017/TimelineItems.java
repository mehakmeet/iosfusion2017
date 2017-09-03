package com.adgvit.iosfusion2017;


public class TimelineItems {

    String day;
    String time;
    String heading;
    String descrpt;

    public TimelineItems(String day, String time, String heading, String descrpt) {
        this.day = day;
        this.time = time;
        this.heading = heading;
        this.descrpt = descrpt;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescrpt() {
        return descrpt;
    }

    public void setDescrpt(String descrpt) {
        this.descrpt = descrpt;
    }
}
