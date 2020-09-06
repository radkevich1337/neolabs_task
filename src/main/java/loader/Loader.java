package loader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Loader implements ILoader {

    /**
     * Метод считывает данные из файла и представляет их в виде массива строк
     * @param path - путь к файлу
     * @return данные из файла в виде массива строк
     */
    @Override
    public String[] load(final String path) {
        final File file = new File(path);
        final List<String> data = new ArrayList<>();
        String string;

        try {
            final BufferedReader reader = new BufferedReader( new FileReader (file));
            while ((string = reader.readLine()) != null){
                data.add(string);
            }
            reader.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }

        return data.toArray(new String[0]);
    }
}
