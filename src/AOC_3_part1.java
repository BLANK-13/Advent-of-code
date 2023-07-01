import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class AOC_3_part1 {
    public static void main(String[] args) throws IOException {
        Path fileName = Paths.get( "C:\\Users\\Saud\\IdeaProjects\\practice\\src\\rucksacks.txt");
        String content = Files.readString(fileName);

        String[] splitted = content.split("\n");
        int totalPriorities = 0;
        final int smallAdjust = 96, capitalAdjust = 38;
        HashMap<Character, Integer> charsAsValues = new HashMap<>();

        for (String s : splitted){

            String sHalf1 = s.substring(0, (s.length()/2));
            String sHalf2 = s.substring((s.length()/2));

            for (int i = 0; i < sHalf1.length(); i++){

                int matcher = sHalf2.indexOf(sHalf1.charAt(i));
                if (matcher == -1 || charsAsValues.containsKey(sHalf2.charAt(matcher))) continue;

                char item = sHalf2.charAt(matcher);
                int  itemASCII = item; // utilizing char's ASCII to solve this and this var is meant for readability
                charsAsValues.put(item, itemASCII >=97? itemASCII - smallAdjust : itemASCII - capitalAdjust );


            }
            totalPriorities += charsAsValues.values().stream().reduce(0, Integer::sum);
            charsAsValues.clear();
        }


        System.out.println(totalPriorities);
    }
}
