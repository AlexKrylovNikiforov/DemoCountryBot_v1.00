package model;

public class CountryDataObject {
    private String name;
    private String nativeName;
    private String alpha2Code;
    private String capital;
    private double area;
    private int population;
    private String language;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append("Name: ").append(name).append("\n")
                .append("Native Name: ").append(nativeName).append("\n")
                .append("Code: ").append(alpha2Code).append("\n")
                .append("Capital: ").append(capital).append("\n")
                .append("Area: ").append(area).append("\n")
                .append("Population: ").append(population).append("\n")
                .append("Language: ").append(language)
                .toString();
    }
}
