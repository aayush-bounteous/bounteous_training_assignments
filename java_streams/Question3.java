
import java.util.*;
import java.util.stream.Collectors;

public class Question3{
public static void main(String[] args) {
     List<student> students = Arrays.asList(
            new student("john", "male"),
            new student("emma", "female"),
            new student("alex", "male"),
            new student("sophia", "female")
        );

       List<String> result = students.stream()
    .map(s -> ("male".equalsIgnoreCase(s.getgender()) ? "Mr. " : "Ms. ") + s.getname())
    .collect(Collectors.toList());

        result.forEach(System.out::println);
}


static class student {
        String name;
        String gender;

        student(String name, String gender) {
            this.name = name;
            this.gender = gender;
        }

        String getname() {
            return name;
        }

        String getgender() {
            return gender;
        }
    }
}