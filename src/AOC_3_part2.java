import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Arrays;
public class AOC_3_part2 {
    public static void main(String[] args) throws IOException {
        Path fileName = Paths.get("C:\\Users\\Saud\\IdeaProjects\\practice\\src\\rucksacks.txt");
        String content = Files.readString(fileName);

        String[] splitted = content.split("\n");
        int totalPriorities = 0;
        final int smallAdjust = 96, capitalAdjust = 38;
        String[] elvesGroup = new String[3];

        for (int i = 0; i < splitted.length; i += 3) {

            // added these for readability later on
            String firstElf = splitted[i];
            String secondElf = splitted[i + 1];
            String thirdElf = splitted[i + 2];

            elvesGroup[0] = firstElf;
            elvesGroup[1] = secondElf;
            elvesGroup[2] = thirdElf;

            // we just need to go through the elf with the least baggage in the group
            Arrays.sort(elvesGroup, Comparator.comparing(String::length));


            for (int j = 0; j < elvesGroup[0].length(); j++) {


                int itemsMatcher1 = elvesGroup[1].indexOf(elvesGroup[0].charAt(j)), itemsMatcher2 = elvesGroup[2].indexOf(elvesGroup[0].charAt(j));

                if (itemsMatcher1 != -1 && itemsMatcher2 != -1) {

                    int itemASCII = elvesGroup[0].charAt(j);
                    totalPriorities += itemASCII >= 97 ? itemASCII - smallAdjust : itemASCII - capitalAdjust;
                    break;

                }
            }
        }
        System.out.println(totalPriorities);

    }
}
