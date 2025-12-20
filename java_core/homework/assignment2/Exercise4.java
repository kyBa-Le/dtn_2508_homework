package java_core.homework.assignment2;

import java.time.LocalDate;
import java.util.Random;

public class Exercise4 {
    public static void main(String[] args) {
        System.out.println("\n=== Exercise 4: Random ===");
        Random rand = new Random();

        System.out.println("Q1: Random int: " + rand.nextInt());
        System.out.println("Q2: Random double: " + rand.nextDouble());

        String[] classNames = {"An", "Bình", "Cường", "Lan", "Hùng"};
        System.out.println("Q3: Random name: " + classNames[rand.nextInt(classNames.length)]);

        LocalDate start = LocalDate.of(1995, 7, 24);
        LocalDate end = LocalDate.of(1995, 12, 20);
        long days = java.time.temporal.ChronoUnit.DAYS.between(start, end);
        LocalDate randomDate = start.plusDays(rand.nextLong(days + 1));
        System.out.println("Q4: Random date 1995: " + randomDate);

        LocalDate oneYearAgo = LocalDate.now().minusYears(1);
        days = java.time.temporal.ChronoUnit.DAYS.between(oneYearAgo, LocalDate.now());
        randomDate = oneYearAgo.plusDays(rand.nextLong(days + 1));
        System.out.println("Q5: Random date last year: " + randomDate);

        LocalDate pastDate = LocalDate.now().minusDays(rand.nextInt(10000));
        System.out.println("Q6: Random past date: " + pastDate);

        int threeDigit = 100 + rand.nextInt(900);
        System.out.println("Q7: Random 3-digit: " + threeDigit);
    }
}
