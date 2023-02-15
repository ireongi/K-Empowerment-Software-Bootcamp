package Java_Network.Tesk.Stream;

package Java_Network.Tesk.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Member {
    String name;
    Gender gender;
    int age;


    List<String> names = List.of("홍길동", "배장화", "임꺽정", "연흥부", "김선달", "황진이");

    public Member() {

    }

    enum Gender {남, 여}

    List<Integer> ages = List.of(25, 20, 29, 28, 32, 18);
    List<Gender> genders = List.of(Gender.남, Gender.여, Gender.남, Gender.남, Gender.남, Gender.여);

    public Member(String name, Gender gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return String.format("Member(%s, %s, %d, name)", name, gender, age);
    }
}


