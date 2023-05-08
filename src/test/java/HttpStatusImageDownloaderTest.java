import downloader.HttpStatusImageDownloader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class HttpStatusImageDownloaderTest {
    private static HttpStatusImageDownloader downloader;

    @BeforeAll
    public static void setUp() {
        downloader = new HttpStatusImageDownloader();
    }

    @Test
    public void testDownloadStatusImageSuccess() throws IOException {
        int code = 200;
        String expectedPath = System.getProperty("user.dir") + File.separator + code + ".jpg";
        downloader.downloadStatusImage(code);
        File file = new File(expectedPath);
        assertTrue(file.exists());
        assertTrue(file.isFile());
        file.delete();
    }

    @Test
    public void testDownloadStatusImageFailure() {
        int code = 10000;
        assertThrows(IOException.class, () -> downloader.downloadStatusImage(code));
    }
}
