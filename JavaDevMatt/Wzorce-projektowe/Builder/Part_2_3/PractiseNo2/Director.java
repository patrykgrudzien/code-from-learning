package DesignPatterns.Builder.Part_2_3.PractiseNo2;

public class Director
{
    private final Builder builder;

    public Director(Builder builder)
    {
        this.builder = builder;
    }

    public void makeCar()
    {
        builder.buildEngine();
        builder.buildTires();
        builder.giveBrand();
        builder.giveModel();
        builder.paint();
    }

    public Car getCar()
    {
        return builder.getCar();
    }
}
