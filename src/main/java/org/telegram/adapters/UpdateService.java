package org.telegram.adapters;

import java.io.IOException;
import java.util.List;

public interface UpdateService {
    List<org.telegram.entities.Update> getUpdates() throws IOException;

    void processUpdate(org.telegram.entities.Update update) throws IOException;
}
