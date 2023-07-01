import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class AOC_1 {
    public static void main(String[] args) throws Exception {

        Path fileName = Paths.get( "C:\\Users\\Saud\\IdeaProjects\\practice\\src\\elves.txt");
        String content = Files.readString(fileName);

        String[] splitted = content.split(System.lineSeparator());
        HashMap<Integer,Integer> elves = new HashMap<>();
        int calories = 0;
        int elf_number = 1;
        
        for (String s : splitted) {
            if (!s.isBlank()) {
                calories += Integer.parseInt(s);
            } else {
                elves.put(elf_number, calories);
                elf_number += 1;
                calories = 0;
            }
        }

        Stream<Map.Entry<Integer,Integer>> sorted =
                elves.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue());

        sorted.forEach(System.out :: println);
        System.out.println("Top 3 total: " + (elves.get(7) + elves.get(149) + elves.get(158)));
    }

}

