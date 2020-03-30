package by.academy.HomeWork2.task1;

public enum Country implements ICountry {
    RUSSIA(17100000, 146877088),
    CANADA(9984670, 38006000),
    CHINA(9597000, 1400970200),
    USA(9519431, 329210630),
    BRAZIL(8515770, 211014564),
    AUSTRALIA(7692024, 25669000),
    INDIA(3287263, 1357580350),
    ARGENTINA(2780400, 44938712),
    KAZAKHSTAN(2724902, 18679980),
    ALGERIA(2381741, 43053000);
    private long area;
    private long population;

    Country(long area, long population) {
        this.area = area;
        this.population = population;
    }

    @Override
    public long getArea() {
        return area;
    }

    @Override
    public long getPopulation() {
        return population;
    }
}
