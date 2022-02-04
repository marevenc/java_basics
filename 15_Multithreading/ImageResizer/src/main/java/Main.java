import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    private  static int newWidth = 300;

    public static void main(String[] args) {
        String srcFolder = "/users/Mariya Kosheleva/Desktop/src";
        String dstFolder = "/users/Mariya Kosheleva/Desktop/dst";
        String dstFolderScalr = "/users/Mariya Kosheleva/Desktop/dstScalr";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        int step = files.length / 8;
        File[] files1 = new File[step];
        System.arraycopy(files, 0, files1, 0, step);
        ImageResizer resizer1 = new ImageResizer(files1, newWidth, dstFolder, start);
        resizer1.start();
        ResizerScalr resizerScalr1 = new ResizerScalr(files1, newWidth, dstFolderScalr, start);
        resizerScalr1.start();

        File[] files2 = new File[step];
        System.arraycopy(files, step, files2, 0, files2.length);
        ImageResizer resizer2 = new ImageResizer(files2, newWidth, dstFolder, start);
        resizer2.start();
        ResizerScalr resizerScalr2 = new ResizerScalr(files2, newWidth, dstFolderScalr, start);
        resizerScalr2.start();

        File[] files3 = new File[step];
        System.arraycopy(files, step * 2, files3, 0, files3.length);
        ImageResizer resizer3 = new ImageResizer(files3, newWidth, dstFolder, start);
        resizer3.start();
        ResizerScalr resizerScalr3 = new ResizerScalr(files3, newWidth, dstFolderScalr, start);
        resizerScalr3.start();

        File[] files4 = new File[step];
        System.arraycopy(files, step * 3, files4, 0, files4.length);
        ImageResizer resizer4 = new ImageResizer(files4, newWidth, dstFolder, start);
        resizer4.start();
        ResizerScalr resizerScalr4 = new ResizerScalr(files4, newWidth, dstFolderScalr, start);
        resizerScalr4.start();

        File[] files5 = new File[step];
        System.arraycopy(files, step * 4, files5, 0, files5.length);
        ImageResizer resizer5 = new ImageResizer(files5, newWidth, dstFolder, start);
        resizer5.start();
        ResizerScalr resizerScalr5 = new ResizerScalr(files5, newWidth, dstFolderScalr, start);
        resizerScalr5.start();

        File[] files6 = new File[step];
        System.arraycopy(files, step * 5, files6, 0, files6.length);
        ImageResizer resizer6 = new ImageResizer(files6, newWidth, dstFolder, start);
        resizer6.start();
        ResizerScalr resizerScalr6 = new ResizerScalr(files6, newWidth, dstFolderScalr, start);
        resizerScalr6.start();

        File[] files7 = new File[step];
        System.arraycopy(files, step * 6, files7, 0, files7.length);
        ImageResizer resizer7 = new ImageResizer(files7, newWidth, dstFolder, start);
        resizer7.start();
        ResizerScalr resizerScalr7 = new ResizerScalr(files7, newWidth, dstFolderScalr, start);
        resizerScalr7.start();

        File[] files8 = new File[files.length - step * 7];
        System.arraycopy(files, step * 7, files8, 0, files8.length);
        ImageResizer resizer8 = new ImageResizer(files8, newWidth, dstFolder, start);
        resizer8.start();
        ResizerScalr resizerScalr8 = new ResizerScalr(files8, newWidth, dstFolderScalr, start);
        resizerScalr8.start();
    }
}
