import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    private static final String siteURL = "https://www.moscowmap.ru/metro.html#lines";

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect(siteURL).maxBodySize(0).get();
            Elements elements = doc.select("[data-line]:first-child");

            for(Element element : elements){
                System.out.println(element.text());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
