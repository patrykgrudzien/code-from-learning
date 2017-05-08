package me.jurik99;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CreateDescriptionFile
{
    // --- create file with name related to name of lecture
    public static void createTextFileWithNameOfLecture(final String path, final String fileName,
                                                       final String description)
    {
        PrintWriter printWriter = null;
        try
        {
            printWriter = new PrintWriter(new File(path + "\\" + fileName + ".txt"));
            printWriter.write(description);
        }
        catch (final FileNotFoundException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (printWriter != null)
            {
                printWriter.close();
            }
        }
    }
}
