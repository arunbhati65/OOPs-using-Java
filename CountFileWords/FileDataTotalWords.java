import java.io.IOException;
        import java.nio.file.Files;
        import java.nio.file.Paths;
        import java.util.stream.Stream;


// Read file data and calculate total words present in the file 
public class FileDataTotalWords {

    public static void main(String[] args) { 
        String fileName = "C://Users//arunb//Java Mini Projects//CountFileWords//TextFile.txt";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            System.out.println(stream.flatMap(x -> x.chars().mapToObj(c -> (char) c)).count());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}