package com.amapia.entity;

public enum ColorType {
	DEFAULT("#DBDBDB"),
    RED("#FFC0C0"),
    YELLOW("#F2E0A5"),
    GREEN("#BFF5B2"),
	LIGHTBLUE("#C0F1FF"),
	BLUE("#CAE1FF"),
	PINK("#FCC0FB"),
	BROWN("#DBBC9D");

    private final String displayName;

    ColorType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
