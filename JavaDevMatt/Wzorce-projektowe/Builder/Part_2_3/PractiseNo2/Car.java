package DesignPatterns.Builder.Part_2_3.PractiseNo2;

public class Car
{
    private String brand, model, color;
    private Engine engine;
    private Tires tires;

    public Engine getEngine()
    {
        return engine;
    }

    public void setEngine(Engine engine)
    {
        this.engine = engine;
    }

    public Tires getTires()
    {
        return tires;
    }

    public void setTires(Tires tires)
    {
        this.tires = tires;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    @Override
    public String toString()
    {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", engine=" + engine +
                ", tires=" + tires +
                '}';
    }
}
