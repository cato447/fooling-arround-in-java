package src;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Marshal {

    File file;
    RandomAccessFile ramAccessFile;
    DecimalFormat df;

    int chars;

    int[] absoluteValues;
    double[][] relativeValues;
    private char[][] charArray = { { '#', 'e' }, { '#', 'n' }, { '#', 'i' }, { '#', 's' }, { '#', 'r' }, { '#', 'a' },
            { '#', 't' }, { '#', 'd' }, { '#', 'h' }, { '#', 'u' }, { '#', 'l' }, { '#', 'c' }, { '#', 'g' },
            { '#', 'm' }, { '#', 'o' }, { '#', 'b' }, { '#', 'w' }, { '#', 'f' }, { '#', 'k' }, { '#', 'z' },
            { '#', 'p' }, { '#', 'v' }, { '#', 'ß' }, { '#', 'j' }, { '#', 'y' }, { '#', 'x' }, { '#', 'q' } };

    public Marshal(String path) throws IOException {
        file = new File(path);
        ramAccessFile = new RandomAccessFile(file, "rw");
        df = new DecimalFormat("#.00");

        chars = 0;

        absoluteValues = new int[27];
        relativeValues = new double[2][27];
    }

    private void read() throws IOException {
        String line = "";

        while ((line = ramAccessFile.readLine()) != null) {
            line = line.toLowerCase();
            for (int i = 0; i < line.length(); i++) {
                if ((line.charAt(i)+"").matches("[a-z]")){
                    try {
                        absoluteValues[line.charAt(i) - ('a')] += 1;
                        chars++;
                    }
                    catch (Exception e){
                        System.out.println(line.charAt(i));
                    }
                } else if (line.charAt(i) == 'ß'){
                    try {
                        absoluteValues[21] += 1;
                    } catch (Exception e){
                        System.out.println(line.charAt(i));
                    }
                }
            }
        }
        ramAccessFile.seek(0);
    }

    private void relValues(int[] absoluteValues){
        System.out.println(Arrays.toString(absoluteValues));
            for (int i = 0; i < absoluteValues.length; i++){
                relativeValues[0][i] = 'a'+i;
                relativeValues[1][i] = Double.valueOf(df.format((absoluteValues[i]/(double)chars) * 100));
            }
        }

    private void sortMax(double[][] relativeValues){
        double[][] tempArray = relativeValues.clone();

        System.out.println(Arrays.toString(tempArray[1]));
        for (int j = 0; j < tempArray[1].length; j++) {
            int index = -1;
            double biggestValue = -1;
            for (int i = 0; i < tempArray[1].length; i++) {
                if (tempArray[1][i] > biggestValue) {
                    index = i;
                    biggestValue = tempArray[1][i];
                }
            }
            charArray[j][0] = (char)tempArray[0][index];
            tempArray[1][index] = 0;
        }
    }

    private void decrypt() throws IOException {
        String tempLine = "";

        File resultFile = new File(System.getProperty("user.home")+System.getProperty("file.separator")+"results.txt");
        if (resultFile.exists()){
            resultFile.delete();
        }
        resultFile.createNewFile();
        RandomAccessFile rnd = new RandomAccessFile(resultFile, "rw");
        rnd.seek(0);

        while ((tempLine = ramAccessFile.readLine()) != null) {
            tempLine = tempLine.toLowerCase();
            for (int i = 0; i < tempLine.length(); i++){
                if ((tempLine.charAt(i)+"").matches("[a-z]")){
                    System.out.print(charArray[getIndexPosFromArray(tempLine.charAt(i),charArray)][1]);
                    rnd.write(charArray[getIndexPosFromArray(tempLine.charAt(i),charArray)][1]);
                } else {
                    System.out.print(tempLine.charAt(i));
                    rnd.write(tempLine.charAt(i));
                }
            }

        }
        ramAccessFile.close();
        rnd.close();
    }

    private int getIndexPosFromArray(char c, char[][] cArray){
        for (int i = 0; i < cArray.length; i++){
            if (cArray[i][0] == c){
                return i;
            }
        }
        return -1;
    }

    public void analyse(){
        try {
            read();
            relValues(absoluteValues);
            sortMax(relativeValues);
            for (int i = 0; i < charArray.length; i++){
                System.out.print(charArray[i][0] + " | ");
            }
            System.out.println();
            for (int i = 0; i < charArray.length; i++){
                System.out.print(charArray[i][1] + " | ");
            }
            System.out.println();
            decrypt();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        if (args.length == 1) {
            Marshal marshal = new Marshal(args[0]);
            marshal.analyse();
        } else if(args.length == 0){
            System.err.println("File location is missing");
        } else {
            System.err.println("Only use this tool with one file at a time");
        }
    }

}
