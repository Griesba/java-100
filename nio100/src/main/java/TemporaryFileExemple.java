import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class TemporaryFileExemple {


    public static void main(String [] args) {

        //findFile("Box");

        int count = args.length;
        while (count > 0) {
            System.out.println("villeret");
            count--;
        }
        /*
        try {
            final Path filePath = Files.createTempFile("myTempsFile", "txt");

            System.out.println("File name:"+filePath);
            filePath.toFile().deleteOnExit();

            String data = new Gson().toJson(new Contract("offerering", "1223"));
            InputStream inputStream = new ByteArrayInputStream(data.getBytes());
            File newFile = new File("src/main/resources/tempFil3.json");
            newFile.mkdirs();
            Files.copy(inputStream, newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            Contract contract = new Contract();

        }catch (Exception e) {

        }*/
    }

    public static boolean findFile(String fileName) {
        try (Stream<Path> walk = Files.walk(Paths.get("src/"))) {
            Optional<String> option = walk.map(x -> x.toString()).filter(x -> x.equals(fileName)).findFirst();
            if (option.isPresent()) {
                System.out.println(option.get());
                return true;
            }
        } catch (IOException e) {

        }
        return false;
    }

}
