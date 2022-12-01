package io.web;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;

public final class WooordHuntEnToRu implements WebParser{
    private final String base_url = "https://wooordhunt.ru/word/";
    private ArrayList<String> meanings;

    public WooordHuntEnToRu(){
        meanings = new ArrayList<String>();
    }

    public void getResult(){
        for (var element : meanings){
            System.out.println(element);
        }
    }

    @Override
    public void parse(String url) {
        tryParse(url);
    }

    private void tryParse(String url){
        Document dom;
        try {
            dom = Jsoup.connect(url).get();
            this.meanings = getRussianMeanings(dom);
        }
        catch (Exception e){

        }
    }

    private ArrayList<String> getRussianMeanings(Document html_dom){
        ArrayList<String> meanings = new ArrayList<>();
        Element cutting_element = html_dom.getElementById("content_in_russian")
                .getElementsByClass("tr").first();
        for ( var element : cutting_element.html().split("<br>")){
            element = element
                    .replaceAll("<i>", "")
                    .replaceAll("</i>", "");
            meanings.add(element);
        }
        return meanings;
    }
}
