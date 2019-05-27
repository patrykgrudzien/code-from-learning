package DesignPatterns.Builder.Part_1_3;

import java.math.BigDecimal;

class Car
{
    private String brand, model, color;
    private int age;
    private BigDecimal price;

    private Car(final Builder builder)
    {
        this.brand = builder.brand;
        this.model = builder.model;
        this.color = builder.color;
        this.age = builder.age;
        this.price = builder.price;
    }

    public String getBrand()
    {
        return brand;
    }

    public String getModel()
    {
        return model;
    }

    public String getColor()
    {
        return color;
    }

    public int getAge()
    {
        return age;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public String toString()
    {
        return "Brand: " + brand + "\nModel: " + model + "\nColor: " + color + "\nAge: " + age + "\nPrice: " + price + "zł\n";
    }

    // ================================================================================================================ //
    public static class Builder
    {
        private String brand, model, color;
        private int age;
        private BigDecimal price;

        public Builder()
        {
            this("Builder default");
        }

        public Builder(String brand)
        {
            this.brand = brand;
        }

        public Builder brand(String brand)
        {
            this.brand = brand;
            return this;
        }

        public Builder model(String model)
        {
            this.model = model;
            return this;
        }

        public Builder color(String color)
        {
            this.color = color;
            return this;
        }

        public Builder age(int age)
        {
            this.age = age;
            return this;
        }

        public Builder price(double price)
        {
            this.price = BigDecimal.valueOf(price);
            return this;
        }

        public Car build()
        {
            return new Car(this);
        }
    }
}
