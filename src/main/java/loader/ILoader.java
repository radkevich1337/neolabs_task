package loader;

import java.io.IOException;

public interface ILoader {
    String[] load(final String path) throws IOException;
}
