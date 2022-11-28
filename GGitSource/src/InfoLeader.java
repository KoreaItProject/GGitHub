import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class InfoLeader {
      String content = "";

      public InfoLeader(String path) {

            BufferedReader reader;

            // try {
            // reader = new BufferedReader(
            // new InputStreamReader(new FileInputStream(
            // path), "UTF-8"));
            // int c = 0;

            // while ((c = reader.read()) != -1) {
            // content += c + "\n";
            // }
            // System.out.println(content);

            // } catch (Exception e) {
            // // TODO Auto-generated catch block
            // e.printStackTrace();
            // }
            try {
                  reader = new BufferedReader(
                              new InputStreamReader(new FileInputStream(
                                          path), "UTF-8"));
                  String str;
                  int i = 0;
                  int line = 0;
                  while ((str = reader.readLine()) != null) {
                        line++;
                  }
                  reader = new BufferedReader(
                              new InputStreamReader(new FileInputStream(
                                          path), "UTF-8"));
                  while ((str = reader.readLine()) != null) {
                        System.out.println(str);

                        content += (char) (Integer.parseInt(str) - ((i++) * 100 + 11) * line);
                  }
                  reader.close();
            } catch (Exception e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
            }

            System.out.println(content);
            JSONParser jsonParser = new JSONParser();
            Object obj;
            try {
                  obj = jsonParser.parse("{" + content + "}");
                  JSONObject jsonObj = (JSONObject) obj;
                  // print
                  System.out.println("member = " + jsonObj.get("member"));
                  System.out.println("repo = " + jsonObj.get("repo"));
                  System.out.println("memberIdx = " + jsonObj.get("memberIdx"));

            } catch (ParseException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
            }

      }

}
