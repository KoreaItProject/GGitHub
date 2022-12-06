import java.io.File;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JList;

//추가됨,수정됨,삭제됨 검색 방식
//project 폴더를 sourceF로 잡고 .ggit안에 있는 data를 targetF로 한다
//sourceF를 기준으로 targetF를 for문 비교하면서 targetF에 없으면 추가,targetF보다 최신이면 수정으로 인식한다.addChCheck()
//targetF를 기준으로 sourceF를 for문 비교하면서 sourceF에 없으면 삭제로 인식한다. delCheck()
//검색한 두개의 배열을 병합하여 jlist 의 데이터를 최신화 한다.
//-이태현주석

public class FileState extends Thread {
    String clientPath;
    JList jlist;
    String add = "추가됨    ";
    String change = "수정됨    ";
    String delete = "삭제됨    ";

    public FileState(String clientPath, JList jlist) {
        this.clientPath = clientPath;
        this.jlist = jlist;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            try {
                Thread.sleep(700);
                jlist.setListData(check());// check()에서 가져온 배열로 리스트의 데이터를 바꿔준다.

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public String[] check() {

        String resultStr[] = null;

        File sorceF = new File(clientPath + "/project");
        File targetF = new File(clientPath + "/.ggit/.repo/file/data");

        ArrayList addChList = addChCheck(sorceF, targetF);// add와 change 확인
        String[] addChStr = (String[]) addChList.toArray(new String[addChList.size()]);

        ArrayList delList = delCheck(targetF, sorceF);// delete 확인
        String[] delStr = (String[]) delList.toArray(new String[delList.size()]);

        if (sorceF.listFiles() != null) {
            resultStr = new String[addChStr.length + delStr.length];// add와 change 확인과 delete 확인 결과를 합쳐준다.

            int index = 0;
            for (String str : addChStr) {
                resultStr[index++] = str;
            }
            for (String str : delStr) {
                resultStr[index++] = str;
            }
        } else {
            resultStr = new String[1];
            resultStr[0] = "프로젝트 파일이 존재하지 않습니다";
        }

        if (resultStr == null) {
            resultStr = new String[1];
            resultStr[0] = "변경사항이 없습니다";
        }

        return resultStr;

    }

    public ArrayList<String> addChCheck(File sorceF, File targetF) {
        ArrayList<String> list = new ArrayList<String>();
        if (sorceF.listFiles() != null) {
            for (File file : sorceF.listFiles()) {
                File temp = new File(targetF.getAbsolutePath() + File.separator + file.getName());

                if (file.isDirectory()) {
                    list.addAll(addChCheck(file, temp));
                }

                if (!temp.isDirectory() && !temp.isFile()) {
                    list.add(add + file.getName() + "     " + temp.getPath());
                } else if (file.isFile()) {
                    try {
                        FileTime sorcFileTime = (FileTime) Files.getAttribute(Paths.get(file.getPath()),
                                "lastModifiedTime");
                        FileTime tarFileTime = (FileTime) Files.getAttribute(Paths.get(temp.getPath()),
                                "lastModifiedTime");
                        if ((int) (sorcFileTime.toMillis() / 2000) > (int) (tarFileTime.toMillis() / 2000)) {
                            list.add(change + file.getName() + "     " + file.getPath());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

            }
        }

        return list;

    }

    public ArrayList<String> delCheck(File sorceF, File targetF) {
        ArrayList<String> list = new ArrayList<String>();
        if (targetF.listFiles() != null) {
            for (File file : sorceF.listFiles()) {
                File temp = new File(targetF.getAbsolutePath() + File.separator + file.getName());

                if (file.isDirectory()) {
                    list.addAll(delCheck(file, temp));
                }

                if (!temp.isDirectory() && !temp.isFile()) {
                    list.add(delete + file.getName() + "     " + temp.getPath());
                }

            }
        }

        return list;

    }

}
