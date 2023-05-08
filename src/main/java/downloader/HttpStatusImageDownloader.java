package downloader;

import checker.HttpStatusChecker;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusImageDownloader {

    private HttpStatusChecker checker;

    public HttpStatusImageDownloader() {
        this.checker = new HttpStatusChecker();
    }

    public void downloadStatusImage(int code) throws Exception {
        String url = checker.getStatusImage(code);
        HttpURLConnection connection = null;

        try {
            connection = (HttpURLConnection) new URL(url).openConnection();
            InputStream inputStream = connection.getInputStream();

            String filename = code + ".jpg";
            FileOutputStream outputStream = new FileOutputStream(filename);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            inputStream.close();
            outputStream.close();

        } catch (Exception e) {
            throw new RuntimeException("Error downloading image", e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

    }

}
