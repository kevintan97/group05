package Main.Parser;

import Main.Graphs.Data;

import javax.swing.*;
import java.io.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//Class responsible for parsing data from the selected file to a List of Data objects.
//This also requires handling any errors that may be thrown while trying to open/close the file and
//errors that may be thrown when parsing is attempted.
public class Parser {
    private static File file;

    private static List<Data> dataEntries;

    public Parser(File file) {
        Parser.file = file;
    }

    //Parses the data, this allowed the parsing to take place at any point after a Parser instance has been created.
    public void parseData() {
        dataEntries = new ArrayList<>();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        BufferedReader br = null;
        String line;

        try {
            int line1 = 0;
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                if (line1 == 0) {
                    line1++;
                    continue;
                }

                try {
                    String[] entry = line.split(",");
                    Date date = simpleDateFormat.parse(entry[1]);
                    Data newEntry = new Data(Integer.parseInt(entry[0].trim()), date, doubleFormat(entry[2].trim()),
                            doubleFormat(entry[3].trim()), doubleFormat(entry[4].trim()),
                            doubleFormat(entry[5].trim()), doubleFormat(entry[6].trim()),
                            doubleFormat(entry[7].trim()), doubleFormat(entry[8].trim()),
                            doubleFormat(entry[9].trim()), doubleFormat(entry[10].trim()),
                            doubleFormat(entry[11].trim()), doubleFormat(entry[12].trim()),
                            doubleFormat(entry[13].trim()), doubleFormat(entry[14].trim()),
                            doubleFormat(entry[15].trim()), doubleFormat(entry[16].trim()),
                            doubleFormat(entry[17].trim()));
                    dataEntries.add(newEntry);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid file");
                    System.exit(1);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid file format");
                    System.exit(1);
                }
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Invalid file");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Invalid file type");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Invalid file");
                }
            }
        }
        JOptionPane.showMessageDialog(null, "File Successfully parsed!");
    }

    /**
     * Rounds double values to 3 decimal places
     * @param value Takes a string argument to be formatted
     * @return returns the newly formatted value as a double
     */
    private Double doubleFormat(String value) {
        Double d = Double.parseDouble(value);
        DecimalFormat df = new DecimalFormat("0.###");
        return Double.parseDouble(df.format(d));
    }

    //simple getter to keep data private.
    public List<Data> getData() { return dataEntries; }
}
