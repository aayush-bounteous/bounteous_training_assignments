import java.util.*;
import java.util.stream.Stream;

public class Question2{
    public static void main(String[] args) {
         String input = "hello world";

        Map<Character, Integer> frequencymap = new HashMap<>();

        Character[] characters = input.chars()
                                      .mapToObj(c -> (char) c)
                                      .toArray(Character[]::new);

        Stream<Character> charstream = Arrays.stream(characters);

        charstream.forEach(c -> frequencymap.merge(c, 1, Integer::sum));

        frequencymap.forEach((c, count) -> System.out.println(c + ": " + count));
    }
}