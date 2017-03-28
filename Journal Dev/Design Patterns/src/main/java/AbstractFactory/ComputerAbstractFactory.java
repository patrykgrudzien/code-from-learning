package AbstractFactory;

public interface ComputerAbstractFactory
{
    /**
     * By creating Factory of factories WE GET RID OF (if-else) block which provides us to return proper sub-class
     */
    Computer createComputer();
}
