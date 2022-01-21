package storage;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import duke.storage.Storage;
import duke.storage.Storage.StorageOperationException;

public class StorageTest {
    @TempDir
    public static Path testFolder;

    private static final String TEST_DATA_FOLDER = "src/test/data";

    @Test
    public void load_invalidFormat_exceptionThrown() throws Exception {
        // The file contains valid txt data, but does not match the task list format
        Storage storage = getStorage("InvalidDuke.txt");
        assertThrows(StorageOperationException.class, () -> storage.load() ,
                "StorageOperationException was expected");
    }

    private Storage getStorage(String fileName) throws Exception {
        return new Storage(TEST_DATA_FOLDER + "/" + fileName);
    }
}
