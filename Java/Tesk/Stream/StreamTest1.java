package Java_Network.Tesk.Stream;

import java.util.List;
import java.util.Optional;

public class StreamTest1 {
    public static void main(String[] args) {
        List<String> names = List.of("홍길동", "배장화", "임꺽정", "연흥부", "김선달", "황진이");

        names.stream()
                .filter(n -> n.charAt(0)<'이')
                .forEach(s -> System.out.printf(s + " "));
        System.out.println();

        names.stream()
                .sorted()
                .forEach(s -> System.out.printf(s + " "));
        System.out.println();

        System.out.println(Optional.of(names.get(0)));
        names.stream()
                .findFirst()
                .ifPresent(s -> System.out.println(s));

        System.out.println(names.stream().count());

    }
}
