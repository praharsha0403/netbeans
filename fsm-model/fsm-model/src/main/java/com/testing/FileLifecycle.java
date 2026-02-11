package com.testing;

public class FileLifecycle {

    public enum State {
        CLOSED, OPEN, MODIFIED, SAVED, ERROR
    }

    private State currentState = State.CLOSED;

    public State getState() {
        return currentState;
    }

    public void open() {
        if (currentState == State.CLOSED) {
            currentState = State.OPEN;
        } else {
            currentState = State.ERROR;
        }
    }

    public void edit() {
        if (currentState == State.OPEN || currentState == State.SAVED) {
            currentState = State.MODIFIED;
        } else {
            currentState = State.ERROR;
        }
    }

    public void save() {
        if (currentState == State.MODIFIED) {
            currentState = State.SAVED;
        } else {
            currentState = State.ERROR;
        }
    }

    public void close() {
        if (currentState != State.CLOSED) {
            currentState = State.CLOSED;
        } else {
            currentState = State.ERROR;
        }
    }
}

