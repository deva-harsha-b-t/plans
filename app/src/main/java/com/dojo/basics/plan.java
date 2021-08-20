package com.dojo.basics;

public class plan {
    String planHeading;
    String planName;
    String planPrice;
    int reSourceID;
    boolean fore;
    boolean back;

    public boolean getFore() {
        return fore;
    }

    public void setFore(boolean fore) {
        this.fore = fore;
    }

    public boolean getBack() {
        return back;
    }

    public void setBack(boolean back) {
        this.back = back;
    }

    public plan(String planHeading, String planName, String planPrice, int reSourceID, boolean fore, boolean back) {
        this.planHeading = planHeading;
        this.planName = planName;
        this.planPrice = planPrice;
        this.reSourceID = reSourceID;
        this.fore = fore;
        this.back = back;
    }

    public String getPlanHeading() {
        return planHeading;
    }

    public void setPlanHeading(String planHeading) {
        this.planHeading = planHeading;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanPrice() {
        return planPrice;
    }

    public void setPlanPrice(String planPrice) {
        this.planPrice = planPrice;
    }

    public int getReSourceID() {
        return reSourceID;
    }

    public void setReSourceID(int reSourceID) {
        this.reSourceID = reSourceID;
    }
}
