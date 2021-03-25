package loader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DataFileLoader implements ILoader {

    /**
     * Метод считывает данные из файла и представляет их в виде массива строк
     * @param path - путь к файлу
     * @return данные из файла в виде массива строк
     */
    @Override
    public String[] load(final String path) throws IOException {
        final List<String> data = Files.readAllLines(Path.of(path));

        return data.toArray(new String[0]);
    }
}
