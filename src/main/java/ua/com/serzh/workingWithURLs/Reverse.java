package ua.com.serzh.workingWithURLs;

import java.io.*;
import java.net.*;

/**
 * Created by Serzh on 11/18/16.
 */
public class Reverse {


   /* public static void main(String[] args) throws IOException {
         String url = "http://example.com/servlet/ReverseServlet";
         String text = "Reverse Me";

         String[] array = new String[]{url, text};
        revers(array);
    }*/

   /*
1. Create a URL.
2. Retrieve the URLConnection object.
3. Set output capability on the URLConnection.
4. Open a connection to the resource.
5. Get an output stream from the connection.
6. Write to the output stream.
7. Close the output stream.*/
    private static void revers(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage:  java Reverse "
                    + "http://<location of your servlet/script>"
                    + " string_to_reverse");
            System.exit(1);
        }

        String stringToReverse = URLEncoder.encode(args[1], "UTF-8");

        URL url = new URL(args[0]);
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);

        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
        out.write("string=" + stringToReverse);
        out.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String decodedString;
        while ((decodedString = in.readLine()) != null) {
            System.out.println(decodedString);
        }
        in.close();
    }
}