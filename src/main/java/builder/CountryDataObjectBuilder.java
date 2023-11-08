package builder;

import model.CountryDataObject;

public class CountryDataObjectBuilder implements Builder {

    private CountryDataObject countryDataObject = new CountryDataObject();

    public CountryDataObject build() {
        return countryDataObject;
    }
    public CountryDataObjectBuilder name(String name) {
        countryDataObject.setName(name);
        return this;
    }
    public CountryDataObjectBuilder nativeName(String nativeName) {
        countryDataObject.setNativeName(nativeName);
        return this;
    }
    public CountryDataObjectBuilder alpha2Code(String alpha2Code) {
        countryDataObject.setAlpha2Code(alpha2Code);
        return this;
    }
    public CountryDataObjectBuilder capital(String capital) {
        countryDataObject.setCapital(capital);
        return this;
    }
    public CountryDataObjectBuilder area(double area) {
        countryDataObject.setArea(area);
        return this;
    }
    public CountryDataObjectBuilder population(int population) {
        countryDataObject.setPopulation(population);
        return this;
    }
    public CountryDataObjectBuilder language(String language) {
        countryDataObject.setLanguage(language);
        return this;
    }

}
