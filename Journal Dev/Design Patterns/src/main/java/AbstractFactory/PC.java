package AbstractFactory;

public class PC extends Computer
{
    private String type;
    private String ram;
    private String hdd;
    private String cpu;

    public PC(String ram, String hdd, String cpu)
    {
        this.type = PC.class.getSimpleName();
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    public String getCPU()
    {
        return this.cpu;
    }

    @Override
    public String getHDD()
    {
        return this.hdd;
    }

    @Override
    public String getRAM()
    {
        return this.ram;
    }

    @Override
    public String getType()
    {
        return this.type;
    }
}
