import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * @author huyin
 */
public class MyCSVWriter {

  public static void createOutputDir(String dirname) {
    File dir = new File(dirname);
    if (!dir.exists()) {
      dir.mkdir();
    }
  }

  public static void createEmptyCSV(String filename) {
    try {
      File file = new File(filename);
      if (!file.createNewFile()) {
         System.out.println("File already exists.");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void writeFiles(String fileName, BlockingQueue<List<RequestRecord>> queue)
      throws InterruptedException {
    List<RequestRecord> records = new ArrayList<>();
    while (!queue.isEmpty()) {
      records.addAll(queue.take());
    }
    Writer writer = null;
    try {
      writer = new FileWriter(fileName);
      StatefulBeanToCsv<RequestRecord> beanToCsv = new StatefulBeanToCsvBuilder<RequestRecord>(
          writer).build();
      beanToCsv.write(records);
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (CsvRequiredFieldEmptyException e) {
      e.printStackTrace();
    } catch (CsvDataTypeMismatchException e) {
      e.printStackTrace();
    }
  }
}
