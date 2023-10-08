package p02_10_2023;

import java.io.IOException;
import java.net.*;

public class UrlHelpers {

    public static int getHTTPResponseStatusCode(String urlStr) throws IOException {

        URL url = new URL(urlStr);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        return http.getResponseCode();
    }

    public static int getHTTPResponseStatusCodeCookieHandler(String urlStr) throws IOException {
        CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
        URL url = new URL(urlStr);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        return http.getResponseCode();
    }
}
