import java.io.File;

public class AllDelete {
    String path;

    public AllDelete(String path) {

        delete(path);

    }

    public void delete(String path) {
        File folder2 = new File(path);
        try {
            if (folder2.exists()) {
                File[] folder_list2 = folder2.listFiles(); // 파일리스트 얻어오기

                for (int i = 0; i < folder_list2.length; i++) {
                    if (folder_list2[i].isFile()) {

                        folder_list2[i].delete();

                    } else {

                        delete(folder_list2[i].getPath()); // 재귀함수호출

                    }
                    folder_list2[i].delete();
                }
                folder2.delete();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

}
