import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class AOC_4_part1_2 {
    public static void main(String[] args) throws IOException {
        Path fileName = Paths.get("C:\\Users\\Saud\\IdeaProjects\\practice\\src/day4.txt");
        String content = Files.readString(fileName);

        String[] splitted = content.split("\n");
        int flawedPairs = 0;
        int partialOverlapPairs = 0;

        for (String s : splitted) {
            System.out.println(s);
            String[] pairs = s.split(",");
            int[] leftPair = Arrays.stream(pairs[0].split("-")).mapToInt(Integer::parseInt).toArray();
            int[] rightPair = Arrays.stream(pairs[1].split("-")).mapToInt(Integer::parseInt).toArray();

            if (isOverlapping(leftPair[0], leftPair[1], rightPair[0], rightPair[1]))
                flawedPairs += 1;

            if (partiallyOverlapping(leftPair[0], leftPair[1], rightPair[0], rightPair[1]))
                partialOverlapPairs += 1;
        }
        System.out.println(flawedPairs);
        System.out.println(partialOverlapPairs);

    }

    public static boolean isOverlapping(int x1, int y1, int x2, int y2) {
        return x1 >= x2 && y1 <= y2 || x1 <= x2 && y1 >= y2;
    }

    public static boolean partiallyOverlapping(int x1, int y1, int x2, int y2) {
        return x2 <= x1 && x1 <= y2 || x1 <= x2 && x2 <= y1;
    }

}
