package pl.dawiecz.math.task;

import java.util.Random;

public class TaskFactory {
    public static final String ALPHABET = "1234567890/*-+";
    private static final Random random = new Random();

    public Task create(int maxLength) {
        int length = random.nextInt(maxLength);
        String stringBuilder = randomTaskOperation(length);
        return new Task(stringBuilder);
    }

    private String randomTaskOperation(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        return stringBuilder.toString();
    }
}
