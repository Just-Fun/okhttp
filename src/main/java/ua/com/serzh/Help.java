package ua.com.serzh;

/**
 * Created by Serzh on 11/18/16.
 */
public class Help {
    /*
    http://example.com/pages/page1.html
    http://example.com/pages/page2.html
    You can create URL objects for these pages relative to their common base URL: http://example.com/pages/ like this:

    URL myURL = new URL("http://example.com/pages/");
    URL page1URL = new URL(myURL, "page1.html");
    URL page2URL = new URL(myURL, "page2.html");
    This code snippet uses the URL constructor that lets you create a URL object from another URL object (the base)
    and a relative URL specification. The general form of this constructor is:

    URL(URL baseURL, String relativeURL)*/

    /*
    The first argument is the protocol, the second is the host name, and the last is the pathname of the file.
    Note that the filename contains a forward slash at the beginning.
    This indicates that the filename is specified from the root of the host.
    new URL("http", "example.com", "/pages/page1.html");
    This is equivalent to
    new URL("http://example.com/pages/page1.html");*/

    /*The final URL constructor adds the port number to the list of arguments used in the previous constructor:

    URL gamelan = new URL("http", "example.com", 80, "pages/page1.html");
    This creates a URL object for the following URL:

    http://example.com:80/pages/page1.html*/

    /*RL addresses with Special characters

    Some URL addresses contain special characters, for example the space character. Like this:

    http://example.com/hello world/
    To make these characters legal they need to be encoded before passing them to the URL constructor.

    URL url = new URL("http://example.com/hello%20world");
    Encoding the special character(s) in this example is easy as there is only one character that needs encoding, but for URL addresses that have several of these characters or if you are unsure when writing your code what URL addresses you will need to access, you can use the multi-argument constructors of the java.net.URI class to automatically take care of the encoding for you.

    URI uri = new URI("http", "example.com", "/hello world/", "");
    And then convert the URI to a URL.

    URL url = uri.toURL();*/
    }
