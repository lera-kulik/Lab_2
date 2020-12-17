import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        work(new DataAsker(System.in, System.out));
    }

    public static void work(DataAsker dataAsker) throws IOException {
        String separator = dataAsker.ask("Введите итоговый сепаратор:");
        String pathToOrigin = dataAsker.ask("Введите путь к файлу:");
        String pathToResult = dataAsker.ask("Введите путь создания:");
        String sep = dataAsker.ask("Введите сепаратор:");
        File origin = new File("src/main/resources/"+pathToOrigin);
        File result = new File("src/main/resources/"+pathToResult);
        Formatter formatter = new Formatter();
        String absolutePath = result.getAbsolutePath();
        Scanner scan= new Scanner(origin);
        List<String> lines= new ArrayList<>();
        while (scan.hasNext()) {
            lines.add(formatter.format(Parser.parseLine(scan.nextLine(), sep.charAt(0), '"'), separator));
        }
        StringBuilder formattedResult = new StringBuilder();
        lines.forEach(formattedResult::append);
        Files.write(Paths.get(absolutePath), Collections.singletonList(formattedResult), StandardCharsets.UTF_8);
        System.out.println(absolutePath);
    }
}
