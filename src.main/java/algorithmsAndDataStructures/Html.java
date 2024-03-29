package algorithmsAndDataStructures;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static hackerrank.EnglishReplace.createPathFromFileName;


public class Html {
    public static void main(String[] args) throws IOException, URISyntaxException {
        String content = readWholeFile(Objects.requireNonNull(Html.class.getClassLoader().getResource("html-soutce.txt")).toURI());
        try (FileWriter writer = new FileWriter("D:\\IdeaProjects\\practice2\\src\\main\\resources\\englishToWrite.txt")) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readWholeFile(URI file) throws IOException {
        StringBuilder builder = new StringBuilder();
        Pattern pattern = Pattern.compile("<span class=\"\">.+?</span");
        Path filePath = createPathFromFileName(file);
        String content = Files.readString(filePath);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()){
            String str = matcher.group();
            builder.append(str.substring(str.indexOf(">")+1,str.lastIndexOf("<")).replaceAll("[-\\s]","_").toUpperCase())
                    .append(",").append("\n");
        }
        return String.valueOf(builder);
    }


    private static Stream<String> openFileLinesStream(Path filePath) {
        try {
            return Files.lines(filePath);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
