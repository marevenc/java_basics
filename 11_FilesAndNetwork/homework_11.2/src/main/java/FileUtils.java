import java.io.*;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) {
        File sourceFolder = new File(sourceDirectory);
        File destinationFolder = new File(destinationDirectory);

        if(sourceFolder.isDirectory()){
            if(!destinationFolder.exists()){
                destinationFolder.mkdir();
            }

            for(String file : sourceFolder.list()){
                File srcFile = new File(sourceFolder, file);
                File destFile = new File(destinationFolder, file);
                copyFolder(srcFile.getPath(), destFile.getPath());
            }
        } else {
            try{
                InputStream in = new FileInputStream(sourceFolder);
                OutputStream out = new FileOutputStream(destinationFolder);

                byte[] buffer = new byte[1024];

                int length;
                while ((length = in.read(buffer)) > 0){
                    out.write(buffer, 0, length);
                }

                in.close();
                out.close();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
