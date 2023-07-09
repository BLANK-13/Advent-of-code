import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class AOC_5_part2 {
    public static void main(String[] args) throws IOException {
        Path fileName = Paths.get("C:\\Users\\Saud\\IdeaProjects\\practice\\src\\day5.txt");
        String content = Files.readString(fileName);

        String[] splitted = content.split("\n\n");
        String[] crates = splitted[0].split("\\n");
        String[] instructions = splitted[1].split("\n");

        ArrayList<Stack<String>> crateStacks = initStacks(crates[0]);

        stacksParsing(crateStacks, crates);
        stacksInstructions(crateStacks, instructions);
        printPeeks(crateStacks);
    }

    @NotNull
    public static ArrayList<Stack<String>> initStacks(String firstRow) {
        int count = (firstRow.length() + 1) / 4;
        ArrayList<Stack<String>> stacks = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            stacks.add(new Stack<>());
        }
        return stacks;
    }

    public static void stacksParsing(ArrayList<Stack<String>> crateStacks, String[] crates) {
        int stackCounter = 0;

        for (String s : crates) {
            s = separateCrates(s);
            for (int i = 1; i < s.length(); i += 4) {

                String s1 = String.valueOf(s.charAt(i - 1));
                if (s1.equals(",")) {
                    stackCounter++;
                    continue;
                }
                crateStacks.get(stackCounter).push(String.valueOf(s.charAt(i)));
                stackCounter++;
            }
            stackCounter = 0;
        }
        for (Stack<String> s : crateStacks) {
            Collections.reverse(s);
        }
    }

    public static void stacksInstructions(ArrayList<Stack<String>> crateStacks, String[] instructions) {
        for (String inst : instructions) {

            String[] instNums = inst.split(" ");
            int amount = Integer.parseInt(instNums[1]);
            int from = Integer.parseInt(instNums[3]);
            int to = Integer.parseInt(instNums[5]);
            Stack<String> temp = new Stack<>();

            for (int i = 0; i < amount; i++) {
                temp.push(crateStacks.get(from - 1).pop());
            }
            Collections.reverse(temp);
            for (String s : temp) {
                crateStacks.get(to - 1).push(s);

            }
            temp.clear();
        }
    }

    public static String separateCrates(String rowOfCrates) {
        rowOfCrates = rowOfCrates.replace(' ', ',');

        return rowOfCrates;
    }

    public static void printPeeks(ArrayList<Stack<String>> crateStacks) {
        for (Stack<String> s : crateStacks) {
            System.out.print("[" + s.peek() + "] ");
        }
    }
}
