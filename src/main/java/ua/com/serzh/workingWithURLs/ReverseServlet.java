package ua.com.serzh.workingWithURLs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.net.*;

/**
 * Created by Serzh on 11/18/16.
 */
@Controller
public class ReverseServlet extends HttpServlet {

    private static String message = "Error during Servlet processing";

    @RequestMapping({"/try", "/index.html"})
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            int len = req.getContentLength();
            byte[] input = new byte[len];

            ServletInputStream inputStream = req.getInputStream();
            int c, count = 0;
            while ((c = inputStream.read(input, count, input.length - count)) != -1) {
                count += c;
            }
            inputStream.close();

            String inString = new String(input);
            int index = inString.indexOf("=");
            if (index == -1) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().print(message);
                resp.getWriter().close();
                return;
            }
            String value = inString.substring(index + 1);

            //decode application/x-www-form-urlencoded string
            String decodedString = URLDecoder.decode(value, "UTF-8");

            //reverse the String
            String reverseStr = (new StringBuffer(decodedString)).reverse().toString();

            // set the response code and write the response data
            resp.setStatus(HttpServletResponse.SC_OK);
            OutputStreamWriter writer = new OutputStreamWriter(resp.getOutputStream());

            writer.write(reverseStr);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            try {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().print(e.getMessage());
                resp.getWriter().close();
            } catch (IOException ioe) {
            }
        }
    }
}
