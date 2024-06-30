import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

public class ReadWriteFileTest {

    @Test
    void shouldCheckIfFileExistTheOldWay() {
        String fileName = "inputFile.txt";
        File file = new File(fileName);
        assertThat(file.exists()).isFalse();
    }

    @Test
    void shouldCheckIfFileExistTheNewWay () {
        String fileName = "inputFile.txt";
        Path path = Path.of(fileName);
        assertThat(Files.exists(path)).isFalse();
    }

    @Test
    void shouldCreateAndDeleteFileTheOldWay () throws IOException {
        String fileName = "inputFile.txt";
        File file = new File(fileName);

        file.createNewFile();

        assertThat(file.exists()).isTrue();

        file.delete();

        assertThat(file.exists()).isFalse();
    }

    @Test
    void shouldCreateAndDeleteFileTheNewWay() throws IOException {
        String fileName = "inputFile.txt";
        Path path = Path.of(fileName);

        Files.createFile(path);

        assertThat(Files.exists(path)).isTrue();

        Files.delete(path);

        assertThat(Files.exists(path)).isFalse();
    }

    @Test
    void shouldWriteIntoFileTheOldWay() throws IOException {
        String fileName = "inputFile.txt";
        File file = new File(fileName);

        file.createNewFile();

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("""
                Hello 
                world""");
        fileWriter.close();

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        bufferedReader.readLine();


    }

    @Test
    void shouldWriteIntoFileTheNewWay () throws IOException {
        String fileName = "inputFile.txt";
        Path path = Path.of(fileName);

        Files.createFile(path);
        Files.writeString(path, """
                File input test""");

        String expectedContext = "File input test";
        assertThat(Files.readString(path)).isEqualTo(expectedContext);

        Files.delete(path);
        assertThat(Files.exists(path)).isFalse();
    }

    @Test
    void shouldReadFileLength() throws IOException {
        File file = new File("testFile.txt");

        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write("Hello world !".getBytes());
        }

        assertThat(file.length()).isEqualTo(13);

        assertThat(file.delete()).isTrue();
    }
}
