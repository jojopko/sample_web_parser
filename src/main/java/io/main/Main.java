package io.main;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {
        Document dom;
        try {
            FileOutputStream file_output = new FileOutputStream("/tmp/a.html");
            dom = Jsoup.connect("http://example.com/").get();
            System.out.printf(dom.html());
//            file_output.write(dom.html().getBytes(StandardCharsets.UTF_8));
            file_output.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
