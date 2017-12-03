package com.teamcookiemonsters.munch;

/**
 * Created by Mike on 12/2/2017.
 */

public class Preferences{
    private boolean OpenNow;
    private boolean Dollar1;
    private boolean Dollar2;
    private boolean Dollar3;
    private boolean Dollar4;

    public Preferences(boolean OpenNow, boolean Dollar1, boolean Dollar2, boolean Dollar3, boolean Dollar4){
        this.OpenNow = OpenNow;
        this.Dollar1 = Dollar1;
        this.Dollar2 = Dollar2;
        this.Dollar3 = Dollar3;
        this.Dollar4 = Dollar4;
    }
    public Preferences(){
        this.OpenNow = false;
        this.Dollar1 = true;
        this.Dollar2 = true;
        this.Dollar3 = true;
        this.Dollar4 = true;
    }

    public boolean getOpenNow() { return OpenNow; }

    public void setOpenNow(boolean OpenNow) { this.OpenNow = OpenNow; }

    public boolean getDollar1() { return Dollar1; }

    public void setDollar1(boolean Dollar1) { this.Dollar1 = Dollar1; }

    public boolean getDollar2() { return Dollar2; }

    public void setDollar2(boolean Dollar2) { this.Dollar2 = Dollar2; }

    public boolean getDollar3() { return Dollar3; }

    public void setDollar3(boolean Dollar3) { this.Dollar3 = Dollar3; }

    public boolean getDollar4() { return Dollar4; }

    public void setDollar4(boolean Dollar4) { this.Dollar4 = Dollar4; }
}