import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static final String SITE_URL = "https://www.moscowmap.ru/metro.html#lines";

    public static void main(String[] args) {
        Document doc = null;
        try {
            doc = readHTML(SITE_URL);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Line> lines = parseLine(doc);
        writeJson(lines);
    }

    public static Document readHTML(String SITE_URL) throws IOException {
        Document doc = Jsoup.connect(SITE_URL).maxBodySize(0).get();
        return doc;
    }

    public static ArrayList<Line> parseLine(Document doc){
        Elements linesElements = doc.select("[data-line]:first-child");
        ArrayList<Line> lines = new ArrayList<>();

        for(Element element : linesElements){
            Line line = new Line(element.attr("data-line"), element.text());
            line.addStations(parseStation(doc, line));
            lines.add(line);
        }
        return lines;
    }

    public static String[] parseStation(Document doc, Line line){
        Elements stationsElements = doc.select("[data-depend-set~=lines-" + line.getNumber() + "]");
        return parseStationName(stationsElements);
    }


    public static String[] parseStationName(Elements element){
        String[] stations = element.text().split("\\.");

        for(int i = 0; i < stations.length; i++){
            String tmp = stations[i].replaceAll("( \\d{1,})", "").trim();
            stations[i] = tmp;
        }
        return Arrays.copyOfRange(stations, 1, stations.length);
    }

    public static void writeJson(ArrayList<Line> lines){
        File jsonFile = new File("src\\main\\resources\\map.json");
        JSONObject metroMap = new JSONObject();
        metroMap.put("lines", linesToJsonObj(lines));
        metroMap.put("stations", stationsToJsonObj(lines));


        try(FileWriter writer = new FileWriter(jsonFile, false)){
            writer.write(metroMap.toJSONString());
            writer.flush();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static JSONArray linesToJsonObj(ArrayList<Line> lines){
        JSONArray allLinesJson = new JSONArray();
        for(Line line : lines){
            JSONObject lineJson = new JSONObject();
            lineJson.put("number", line.getNumber());
            lineJson.put("name", line.getName());
            allLinesJson.add(lineJson);
        }
        return allLinesJson;
    }

    public static JSONObject stationsToJsonObj(ArrayList<Line> lines){
        JSONObject stationJson = new JSONObject();
        for(Line line : lines){
            stationJson.put(line.getNumber(), Arrays.toString(line.getStations()));
        }
        return stationJson;
    }
}