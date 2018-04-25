package DataProcessing;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

@Component
public class DataProcessing implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        if (args.length > 1) {
            String inputFileLocation = args[0].toString();
            String outputFileLocation = args[1].toString();
            //1. Read the data from the file and get a list of String from it.
            List<String> data = readFromInputFile(inputFileLocation);
			//2. Process the data in required order
			TreeMap<Long,TreeSet<String>> map1 = processReadData(data);
			//3. Write the data to the output file.
			writeFileToOutFile(map1, outputFileLocation);
        } else {
            System.out.println("Required inputs are not given.");
        }
    }

        private List<String> readFromInputFile(String inputFile) {
            List<String> list = new ArrayList<>();
            try (Stream<String> stream = Files.lines(Paths.get(inputFile), StandardCharsets.UTF_8)) {
                stream.forEach(s -> list.add(s));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return list;
        }

    public TreeMap<Long, TreeSet<String>> processReadData(List<String> orderList)
    {
        TreeMap<Long, TreeSet<String>> map = new TreeMap<>();
        int n = orderList.size();
        for(int i=1;i<n;i++) {
            String[] str = orderList.get(i).split("\\s+");
            if(str.length > 1) {
                if (map.containsKey(Long.parseLong(str[1]))) {
                    map.get(Long.parseLong(str[1])).add(str[0]);
                } else {
                    TreeSet<String> listOrders = new TreeSet<>();
                    listOrders.add(str[0]);
                    map.put(Long.parseLong(str[1]), listOrders);
                }
            }
        }
        return map;
    }

    public void writeFileToOutFile(TreeMap<Long, TreeSet<String>> map, String resPath) throws IOException {
        FileWriter writer = new FileWriter(resPath);
        String str = "Order      Time\n";
        writer.write(str);
        for(Long key : map.keySet())
        {
            Iterator orderIterator;
            orderIterator = map.get(key).iterator();
            while(orderIterator.hasNext())
            {
                StringBuilder sb = new StringBuilder();
                sb.append(orderIterator.next());
                sb.append("   ");
                sb.append(epochToDateFormatter(key));
                sb.append("\n");
                writer.write(sb.toString());
            }
        }
        writer.close();
    }

    private String epochToDateFormatter(Long epochTime)
    {
        Date date = new Date(epochTime);
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        String formattedDate = format.format(date);
        return formattedDate;
    }
}
