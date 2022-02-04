import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.*;

public class ParseHTML {

    public static final String DEFAULT_URL = "https://lenta.ru/";
    public static final List<String> STOP_WORDS = Arrays.asList("instagram", ".pdf", "twitter", "facebook", "utm", "vkontakte");

    public static Set<String> parse(String pageUrl) throws InterruptedException {
        Thread.sleep(150);
        Set<String> urls = new HashSet<>();
        try {
            try {
                Document doc = Jsoup.connect(pageUrl).ignoreContentType(true).timeout(5000).get();
                for (Element element : doc.select("a")) {
                    String url = element.attr("href");
                    if (url.startsWith("/")) {
                        url = DEFAULT_URL + url.substring(1);
                        if (STOP_WORDS.stream().noneMatch(url::contains)) {
                            synchronized (Main.siteMapSet) {
                                if (!Main.siteMapSet.contains(url)) {
                                    urls.add(url);
                                    Main.siteMapSet.add(url);
                                }
                            }
                        }
                    } else if (url.startsWith("http") && url.contains("lenta.ru")) {
                        if (STOP_WORDS.stream().noneMatch(url::contains)) {
                            synchronized (Main.siteMapSet) {
                                if (!Main.siteMapSet.contains(url)) {
                                    urls.add(url);
                                    Main.siteMapSet.add(url);
                                }
                            }
                        }
                    }
                }
            } catch (HttpStatusException e) {
                return Collections.EMPTY_SET;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return urls;
    }
}
