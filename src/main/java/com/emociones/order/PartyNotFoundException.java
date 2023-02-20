package com.emociones.order;

public class PartyNotFoundException extends RuntimeException {
    public PartyNotFoundException(Long partyID) {
        super("Could not find party " + partyID);
    }
}