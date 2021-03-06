package Adnotacje;

import java.lang.reflect.Field;

public class Main
{
    public static void main(String[] args)
    {
        Main main = new Main();
        main.run();
    }

    private void run()
    {
        User user = new User();

        Field[] fields = user.getClass().getDeclaredFields();

        for (Field f : fields)
        {
            if (f.isAnnotationPresent(DatabaseField.class))
            {
                DatabaseField databaseField = f.getAnnotation(DatabaseField.class);
                System.out.println("Field name: " + f.getName() + " | " + databaseField.columnName());
            }
        }
    }
}
