import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Class FileParser contains four methods namely: FileParser, getVowels, checkO, and removeDuplicates
 */
public class FileParser {
    /**
     * method fileParser takes a String fileName as parameter, it declares one Scanner object to read the file passed, and three PrintWriter
     * objects that open three output files. pwVowell outputs vowel_verbiage.txt, which contains all of the words from the input file that have
     * 3+ vowels. pwO outputs obsessive_o, which contains all of the words that start with the letter 'O'. pwDistinct outputs distinct_data.txt
     * which contains all of the distinct words from the input file.
     * @param fileName: accepts any file with extension ".txt"
     */
    public static void fileParser(String fileName) {
        Scanner sc = null;
        PrintWriter pwVowell = null;
        PrintWriter pwO = null;
        PrintWriter pwDistinct = null;
        try {
            sc = new Scanner(new FileInputStream(fileName));
            pwVowell = new PrintWriter(new FileOutputStream("vowel_verbiage.txt"));
            pwO = new PrintWriter(new FileOutputStream("obsessive_o.txt"));
            pwDistinct = new PrintWriter(new FileOutputStream("distinct_data.txt"));
            ArrayList<String> fileData = new ArrayList<>();
            ArrayList<String> vowels = new ArrayList<>();
            ArrayList<String> startsO = new ArrayList<>();
            ArrayList<String> startsONoDuplicates = new ArrayList<>();
            ArrayList<String> remaining = new ArrayList<>();
            ArrayList<String> distinct = new ArrayList<>();
            while (sc.hasNext()) {
                String str = sc.next().replaceAll("[^a-zA-Z0-9]", "");
                fileData.add(str);
            }

            for (int i = 0; i < fileData.size(); i++) {
                String str1 = fileData.get(i);
                if (getVowels(str1) > 3) {
                    vowels.add(str1);
                } else if (checkO(str1)) {
                    startsO.add(str1);
                    startsONoDuplicates = removeDuplicates(startsO);
                } else {
                    remaining.add(str1);
                    distinct = removeDuplicates(remaining);
                }
            }

            int vowelWordCount = vowels.size();

            pwVowell.println("Word count: " + vowelWordCount);

            int oWordCount = startsONoDuplicates.size();

            pwO.println("Word count: " + oWordCount);

            int distinctWordCount = distinct.size();

            pwDistinct.println("Word count: " + distinctWordCount);

            for (int i = 0; i < vowels.size(); i++) {
                pwVowell.println(vowels.get(i));
            }
            for (int i = 0; i < startsONoDuplicates.size(); i++) {
                pwO.println(startsONoDuplicates.get(i));
            }
            for (int i = 0; i < distinct.size(); i++) {
                pwDistinct.println(distinct.get(i));
            }
            pwVowell.close();
            pwO.close();
            pwDistinct.close();

        } catch (FileNotFoundException e) {
            System.out.println("File could not be found, please try again later!");
        }
    }

    /**
     * method getVowels takes a String word as parameter and counts how many vowels are in that word. The number of vowels is stored in i
     * and then the method returns i.
     * @param word: accepts any word
     * @return: the number of vowels in the word
     */
    public static int getVowels(String word) {
        int i = 0;
        char ch;
        for (int j = 0; j < word.length(); j++) {
            ch = word.charAt(j);
            switch (ch) {
                case 'a':
                    i++;
                    break;
                case 'e':
                    i++;
                    break;
                case 'i':
                    i++;
                    break;
                case 'o':
                    i++;
                    break;
                case 'u':
                    i++;
                    break;
                case 'A':
                    i++;
                    break;
                case 'E':
                    i++;
                    break;
                case 'I':
                    i++;
                    break;
                case 'O':
                    i++;
                    break;
                case 'U':
                    i++;
                    break;
            }
        }
        return i;
    }

    /**
     * method accepts a String word as parameter and checks to see whether or not word starts with the letter 'O'.
     * @param word: accepts any word
     * @return: true if the word starts with 'o' and false if not.
     */
    public static boolean checkO(String word) {
        boolean found = false;
        if (word == null) {
            found = false;
        } else if (word.length() == 0) {
            found = false;
        } else {
            found = word.charAt(0) == 'O' || word.charAt(0) == 'o';
        }
        return found;
    }

    /**
     * method accepts a String ArrayList as parameter and returns another String ArrayList that contains only distinct
     * Strings
     * @param words: accepts any word
     * @return: a String ArrayList with no duplicates
     */
    public static ArrayList<String> removeDuplicates(ArrayList<String> words) {
        ArrayList<String> noDuplicates = new ArrayList<>();

        for (String element : words) {
            if (!noDuplicates.contains(element)) {
                noDuplicates.add(element);
            }
        }
        return noDuplicates;
    }
}

/**
 * Class demo contains the main method
 */
class demo{
    /**
     * main method applies the fileParser method
     * @param args
     */
    public static void main(String[] args){
        Scanner keyIn=new Scanner(System.in);
        System.out.println("Enter the name of the file that you would like to convert:");
        String name = keyIn.next();
        FileParser.fileParser(name);
        System.out.println("File has been successfully converted!");

    }
}
