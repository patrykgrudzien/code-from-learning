package DesignPatterns.Builder.Part_2_3.PractiseNo1;

import java.awt.Color;

public class Walls
{
    private Color color;
    private String type;

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

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
        return "Walls{" +
                "color=" + color +
                ", type='" + type + '\'' +
                '}';
    }
}
