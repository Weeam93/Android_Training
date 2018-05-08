package com.example.weeamawad.simplelogindatabindingapp.model;

/**
 * Created by Weeam Awad on 5/7/2018.
 */

public class Item {

    private String mLabel;
    private String mDate;
    private final SportType mType;
    private boolean isCategoryHeader;

    public Item(String label, SportType type) {
        this.mLabel = label;
        this.mType = type;
    }

    public String getLabel() {
        return mLabel;
    }

    public void setLabel(String mLabel) {
        this.mLabel = mLabel;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        this.mDate = date;
    }

    public SportType getType() {
        return mType;
    }

    public void setCategoryHeader(boolean categoryHeader) {
        isCategoryHeader = categoryHeader;
    }

    public boolean isCategoryHeader() {
        return isCategoryHeader;
    }

    public enum SportType {
        SOCCER,
        BASEBALL,
        BASKETBALL
    }
}
