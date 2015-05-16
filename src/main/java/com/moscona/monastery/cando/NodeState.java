package com.moscona.monastery.cando;

/**
 * Created by Arnon Moscona on 5/9/2015.
 * Possible states of a Node.
 */
public enum NodeState {
    DISCONNECTED("Initial state, unannounced. Not ready for use"),
    ANNOUNCED("Announced. Waiting to be joined. Not ready for use"),
    JOINED("Joined cluster. ID is valid. May be connected");

    private String description;

    NodeState(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
