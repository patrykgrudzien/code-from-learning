package AbstractFactory;

public abstract class Computer
{
    public abstract String getCPU();

    public abstract String getHDD();

    public abstract String getRAM();

    public abstract String getType();

    @Override
    public String toString()
    {
        return "TYPE: " + this.getType() + ", RAM: " + this.getRAM() + ", HDD: " + this.getHDD() + ", CPU: " + this.getCPU();
    }
}
