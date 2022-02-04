import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageParser {

    private static final String FOLDER_PATH = "src\\main\\resources\\images";

    public static void saveImagesFromSite(String SITE_URL) throws IOException {

        Path path = Paths.get(FOLDER_PATH);
        Files.createDirectories(path);

        Document doc = Jsoup.connect(SITE_URL).get();
        Elements img = doc.getElementsByTag("img");

        for(Element element : img){
            String src = element.attr("abs:src");
            getImage(src);
        }
    }

    public static void getImage(String src) throws IOException {
        int indexName = src.lastIndexOf("/");
        String name = src.substring(indexName);
        name = name.replaceAll("\\?", "_");

        System.out.println(name);

        URL url = new URL(src);
        InputStream in = url.openStream();

        OutputStream out = new BufferedOutputStream(new FileOutputStream( FOLDER_PATH + name));

        for (int b; (b = in.read()) != -1;) {
            out.write(b);
        }
        out.close();
        in.close();

    }
}
