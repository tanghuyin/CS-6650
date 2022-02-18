import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.FileReader;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huyin
 */
public class GenerateReport {

  public static void main(String[] args) {
    String filename = "result32.csv";
    // generate report
    try {
      FileReader reader = new FileReader(filename);
      CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
      List<String[]> data = csvReader.readAll();
      List<String[]> sorted = data.stream().sorted(Comparator.comparing(a -> Integer.parseInt(a[0]))).collect(
          Collectors.toList());
      long sum = sorted.stream().mapToLong(a -> Integer.parseInt(a[0])).sum();
      System.out.println("Mean Response Time: " + (double)sum / sorted.size());
      System.out.println("Min Response Time: " + sorted.get(0)[0]);
      System.out.println("Max Response Time: " + sorted.get(sorted.size()-1)[0]);
      System.out.println("p99 Response Time: " + percentile(sorted, 99));
      if (sorted.size() % 2 == 0) {
        System.out.println("Mean Response Time: " + (Integer.parseInt(sorted.get(sorted.size() / 2)[0]) + Integer.parseInt(sorted.get(sorted.size() / 2 + 1)[0])) / 2.0);
      } else {
        System.out.println("Median Response Time: " + sorted.get(sorted.size() / 2)[0]);
      }


    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static int percentile(List<String[]> latencies, double percentile) {
    int index = (int) Math.ceil(percentile / 100.0 * latencies.size());
    return Integer.parseInt(latencies.get(index-1)[0]);
  }
}
