import io.restassured.path.json.JsonPath;

import java.util.ArrayList;

import static io.restassured.RestAssured.get;

public class Challenge {
    public static void main(String[] args) {
        countriesAPIAssured();
        ratesAPIAssured();
    }

    private static void countriesAPIAssured() {
        String URL = "https://restcountries.eu/rest/v2/name/israel";
        JsonPath responseBody = get(URL).body().jsonPath();
        String region = responseBody.get("region[0]");
        ArrayList<String> callingCodes = responseBody.get("callingCodes[0]");
        String borders = responseBody.getString("borders[0]");
        String symbol = responseBody.getString("currencies.symbol");

        System.out.println(region + " " + callingCodes.get(0) + " " + borders + " " + symbol);
    }

    private static void ratesAPIAssured() {
        String URL = "https://api.exchangeratesapi.io/latest?base=USD";
        float value = get(URL).body().path("rates.ILS");
        System.out.println(value * 3);
    }
}
