import java.util.*;
import java.util.concurrent.RecursiveTask;

public class RecursiveWebLinkParser extends RecursiveTask<Set<String>> {
    private Set<String> urlsMap;

    public RecursiveWebLinkParser(Set<String> urlsMap) {
        this.urlsMap = urlsMap;
    }

    @Override
    protected Set<String> compute() {
        List<RecursiveWebLinkParser> taskList = new ArrayList<>();
        Set<String> urls = new TreeSet<>();
        try {
            for (String recursiveLink : urlsMap) {
                RecursiveWebLinkParser task = new RecursiveWebLinkParser(ParseHTML.parse(recursiveLink));
                task.fork();
                taskList.add(task);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return urls;
    }
}
