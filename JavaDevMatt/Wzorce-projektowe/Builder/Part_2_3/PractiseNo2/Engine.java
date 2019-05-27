package DesignPatterns.Builder.Part_2_3.PractiseNo2;

public class Engine
{
    private String type;

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
