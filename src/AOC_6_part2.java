import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class AOC_6_part2 {
    public static void main(String[] args) throws IOException {
        Path fileName = Paths.get("C:\\Users\\Saud\\IdeaProjects\\practice\\src\\day6.txt");
        String content = Files.readString(fileName);

        char[] sequenceArray = content.toCharArray();
        int tracker = 0, markerLength = 14;
        Set<Character> charSet = new HashSet<>();

        for (int i = 0; i < sequenceArray.length; i++) {

            try {
                for(int j = 0; j < markerLength;j++){
                    charSet.add(sequenceArray[i+j]);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
            if (charSet.size() == markerLength) {
                tracker = i + markerLength;
                break;
            }
            charSet.clear();
        }
        System.out.println(tracker);
    }
}