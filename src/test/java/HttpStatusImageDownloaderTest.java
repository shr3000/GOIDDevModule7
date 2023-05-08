import downloader.HttpStatusImageDownloader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class HttpStatusImageDownloaderTest {
    @Test
    void downloadStatusImage() throws Exception {
        new HttpStatusImageDownloader().downloadStatusImage(200);
    }

    @Test
    void downloadStatusImageException() {
        Assertions.assertThrows(RuntimeException.class, ()->new HttpStatusImageDownloader().downloadStatusImage(1000));
    }
}