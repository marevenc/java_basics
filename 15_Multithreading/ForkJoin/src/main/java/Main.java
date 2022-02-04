
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;
import java.util.concurrent.ForkJoinPool;

public class Main {
    static TreeSet<String> siteMapSet = new TreeSet<>();

    public static void main(String[] args) throws InterruptedException, IOException {
        File f = new File("C:\\Users\\Mariya Kosheleva\\Desktop\\links_list.txt");
        f.createNewFile();
        FileWriter fw = new FileWriter(f);

        new ForkJoinPool().invoke(new RecursiveWebLinkParser(ParseHTML.parse(ParseHTML.DEFAULT_URL)));
        for (String url : siteMapSet) {
            System.out.println(url);
            fw.write(url + "\n");
        }
    }
}
