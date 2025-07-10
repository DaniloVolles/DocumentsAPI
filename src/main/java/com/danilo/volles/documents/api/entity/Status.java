package com.danilo.volles.documents.api.entity;

import java.util.Random;

public enum Status {
    PENDING,
    PROCESSED,
    APPROVED;

    public static Status getRandomStatus() {
        Random random = new Random();
        Status[] statuses = Status.values();
        return statuses[random.nextInt(statuses.length)];
    }
}
