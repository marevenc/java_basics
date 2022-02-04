import java.io.*;

public class Main {
    private static final String SITE_URL = "https://lenta.ru/";

    public static void main(String[] args) {
        try {
            ImageParser.saveImagesFromSite(SITE_URL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
