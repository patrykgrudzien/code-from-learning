package DesignPatterns.Builder.Part_2_3.Entities;

public class Engine
{
    private String type;
    // np. V8, V6

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "Engine{" +
                "type='" + type + '\'' +
                '}';
    }
}
