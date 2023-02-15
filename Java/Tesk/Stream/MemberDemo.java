package Java_Network.Tesk.Stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MemberDemo {
    static int num;
    public static void main(String[] args) {
        Member m = new Member();
        Stream<String> s;

        s = m.names.stream();
        Stream<Member> first = s.map(n -> new Member(n, m.genders.get(num), m.ages.get(num++)));
        System.out.println("[Member 스트림 원소]");
        first.forEach(a -> System.out.printf(a + " "));

        num = 0;
        s = m.names.stream();
        Stream<Member> second = s.map(n -> new Member(n, m.genders.get(num), m.ages.get(num++)));
        Map<Member.Gender, List<Member>> genderMap = second.collect(Collectors.groupingBy(Member::getGender));
        System.out.println("[Member 스트림을 성별로 그룹핑]");
        System.out.println(genderMap);


    }
}
