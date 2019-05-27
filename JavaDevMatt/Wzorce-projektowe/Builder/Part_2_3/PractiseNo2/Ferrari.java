package DesignPatterns.Builder.Part_2_3.PractiseNo2;

public class Ferrari implements Builder
{
    private Car car;

    public Ferrari()
    {
        this.car = new Car();
    }

    @Override
    public void buildTires()
    {
        Tires tires = new Tires();
        tires.setProducent("Dunlop");
        car.setTires(tires);
    }

    @Override
    public void buildEngine()
    {
        Engine engine = new Engine();
        engine.setType("V10");
        car.setEngine(engine);
    }

    @Override
    public void paint()
    {
        car.setColor("Black");
    }

    @Override
    public void giveBrand()
    {
        car.setBrand("Ferrari");
    }

    @Override
    public void giveModel()
    {
        car.setModel("Italia");
    }

    @Override
    public Car getCar()
    {
        return car;
    }
}
