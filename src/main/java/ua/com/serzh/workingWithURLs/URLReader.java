package ua.com.serzh.workingWithURLs;

import java.net.*;
import java.io.*;

/**
 * Created by Serzh on 11/18/16.
 */
public class URLReader {
    public static void main(String[] args) throws Exception {
//        urlReader("http://example.com/");
//         URL aURL = new URL("http://example.com:80/docs/books/tutorial"
//        + "/index.html?name=networking#DOWNLOADING");

        String url = "http://google.com.ua/" + "index.html?class=gb1";
        ulrConnectionReader(url);
    }

    private static void urlReader(String url) throws IOException {
        /*You are not always required to explicitly call the connect method to initiate the connection.
        * Operations that depend on being connected, like getInputStream, getOutputStream, etc,
        * will implicitly perform the connection, if necessary.*/
        URL myUrl = new URL(url);
        BufferedReader in = new BufferedReader(new InputStreamReader(myUrl.openStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();
    }

    /*
        The output from this program is identical to the output from the program that opens a stream directly from the URL.
        You can use either way to read from a URL.
        However, reading from a URLConnection instead of reading directly from a URL might be more useful.
        This is because you can use the URLConnection object for other tasks (like writing to the URL) at the same time.

        Again, if the program hangs or you see an error message,
        you may have to set the proxy host so that the program can find the Oracle server.*/

//    !!!!!!!!!!!!!!!!!!!!
    private static void ulrConnectionReader(String url) throws IOException {
        URL google = new URL(url);
        URLConnection uc = google.openConnection();

        BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();
    }
}
