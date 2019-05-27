package DesignPatterns.Builder.Part_2_3.PractiseNo1;

import java.awt.Color;

public class PatrykHouse implements HouseBuilder
{
    private final House house;

    public PatrykHouse()
    {
        this.house = new House();
    }

    @Override
    public void buildWalls()
    {
        Walls walls = new Walls();
        walls.setColor(Color.BLUE);
        walls.setType("Nośne");

        house.setWalls(walls);
    }

    @Override
    public void buildRoof()
    {
        Roof roof = new Roof();
        roof.setAngle(45);
        roof.setSurfaceType("Dachówka");

        house.setRoof(roof);
    }

    @Override
    public House getHouse()
    {
        return house;
    }
}
