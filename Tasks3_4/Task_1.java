package Tasks3_4;

import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;


public class Task_1 {
    public static void main(String[] args) {
        // The URL to the CSV file
        String fileUrl = "https://users.metropolia.fi/~jarkkov/temploki.csv";
        
        try {
            downloadAndProcessCSV(fileUrl);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    // Method to download and process the CSV file
    public static void downloadAndProcessCSV(String fileUrl) throws IOException, ParseException {
        // Open the URL and read the CSV content
        URL url = new URL(fileUrl);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

        String headerLine = reader.readLine(); // Read header line
        if (headerLine == null) {
            System.out.println("The file is empty.");
            return;
        }

        String[] header = headerLine.split(";");
        int ulkoTaloIndex = Arrays.asList(header).indexOf("UlkoTalo");
        int dateTimeIndex = Arrays.asList(header).indexOf("Aika");

        if (ulkoTaloIndex == -1 || dateTimeIndex == -1) {
            throw new IllegalArgumentException("CSV file is missing required columns");
        }

        List<Double> temperatures = new ArrayList<>();
        String line;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        // Read each line and process the data
        while ((line = reader.readLine()) != null) {
            String[] nextLine = line.split(";");

            String dateString = nextLine[dateTimeIndex];
            String tempString = nextLine[ulkoTaloIndex];
            // Double doesnt recognize the comma so we changed it to dot
            tempString = tempString.replace(",", ".");


            try {
                Date date = dateFormat.parse(dateString); // Parse the DateTime string
                double temperature = Double.parseDouble(tempString); // Get the temperature

                // Check if the date is January 1, 2023
                if (isJanuaryFirst2023(date)) {
                    System.out.println("Adding the tempeture: " + temperature + " of date " + date);
                    temperatures.add(temperature); // Add to the list if the date matches
                }
            } catch (ParseException | NumberFormatException e) {
                // Handle invalid rows or errors
                System.out.println("Invalid row: " + e.getMessage());
    
                // Optionally, you can print the stack trace for more details
                e.printStackTrace();
            }
        }

        // Calculate and print the average temperature for January 1, 2023
        double averageTemp = calculateAverage(temperatures);
        System.out.println("Average temperature for January 1, 2023: " + averageTemp + " °C");

        // Close the reader
        reader.close();
    }

    // Method to check if the date is January 1, 2023
    public static boolean isJanuaryFirst2023(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR) == 2023 && cal.get(Calendar.MONTH) == Calendar.JANUARY && cal.get(Calendar.DAY_OF_MONTH) == 1;
    }

    // Method to calculate the average temperature
    public static double calculateAverage(List<Double> temperatures) {
        if (temperatures.isEmpty()) {
            System.out.println("The temperatures list is empty!");
            return 0.0; // Return 0 if no temperatures were found
        }

        double sum = 0;
        for (double temp : temperatures) {
            System.out.println("Tempeture: " + temp + " added to the list.");
            sum += temp;
        }
        return sum / temperatures.size(); // Return the average
    }
}