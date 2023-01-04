import java.io.File;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    // pushData에 기록하기 위한 리스트
    List<String> addPush;
    List<String> changePush;
    List<String> delPush;

    protected boolean running = true;

    public void setRunning(boolean running) {
        this.running = running;
    }

    public FileState(String clientPath, JList jlist) {
        this.clientPath = clientPath;
        this.jlist = jlist;
    }

    @Override
    public void run() {

        while (true) {
            try {

                if (running) {
                    addPush = new ArrayList<String>();
                    changePush = new ArrayList<String>();
                    delPush = new ArrayList<String>();
                    jlist.setListData(check());// check()에서 가져온 배열로 리스트의 데이터를 바꿔준다.

                }
                Thread.sleep(500);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                System.out.println("약간의 오류");
            }
        }
    }

    public String[] check() {

        String resultStr[] = null;

        File sorceF = new File(clientPath + "/project");
        File targetF = new File(clientPath + "/.ggit/.repo/file/data");

        if (sorceF.listFiles() != null) {

            ArrayList addChList = addChCheck(sorceF, targetF);// add와 change 확인

            ArrayList delList = delCheck(targetF, sorceF);// delete 확인
            addChList.addAll(delList);

            resultStr = (String[]) addChList.toArray(new String[addChList.size()]);// add와 change 확인과 delete 확인 결과를
                                                                                   // 합쳐준다.

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
                    list.add(add + file.getName() + "     " + file.getPath());
                    addPush.add(file.getPath().replace(clientPath + "\\project\\", "/").replaceAll("\\\\",
                            "/"));
                } else if (file.isFile()) {
                    try {
                        FileTime sorcFileTime = (FileTime) Files.getAttribute(Paths.get(file.getPath()),
                                "lastModifiedTime");
                        FileTime tarFileTime = (FileTime) Files.getAttribute(Paths.get(temp.getPath()),
                                "lastModifiedTime");
                        if ((int) (sorcFileTime.toMillis() / 1000) - 1 > (int) (tarFileTime.toMillis() / 1000)) {
                            list.add(change + file.getName() + "     " + file.getPath());
                            changePush.add(file.getPath().replace(clientPath + "\\project\\", "/").replaceAll("\\\\",
                                    "/"));
                        }
                    } catch (Exception e) {
                        System.out.println("느낌적인 오류");
                    }

                }

            }
        }

        return list;

    }

    public void deldirectory(File file, ArrayList list, File targetF) {
        for (File sorce : file.listFiles()) {
            File temp = new File(targetF.getAbsolutePath() + File.separator + sorce.getName());
            if (sorce.isDirectory()) {
                deldirectory(sorce, list, temp);
            }

            list.add(delete + sorce.getName() + "     " + temp.getPath());
            delPush.add(
                    temp.getPath().replace(clientPath + "\\project\\", "/")
                            .replaceAll("\\\\",
                                    "/"));
        }
    }

    public ArrayList<String> delCheck(File sorceF, File targetF) {// 삭제는 sorcef가 data 폴더 targetf는 project폴더
        // 삭제 되었기에 project폴더에는 없다 그래서 data폴더를 기준으로 포문을 돌려준다
        ArrayList<String> list = new ArrayList<String>();
        if (targetF.listFiles() != null) {
            for (File file : sorceF.listFiles()) {
                File temp = new File(targetF.getAbsolutePath() + File.separator + file.getName());

                if (file.isDirectory()) {
                    list.addAll(delCheck(file, temp));// 폴더있경우 폴더 안으로 타고 들어가서 확인

                }

                if (!temp.isDirectory() && !temp.isFile()) {// 삭제기록
                    list.add(delete + temp.getName() + "     " + temp.getPath());
                    delPush.add(temp.getPath().replace(clientPath + "\\project\\", "/").replaceAll("\\\\",
                            "/"));
                    if (file.isDirectory()) {// 폴더 자체가 삭제되었을때 안에 있는 파일들도 삭제로 기록

                        deldirectory(file, list, temp);
                    }

                }

            }
        }

        return list;

    }

    public List<String> getAddPush() {
        return addPush;
    }

    public List<String> getChangePush() {
        return changePush;
    }

    public List<String> getDelPush() {
        return delPush;
    }

}
