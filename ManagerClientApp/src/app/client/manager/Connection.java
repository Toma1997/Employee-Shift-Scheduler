package app.client.manager;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connection {

    public static String get(String URLtoRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(URLtoRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while((line = br.readLine()) != null){
            result.append(line);
        }
        br.close();
        return result.toString();
    }

    public static String post(String URLtoRead, String payload) throws Exception {
        try(CloseableHttpClient)
    }
}
