package DesignPatterns.Builder.Part_2_3.PractiseNo1;

public class Roof
{
    private int angle;
    private String surfaceType;

    public int getAngle()
    {
        return angle;
    }

    public void setAngle(int angle)
    {
        this.angle = angle;
    }

    public String getSurfaceType()
    {
        return surfaceType;
    }

    public void setSurfaceType(String surfaceType)
    {
        this.surfaceType = surfaceType;
    }

    @Override
    public String toString()
    {
        return "Roof{" +
                "angle=" + angle +
                ", surfaceType='" + surfaceType + '\'' +
                '}';
    }
}
