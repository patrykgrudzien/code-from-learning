package com.jurik99;

import java.io.FileWriter;
import java.io.IOException;

@SuppressWarnings("SpellCheckingInspection")
public class ZapisDoPlikuTekstowego {

    public static void main(final String[] args) {

        final String filePath = "/home/jurik99/Projects/my-whole-code/Found-in-the-Internet/Samouczek-Programisty/" +
                "Operacje-na-plikach/src/main/files/text-file-1.txt";
        final int number = 1234567;

        /**
         * {@link FileWriter},
         * jest to klasa ze standardowej biblioteki języka Java odpowiedzialna za zapis do pliku tekstowego.
         */
        try (final FileWriter fileWriter = new FileWriter(filePath)) {

            fileWriter.write(Integer.toString(number));
            /**
             * Wywołując metodę close zamykamy dostęp do pliku, jeśli ta operacja się powiedzie mamy pewność,
             * że dane zostały zapisane w pliku na dysku.
             */

        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
