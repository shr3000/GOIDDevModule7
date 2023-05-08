package checker;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {

    public String getStatusImage(int code) {
        String url = "https://http.cat/" + code + ".jpg";
        HttpURLConnection connection = null;

        try {
            connection = (HttpURLConnection) new URL(url).openConnection();
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_NOT_FOUND) {
                throw new RuntimeException("Image not found");
            }
            return url;

        } catch (IOException e) {
            throw new RuntimeException("Error connecting to server");
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
