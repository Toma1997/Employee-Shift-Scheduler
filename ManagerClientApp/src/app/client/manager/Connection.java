package app.client.manager;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connection {

    // for getting reult from service via GET method
    public static String getOrDelete(String URLtoRead, String method) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(URLtoRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(method);
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while((line = br.readLine()) != null){
            result.append(line);
        }
        br.close();
        return result.toString();
    }

    // for sending data to sevice via POST and retrieving response
    public static String post(String URLtoRead, String payload) throws Exception {
        try(CloseableHttpClient client = HttpClientBuilder.create().build()){
            HttpPost request = new HttpPost(URLtoRead);
            request.setHeader("User-Agent", "Manager client");
            request.setHeader("Content-type", "application/json");
            request.setEntity(new StringEntity(payload));

            HttpResponse response = client.execute(request);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuilder stringBuilder = new StringBuilder();

            String line;
            while((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
            }

            return stringBuilder.toString();
        }
    }
}
