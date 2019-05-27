package DesignPatterns.Builder.Part_2_3.PractiseNo2;

public interface Builder
{
    void buildTires();

    void buildEngine();

    Car getCar();

    void paint();

    void giveBrand();

    void giveModel();
}
