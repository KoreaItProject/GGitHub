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

            try {
                  reader = new BufferedReader(
                              new InputStreamReader(new FileInputStream(
                                          path), "UTF-8"));
                  String str;

                  while ((str = reader.readLine()) != null) {
                        content += str + "\n";

                  }
                  reader.close();
            } catch (IOException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
            }
            System.out.println(content);
            JSONParser jsonParser = new JSONParser();
            Object obj;
            try {
                  obj = jsonParser.parse(content);
                  JSONObject jsonObj = (JSONObject) obj;
                  // print
                  System.out.println(jsonObj.get("member")); // sim
                  System.out.println(jsonObj.get("repo")); // simpw
                  System.out.println(jsonObj.get("token")); // {"sex":"male","age":50}

            } catch (ParseException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
            }

            // 4. To JsonObject

      }

}
