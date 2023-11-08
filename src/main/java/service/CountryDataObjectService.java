package service;

import builder.CountryDataObjectBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.CountryDataObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CountryDataObjectService {

    private CountryDataObject countryDataObject;

    public CountryDataObject getCountryDataObject (String countryName) {
        try {
            URL url = new URL("https://restcountries.com/v3.1/name/" + countryName.toLowerCase());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JsonArray countries = JsonParser.parseString(response.toString()).getAsJsonArray();
            CountryDataObjectBuilder countryDataObjectBuilder = new CountryDataObjectBuilder();
            if (!countries.isJsonNull() && countries.size() > 0) {
                JsonObject jsonCountryObject = countries.get(0).getAsJsonObject();

                String name = jsonCountryObject.has("name") ? jsonCountryObject.getAsJsonObject("name").has("common") ? jsonCountryObject.getAsJsonObject("name").get("common").getAsString() : "N/A" : "N/A";
                String nativeName = jsonCountryObject.has("name") ? jsonCountryObject.getAsJsonObject("name").has("nativeName") ? jsonCountryObject.getAsJsonObject("name").getAsJsonObject("nativeName").has("ukr") ? jsonCountryObject.getAsJsonObject("name").getAsJsonObject("nativeName").get("ukr").getAsString() : "N/A" : "N/A" : "N/A";
                String alpha2Code = jsonCountryObject.has("cca2") ? jsonCountryObject.get("cca2").getAsString() : "N/A";
                String capital = jsonCountryObject.has("capital") ? jsonCountryObject.getAsJsonArray("capital").size() > 0 ? jsonCountryObject.getAsJsonArray("capital").get(0).getAsString() : "N/A" : "N/A";
                double area = jsonCountryObject.has("area") ? jsonCountryObject.get("area").getAsDouble() : 0.0;
                int population = jsonCountryObject.has("population") ? jsonCountryObject.get("population").getAsInt() : 0;
                String language = jsonCountryObject.has("languages") ? jsonCountryObject.getAsJsonObject("languages").entrySet().iterator().next().getKey() : "N/A";
                String government = jsonCountryObject.has("government") ? jsonCountryObject.get("government").getAsString() : "N/A";
                countryDataObject = countryDataObjectBuilder.name(name)
                        .nativeName(nativeName)
                        .alpha2Code(alpha2Code)
                        .capital(capital)
                        .area(area)
                        .population(population)
                        .language(language)
                        .build();

            } else {
                System.out.println("Country data not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countryDataObject;
    }
}



