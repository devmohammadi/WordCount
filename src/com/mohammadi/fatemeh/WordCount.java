package com.mohammadi.fatemeh;

import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String readString = scanner.nextLine();
        String plus = "";

        while (!readString.equals("exit")) {
            while (!readString.isEmpty()) {
                plus = plus + "\n" + readString;
                readString = scanner.nextLine();
            }

            //Get options from the args variable
            if (args.length != 0) {
                if (args[0].equals("-l") || args[0].equals("--lines"))
                    System.out.println("Lines Is : " + NumOfLines(plus));

                if (args[0].equals("-w") || args[0].equals("--words"))
                    System.out.println("Words Is : " + NumOfWords(plus));

                if (args[0].equals("-c") || args[0].equals("--chars"))
                    System.out.println("Chars Is : " + NumOfChars(plus));
            } else
                System.out.println("Lines Is : " + NumOfLines(plus) + "\nWords Is : " + NumOfWords(plus) + "\nChars Is : " + NumOfChars(plus) + "\n");

            plus = "";
            readString = scanner.nextLine();
        }
        scanner.close();
        System.out.println("GoodBye.....");
    }

    static int NumOfLines(String input) {
        //split "\r\n|\r|\n" to get the number of lines (we do not consider the last blank line)
        String[] lines = input.split("\r\n|\r|\n");
        return lines.length - 1;
    }

    static int NumOfWords(String input) {
        String[] words = input.split(" ");
        return words.length + NumOfLines(input) - 1;
    }

    static int NumOfChars(String input) {
        int chars = 0;
        for (int i = 0; i < input.length(); ++i) {
            //Empty distance detection
            if (!Character.isWhitespace(input.charAt(i)))
                chars++;
        }
        return chars;
    }
}