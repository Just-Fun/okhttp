package ua.com.serzh;

import java.net.*;
import java.io.*;

/**
 * Created by Serzh on 11/18/16.
 */
public class URLConnectionReader {

    /*
    The output from this program is identical to the output from the program that opens a stream directly from the URL.
    You can use either way to read from a URL.
    However, reading from a URLConnection instead of reading directly from a URL might be more useful.
    This is because you can use the URLConnection object for other tasks (like writing to the URL) at the same time.

    Again, if the program hangs or you see an error message,
    you may have to set the proxy host so that the program can find the Oracle server.*/
    public static void main(String[] args) throws Exception {

        URL google = new URL("http://www.google.com.ua");

        URLConnection uc = google.openConnection();

        BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();
    }
}
