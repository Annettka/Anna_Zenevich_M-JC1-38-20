package by.academy.HomeWork2.task1;

public class MainCountry {
    public static void main(String[] args) {
        ECountry countryInfo = ECountry.ARGENTINA;
        ECountry countryFormString = ECountry.valueOf("ARGENTINA");
        System.out.println(countryInfo == countryFormString);

        /*Country countryFormString1 = Country.valueOf("BELARUS");
        System.out.println(countryFormString1);
        //Exception in thread "main" java.lang.IllegalArgumentException: No enum constant by.academy.HomeWork2.task1.Country.BELARUS
        at java.base/java.lang.Enum.valueOf(Enum.java:240)
	    at by.academy.HomeWork2.task1.Country.valueOf(Country.java:3)
	    at by.academy.HomeWork2.task1.MainCountry.main(MainCountry.java:8)*/

        ECountry countryInfo2 = ECountry.RUSSIA;
        ECountry countryInfo3 = ECountry.USA;
        System.out.println(countryInfo2.compareTo(countryInfo3));
        System.out.println(countryInfo.compareTo(countryFormString));

        CountryAreaComparator comparator = new CountryAreaComparator();
        System.out.println(comparator.getLargestArea(ECountry.ALGERIA, ECountry.CANADA));
        System.out.println(comparator.getLargestArea(ECountry.CHINA, ECountry.INDIA));
    }
}
