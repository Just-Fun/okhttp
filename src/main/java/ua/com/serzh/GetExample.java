package ua.com.serzh;


import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Serzh on 11/18/16.
 */
public class GetExample {
    OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) throws IOException {
//        You can also add parameters
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.github.help").newBuilder();
        urlBuilder.addQueryParameter("v", "1.0");
        urlBuilder.addQueryParameter("user", "vogella");
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();


//        You can also add authentication headers

        Request request2 = new Request.Builder()
                .header("Authorization", "your token")
                .url("https://api.github.com/users/vogella")
                .build();
    }

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    /*public static void main(String[] args) throws IOException {
        GetExample example = new GetExample();
//        String response = example.run("https://raw.github.com/square/okhttp/master/README.md");
        String response = example.run("https://www.google.com.ua/");
        System.out.println(response);
    }*/
}