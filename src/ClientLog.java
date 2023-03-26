import org.json.simple.JSONObject;

import java.io.File;
import java.io.Serializable;

public class ClientLog implements Serializable {
        private static final long serialVersionUID = 1L;
        JSONObject obj = new JSONObject();

        public ClientLog(int productNumber, int productCount) {
            obj.put(productNumber, productCount);
            System.out.println(obj.toJSONString());
        }

        public void log(int productNumber, int productCount) {
            this.obj.put(Integer.toString(productNumber), Integer.toString(productCount));
        }

        public void exportAsCSV(File txtFile) {
        }
    }

