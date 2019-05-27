package DesignPatterns.Builder.Part_2_3.PractiseNo2;

public class Tires
{
    private String producent;

    public String getProducent()
    {
        return producent;
    }

    public void setProducent(String producent)
    {
        this.producent = producent;
    }

    @Override
    public String toString()
    {
        return "Tires{" +
                "producent='" + producent + '\'' +
                '}';
    }
}
