import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;

public class CopyFile {
    private FileInputStream fis = null;
    private FileOutputStream fos = null;

    public void copy(File sourceF, File targetF) {
        if (sourceF.isFile()) {
            while (true) {
                File mk = new File(targetF.getParent());

                mk.mkdirs();

                try {

                    fis = new FileInputStream(sourceF);
                    fos = new FileOutputStream(targetF);
                    byte[] b = new byte[409600];
                    int cnt = 0;
                    while ((cnt = fis.read(b)) != -1) {
                        fos.write(b, 0, cnt);
                    }

                } catch (Exception e) {
                    try {
                        mk.mkdirs();
                        Thread.sleep(100);
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    continue;
                }
                try {
                    fis.close();
                    fos.close();
                    break;
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        } else {
            new File(targetF.getAbsolutePath() + File.separator).mkdirs();
            File[] target_file = sourceF.listFiles();
            System.out.println(sourceF.getPath());
            if (target_file != null) {

                for (File file : target_file) {
                    File temp = new File(targetF.getAbsolutePath() + File.separator + file.getName());
                    try {

                        if (file.isDirectory()) {
                            temp.mkdirs();
                            copy(file, temp);
                        } else {

                            try {

                                fis = new FileInputStream(file);
                                fos = new FileOutputStream(temp);
                                byte[] b = new byte[409600];
                                int cnt = 0;
                                while ((cnt = fis.read(b)) != -1) {
                                    fos.write(b, 0, cnt);
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

    }
}