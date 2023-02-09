package ru.gb;

import java.util.LinkedList;
import java.util.Random;

public class Exercise {
    private String description;

    private static final int LIST_SIZE = 16;
    private static final int MAX_RND = 100;

    public Exercise(String description) {
        this.description = description;
    }

    public void run() {
        System.out.println(description);
        System.out.println("===============");
    }

    @Override
    public String toString() {
        return description;
    }

    protected LinkedList<Integer> buildList() {
        Random rnd = new Random();
        LinkedList<Integer> retVal = new LinkedList<>();

        for (int i = 0; i < LIST_SIZE; i++) {
            retVal.add(rnd.nextInt(MAX_RND));
        }
        return retVal;
    }
}
