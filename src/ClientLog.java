import com.opencsv.CSVWriter;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class ClientLog implements Serializable {
        private static final long serialVersionUID = 1L;
        JSONObject obj = new JSONObject();
        String[] log;

        public void log(int productNumber, int productCount) {
            obj.put(Integer.toString(productNumber), Integer.toString(productCount));
            System.out.println(obj);
        }

        public void exportAsCSV(String cart, int productCount) throws IOException {
            String str = cart + " " + Integer.toString(productCount);
            log = str.split(" ");
            CSVWriter csvWriter = new CSVWriter(new FileWriter("CSVLog.csv", true));
            csvWriter.writeNext(log);
            csvWriter.flush();
            csvWriter.close();
        }
    }

