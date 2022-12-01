package io.main;

import io.web.WebParser;
import io.web.WooordHuntEnToRu;
import org.jsoup.nodes.Document;

public final class Main {
    public static void main(String[] args) {
        Document dom;
        WebParser web_parser = new WooordHuntEnToRu();
        try {
//            dom = Jsoup.connect("http://example.com/").get();
            web_parser.parse(args[0]);
            web_parser.getResult();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
