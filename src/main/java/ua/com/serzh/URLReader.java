package ua.com.serzh;

import java.net.*;
import java.io.*;

/**
 * Created by Serzh on 11/18/16.
 */
public class URLReader {
    public static void main(String[] args) throws Exception {

        try {
            URL myURL = new URL("http://example.com/");
            URLConnection myURLConnection = myURL.openConnection();
            myURLConnection.connect();
        } catch (MalformedURLException e) {
            // new URL() failed
            // ...
        } catch (IOException e) {
            // openConnection() failed
            // ...
        }
        /*!!!!!!!!!
        * You are not always required to explicitly call the connect method to initiate the connection.
        * Operations that depend on being connected, like getInputStream, getOutputStream, etc,
        * will implicitly perform the connection, if necessary.*/

//        URL oracle = new URL("http://www.oracle.com/");
        URL google = new URL("http://www.google.com.ua");

        BufferedReader in = new BufferedReader(new InputStreamReader(google.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);

        }
        in.close();
    }
}
