import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;

public class CopyFile {
    public void copy(File sourceF, File targetF) {

        File[] target_file = sourceF.listFiles();
        for (File file : target_file) {
            File temp = new File(targetF.getAbsolutePath() + File.separator + file.getName());
            try {

                System.out.println();

                if (file.isDirectory()) {
                    temp.mkdir();
                    copy(file, temp);
                } else {
                    FileInputStream fis = null;
                    FileOutputStream fos = null;
                    try {
                        if (temp.isFile()) {
                            FileTime lastModifiedTime = (FileTime) Files.getAttribute(Paths.get(file.getPath()),
                                    "lastModifiedTime");
                            FileTime lastModifiedTime1 = (FileTime) Files.getAttribute(Paths.get(temp.getPath()),
                                    "lastModifiedTime");
                            if (lastModifiedTime.toMillis() > lastModifiedTime1.toMillis()) {
                                fis = new FileInputStream(file);
                                fos = new FileOutputStream(temp);
                                byte[] b = new byte[4096];
                                int cnt = 0;
                                while ((cnt = fis.read(b)) != -1) {
                                    fos.write(b, 0, cnt);
                                }
                            }
                        } else {
                            fis = new FileInputStream(file);
                            fos = new FileOutputStream(temp);
                            byte[] b = new byte[4096];
                            int cnt = 0;
                            while ((cnt = fis.read(b)) != -1) {
                                fos.write(b, 0, cnt);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            fis.close();
                            fos.close();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            } catch (Exception e) {
                e.getStackTrace();
            }
        }

    }
}