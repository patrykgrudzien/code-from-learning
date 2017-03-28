package AbstractFactory;

public class TestAbstractFactoryPattern
{
    public static void main(final String[] args)
    {
        final Computer pc = ComputerFactory.getComputer(new PCFactory("ram", "hdd", "cpu"));
        System.out.println(pc);
    }
}