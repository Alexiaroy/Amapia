package com.amapia.entity;

public enum MemberType {
	VOLUNTEER("Volontaire"),
    INDIVIDUAL("Particulier"),
    ENTERPRISE("Entreprise"),
    PRODUCER("Producteur");

    private final String displayName;

    MemberType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
    
    
}
