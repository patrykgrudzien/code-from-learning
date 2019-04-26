package com.jurik99;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@SuppressWarnings({"SpellCheckingInspection", "DanglingJavadoc"})
public class ZapisDoPlikuBinarnego {

    public static void main(final String[] args) {

        final String filePath = "/home/jurik99/Projects/my-whole-code/Found-in-the-Internet/Samouczek-Programisty/" +
                "Operacje-na-plikach/src/main/files/binary-file-1.txt";
        final int number = 1234567;

        try (final DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(filePath))) {

            /**
             * {@link DataOutputStream} zapewnia interfejs pozwalający na binarny zapis typów prymitywnych w Javie
             * podczas gdy {@link FileOutputStream} pozwala na zapis danych bajt po bajcie.
             *
             * Używanie {@link DataOutputStream} pozwala programiście zapomnieć o szczegółach
             * w jaki liczby powinny być zapisane binarnie, tymi szczegółami zajmuje się właśnie ta klasa
             * przez wywołanie metody {@link DataOutputStream#writeInt(int)}.
             * Pozwala ona w łatwy sposób zapisać binarnie typy proste i łańcuchy znaków.
             */
            dataOutputStream.writeInt(number);

        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
