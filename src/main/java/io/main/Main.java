package io.main;


import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class Main {
    public static void main(String[] args) {
        Document dom;
        try {
            dom = Jsoup.connect("http://example.com/").get();
            System.out.println(getHeaderInPlainTextFormat(dom));
            System.out.println(getContentOfArticleInPlainTextFormat(dom));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @NotNull
    private static String getHeaderInPlainTextFormat(Document html_dom){
        try {
            return html_dom.getElementsByTag("h1").first().text();
        }
        catch (NullPointerException e){
            return "(null)";
        }
    }

    @NotNull
    private static String getContentOfArticleInPlainTextFormat(Document html_dom){
        try {
            return html_dom.getElementsByTag("p").first().text();
        }
        catch (NullPointerException e){
            return "(null)";
        }
    }
}
