import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        BufferedReader reader;
        int sum = 0;
        //READING FILE IN.
        try {
            reader = new BufferedReader(new FileReader("C:\\Users\\zaras\\Documents\\Worksheet 1\\dayone\\src\\calivalues"));
            List<String> fileLines = new ArrayList<>();
            String line = reader.readLine();

            while (line != null) {
                fileLines.add(line);
                line = reader.readLine();
            }
            reader.close();
// START OF STRING MANSPLAIN
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < fileLines.size(); i++) {
                String currentLine = fileLines.get(i);
                StringBuilder currentDigits = new StringBuilder();
                for (int indexOfchar = 0; indexOfchar < currentLine.length(); indexOfchar++) {
                    char currentChar = currentLine.charAt(indexOfchar);
                    if (Character.isDigit(currentChar)) {
                        currentDigits.append(currentChar);
                    }
                }
                temp.add(currentDigits.toString());
            }
            for (int i = 0; i < temp.size(); i++) {
                StringBuilder result = new StringBuilder();
                String currentTemp = temp.get(i);
                if (currentTemp.length() > 2) {
                    result.append(currentTemp.charAt(0));
                    result.append(currentTemp.charAt(currentTemp.length() - 1));
                    temp.set(i, result.toString());
                } else if (currentTemp.length() == 1) {
                    result.append(currentTemp.charAt(0)).append(currentTemp.charAt(0));
                    temp.set(i, result.toString());
                }
            }
            int[] intArray = new int[temp.size()];
            for (int i = 0; i < temp.size(); i++) {
                    intArray[i] = Integer.parseInt(temp.get(i));
                    System.out.println(intArray[i]);
                    sum += intArray[i];
            }
            System.out.println(sum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
