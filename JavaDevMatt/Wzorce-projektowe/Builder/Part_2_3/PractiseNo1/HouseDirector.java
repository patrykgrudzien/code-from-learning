package DesignPatterns.Builder.Part_2_3.PractiseNo1;

public class HouseDirector
{
    private HouseBuilder houseBuilder;

    public HouseDirector(HouseBuilder houseBuilder)
    {
        this.houseBuilder = houseBuilder;
    }

    public void buildHouse()
    {
        houseBuilder.buildRoof();
        houseBuilder.buildWalls();
    }

    public House getHouse()
    {
        return houseBuilder.getHouse();
    }
}
