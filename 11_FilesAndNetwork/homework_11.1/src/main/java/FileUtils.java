import java.io.File;

public class FileUtils {

    public static long calculateFolderSize(String path) throws Exception {
        long totalLength = 0;
        File folder = new File(path);
        if(!folder.exists()){
            throw new Exception("Папка не существует");
        }
        File[] files = folder.listFiles();

        if (files != null){
            for (File file : files) {
                if (file.isFile()) {
                    totalLength += file.length();
                } else {
                    totalLength += calculateFolderSize(file.getAbsolutePath());
                }
            }
        }

        return totalLength;
    }
}
