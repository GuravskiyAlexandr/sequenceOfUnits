package com.company;

import java.io.*;

public class Main {
    private static final String TEXT = "00000000111111100001111000001100110011110000";
    private static final String INPUTFILENAME = "inputFile.txt";
    private static final String OUTPUTFILENAME = "outputFile.txt";

    public static void main(String[] args) throws IOException {

        exists(INPUTFILENAME);
        createFile(INPUTFILENAME, TEXT);
        countUnitSearch(INPUTFILENAME, OUTPUTFILENAME);
    }

    private static void createFile(String inputFileName, String text) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(inputFileName))) {
            bufferedWriter.write(text);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void countUnitSearch(String inputFileName, String outputFileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))) {
            String line;
            int count = 0, num = 0;
            while ((line = br.readLine()) != null) {
                String[] number = line.split("");

                int[] numbers = processLine(number);
                for (int i = 0; i < numbers.length; i++) {
                    if (numbers[i] == 1) {
                        count++;
                    } else count = 0;
                    if (count > num) {
                        num = count;
                    }
                }
                System.out.println(num);
                bw.write(String.valueOf(num));
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void exists(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    private static int[] processLine(String[] strings) {
        int[] intarray = new int[strings.length];
        int i = 0;
        for (String str : strings) {
            intarray[i] = Integer.parseInt(str);
            i++;
        }
        return intarray;
    }
}