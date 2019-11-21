package timeApi;

import java.io.IOException;

public interface TimeClient<E> {
    E getTime() throws IOException;
}