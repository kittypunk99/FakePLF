import java.nio.file.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class FussballDingsi {
    public static Map<Integer, Integer> createGoalStatistic(Path file) {
        Map<Integer, Integer> stats = new TreeMap<>();
        Pattern p = Pattern.compile("\\s+(\\d+):(\\d+)\\s+\\(");

        try (BufferedReader br = Files.newBufferedReader(file)) {
            String line;
            boolean isMatchLine = true;

            while ((line = br.readLine()) != null) {
                isMatchLine = !isMatchLine; // Toggle: skip Spieltag, process next
                if (!isMatchLine) continue;

                Matcher m = p.matcher(line);
                while (m.find()) {
                    int g1 = Integer.parseInt(m.group(1));
                    int g2 = Integer.parseInt(m.group(2));
                    int sum = g1 + g2;
                    stats.put(sum, stats.getOrDefault(sum, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stats;
    }

    public static void main(String[] args) {
        Path path = Paths.get("Meisterschaft2.txt");
        Map<Integer, Integer> stats = createGoalStatistic(path);
        stats.forEach((goals, count) -> System.out.println(goals + ": " + count));
    }
}