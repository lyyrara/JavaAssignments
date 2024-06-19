import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.io.FileWriter;

public class Enroll {

    public static void main(String[] args) {
        String inputFilePath = "Assignment8/resources/data.csv";
        
        Map<String, Set<Record>> enrolleesByCompany = readCsv(inputFilePath);

        
        for (String companyName : enrolleesByCompany.keySet()) {
            String outputFilePath = "Assignment8/resources/" + companyName + ".csv";
            writeCsv(enrolleesByCompany.get(companyName), outputFilePath);
        }
    }

    public static HashMap<String, Set<Record>> readCsv(String filePath) {
        
        HashMap<String, Set<Record>> enrolleesByCompany = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length != 5) {
                    // Log or report invalid CSV line
                    System.err.println("Invalid CSV line: " + line);
                    continue; // Skip to next line
                }
                String userId = values[0];
                String firstName = values[1];
                String lastName = values[2];
                int version = Integer.parseInt(values[3]);
                String insuranceCompany = values[4];
                enrolleesByCompany.putIfAbsent(insuranceCompany, new HashSet<>());
                Set<Record> records = enrolleesByCompany.get(insuranceCompany);
                Record new_record = new Record(userId, firstName, lastName, version, insuranceCompany);
                for(Record record: records){
                    if(new_record.equals(record)){
                        if(new_record.getVersion() > record.getVersion()){
                            records.remove(record);
                            break;
                        }
                    }
                }
                records.add(new_record);
                
            }
            
        } catch (IOException e) {
            // Log or report file IO error
            e.printStackTrace();
        }

        return enrolleesByCompany;
    }

    public static void writeCsv(Set<Record> records, String outputFilePath) {
        try {
            // Create the output file if it doesn't exist
            if (!Files.exists(Paths.get(outputFilePath))) {
                Files.createFile(Paths.get(outputFilePath));
            }

            // Open the BufferedWriter with FileWriter in append mode
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath, true))) {
                for (Record record : records) {
                    writer.write("user id,First Name,last Name,Version,Insurance Company\n");
                    String csvRecord = String.format("%s,%s,%s,%d,%s",
                            record.getUserId(), record.getFirstName(), record.getLastName(),
                            record.getVersion(), record.getInsuranceCompany());
                    writer.write(csvRecord);
                    writer.newLine(); // Add newline after each record
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
