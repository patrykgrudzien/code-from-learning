package com.jurik99;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

@SuppressWarnings("SpellCheckingInspection")
public class OdczytzPlikuBinarnego {

    public static void main(final String[] args) {

        final String filePath = "/home/jurik99/Projects/code-from-learning/Found-in-the-Internet/Samouczek-Programisty/" +
                "Operacje-na-plikach/src/main/files/binary-file-1.txt";
        int number = 0;

        try (final DataInputStream dataInputStream = new DataInputStream(new FileInputStream(filePath))) {

            number = dataInputStream.readInt();

        } catch (final IOException e) {
            e.printStackTrace();
        }

        System.out.println("number = " + number);
    }
}
