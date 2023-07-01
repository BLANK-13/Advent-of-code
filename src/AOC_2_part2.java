import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AOC_2_part2 {
    public static void main(String[] args) throws IOException {
        Path fileName = Paths.get( "C:\\Users\\Saud\\IdeaProjects\\practice\\src\\RPS.txt");
        String content = Files.readString(fileName);

        String[] splitted = content.split("\n");
        int totalScore = 0;
        int xBonus = 1, yBonus = 2, zBonus = 3;

        for (String s : splitted){

            switch (s.charAt(2)) {

                case 'X' -> {
                    if (s.charAt(0) == 'A') {
                        totalScore += zBonus;
                    } else if (s.charAt(0) == 'B') {
                        totalScore += xBonus;
                    } else if (s.charAt(0) == 'C') {
                        totalScore += yBonus;

                    }
                }
                case 'Y' -> {
                    if (s.charAt(0) == 'A') {
                        totalScore += 3 + xBonus;
                    } else if (s.charAt(0) == 'B') {
                        totalScore += 3 + yBonus;
                    } else if (s.charAt(0) == 'C') {
                        totalScore += 3 + zBonus;

                    }
                }
                case 'Z' -> {
                    if (s.charAt(0) == 'A') {
                        totalScore += 6 + yBonus;
                    } else if (s.charAt(0) == 'B') {
                        totalScore += 6 + zBonus;
                    } else if (s.charAt(0) == 'C') {
                        totalScore += 6 + xBonus;

                    }
                }
            }
        }
        System.out.println(totalScore);
    }
}
