package Util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFromCSV {
    private final char Default_separator = ',';
    private final char Default_Quote = '"';
    private String csvfile;
    private String path = "src/test/java/TestData";

    public ReadFromCSV(String filename) {
        csvfile = path + "/" + filename;

    }

    public String readValue(String TestCaseName, String keyName) {

        String value = "";
        try {
            Scanner scanner = new Scanner(new File(csvfile));
            while (scanner.hasNext()) {
                List<String> line = parseLine(scanner.nextLine());
                if (line.get(1).equals(TestCaseName) && line.get(2).equals(keyName)) {

                    value = line.get(3);
                    break;

                }
            }
            scanner.close();
            return value;

        } catch (Exception ex) {
            System.out.println("exception : " + ex);
        }
        return value;
    }

    private List<String> parseLine(String csvLine) {
        return parseLine(csvLine, Default_separator, Default_Quote);
    }


    private List<String> parseLine(String csvLine, char separators, char customQoute) {
        List<String> result = new ArrayList<>();
        //if empty, return!
        if (csvLine == null && csvfile.isEmpty()) {
            return result;
        }
        if (customQoute == ' ') {
            customQoute = Default_Quote;
        }
        if (separators == ' ') {
            customQoute = Default_separator;
        }

        StringBuffer curVal = new StringBuffer();
        boolean inQuotes = false;
        boolean startCollectChar = false;
        boolean doubleQuotesIncolumn = false;

        char[] chars = csvLine.toCharArray();
        for (char ch : chars) {
            if (inQuotes) {
                startCollectChar = true;
                if (ch == customQoute) {
                    inQuotes = false;
                    doubleQuotesIncolumn = false;
                }
                // fixed : allow "" in custom quote enclosed
                else {
                    if (ch == '\"') {
                        if (!doubleQuotesIncolumn) {
                            curVal.append(ch);
                            doubleQuotesIncolumn = true;
                        }

                    } else {
                        curVal.append(ch);
                    }

                }
            } else {
                if (ch == customQoute) {
                    inQuotes = true;

                    if (chars[0] != '"' && customQoute == '\"') {
                        curVal.append('"');
                    }
                    if (startCollectChar) {
                        curVal.append('"');
                    }
                } else if (ch == separators) {
                    result.add(curVal.toString());
                    curVal = new StringBuffer();
                    startCollectChar = false;
                } else if (ch == '\r') {
                    continue;
                } else if (ch == '\n') {
                    break;
                    //the End.
                } else {
                    curVal.append(ch);
                }

            }
        }
        result.add(curVal.toString());
        return result;

    }
}

