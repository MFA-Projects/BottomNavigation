package com.mfa.library.bottomnavigation.BottomNavigation;

public class ModelBottomNavigation {
    private String title, sImage;
    private int icon;

    public ModelBottomNavigation(String title, int icon, String sImage) {
        this.title = title;
        this.sImage = sImage;
        this.icon = icon;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getsImage() {
        return sImage;
    }

    public void setsImage(String sImage) {
        this.sImage = sImage;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
