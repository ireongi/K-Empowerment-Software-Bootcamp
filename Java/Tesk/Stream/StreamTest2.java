package Java_Network.Tesk.Stream;

import java.util.List;

public class StreamTest2 {
    public static void main(String[] args) {
        enum Gender{남, 여}

        List<Integer> ages = List.of(25, 20, 29, 28, 32, 18);
        List<Gender> genders = List.of(Gender.남, Gender.여, Gender.남, Gender.남, Gender.남, Gender.여);

        int sum = ages.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        System.out.println(ages.stream().max(Integer::compareTo).get());

        long countNum = ages.stream().count();
        double a = (double) sum / (double) countNum;
        System.out.printf("%.15f", a);

    }
}
