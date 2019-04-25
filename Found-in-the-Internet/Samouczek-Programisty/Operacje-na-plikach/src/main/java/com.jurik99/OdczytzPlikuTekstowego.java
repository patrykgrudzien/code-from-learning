package com.jurik99;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@SuppressWarnings("SpellCheckingInspection")
public class OdczytzPlikuTekstowego {

    public static void main(final String[] args) {

        final String filePath = "/home/jurik99/Projects/my-whole-code/Found-in-the-Internet/Samouczek-Programisty/" +
                "Operacje-na-plikach/src/main/files/text-file-1.txt";
        int number = 0;

        try (final FileReader fileReader = new FileReader(filePath);
             final BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            // it will read the first character from "1234567" -> "1" as binary (in this case = 49 which is ASCII value)
            final int firstCharacter = fileReader.read();
            System.out.println("firstCharacter = " + firstCharacter);
            System.out.println("Character.getNumericValue(firstCharacter) = " + Character.getNumericValue(firstCharacter));

            /**
             * Musisz też wiedzieć, że klasy które pozwalają Ci na czytanie pliku mają tak zwany „wskaźnik”,
             * który zapamiętuje ostatnie miejsce z którego coś przeczytaliśmy.
             * Kolejna próba odczytu przesuwa ten wskaźnik dalej.
             */
            final String numberAsString = bufferedReader.readLine();
            number = Integer.parseInt(numberAsString);

        } catch (final IOException e) {
            e.printStackTrace();
        }

        System.out.println("number = " + number);
    }
}
