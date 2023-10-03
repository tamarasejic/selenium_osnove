package p02_10_2023;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlHelpers {

    public static int getHTTPResponseStatusCode(String urlStr) throws IOException {

        URL url = new URL(urlStr);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        return http.getResponseCode();
    }
}
