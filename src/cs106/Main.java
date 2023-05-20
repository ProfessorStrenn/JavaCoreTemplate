package cs106;

import org.apache.commons.io.*;

import java.io.*;
import java.net.*;

import static org.apache.commons.lang3.StringUtils.*;
import static sbcc.Core.*;

public class Main {

    public static void main(String[] args) throws IOException {

        println("Location: ");
        var location = readLine();

        // Use the Geocode web service to turn the location into a latitude and longitude
        var geoUrl = "https://geocode.maps.co/search?q=" + location;
        var geoResponse = IOUtils.toString(new URL(geoUrl), "UTF-8");
        var lat = substringBetween(geoResponse, "\"lat\":\"", "\",");
        var lng = substringBetween(geoResponse, "\"lon\":\"", "\",");

        // Use the Open Meteo web service to get the weather at that lat and lng
        var weatherUrl = "https://api.open-meteo.com/v1/forecast?latitude=" + lat + "&longitude=" + lng + "&current_weather=true&temperature_unit=fahrenheit&windspeed_unit=mph&precipitation_unit=inch";
        var weatherResponse = IOUtils.toString(new URL(weatherUrl), "UTF-8");

        // Parse out the temp and code
        var temperature = substringBetween(weatherResponse, "\"temperature\":", ",");
        var code = substringBetween(weatherResponse, "\"weathercode\":", ",");
        var condition = codeToCondition(code);

        // Print the weather report
        println("\nCurrent weather for " + location + "\n");
        println("Temperature:  " + temperature + " °F");
        println("Condition:  " + condition + "\n");
    }


    /**
     * Converts a WMO weather code into its corresponding interpretation.
     * Generally follows the table given at https://open-meteo.com/en/docs
     *
     * @param code WMO weather code
     * @return Weather condition that corresponds to the given code.  Includes condition emoji as first and last character.
     */
    public static String codeToCondition(String code) {
        var condition = "Unknown";
        if (code.equals("0")) condition = "\u2600 Clear skies \u2600";
        else if (code.equals("1")) condition = "\uD83C\uDF24 Mostly clear \uD83C\uDF24";
        else if (code.equals("2")) condition = "\uD83C\uDF24  Partly cloudy \uD83C\uDF24";
        else if (code.equals("3")) condition = "\u2601 Overcast \u2601";
        else if (code.equals("45")) condition = "\uD83C\uDF2B Foggy \uD83C\uDF2B";
        else if (code.equals("48")) condition = "\uD83C\uDF2B Freezing fog \uD83C\uDF2B";
        else if (code.equals("51")) condition = "\uD83C\uDF26 Light drizzle \uD83C\uDF26";
        else if (code.equals("53")) condition = "\uD83C\uDF27 Moderate drizzle \uD83C\uDF27";
        else if (code.equals("55")) condition = "\uD83C\uDF27 Dense drizzle \uD83C\uDF27";
        else if (code.equals("56")) condition = "\uD83C\uDF27 Light freezing drizzle";
        else if (code.equals("57")) condition = "\uD83C\uDF27 Dense freezing drizzle \uD83C\uDF27";
        else if (code.equals("61")) condition = "\uD83C\uDF27 Slight rain \uD83C\uDF27";
        else if (code.equals("63")) condition = "\uD83C\uDF27 Moderate rain \uD83C\uDF27";
        else if (code.equals("65")) condition = "\uD83C\uDF27 Heavy rain \uD83C\uDF27";
        else if (code.equals("66")) condition = "\uD83C\uDF27 Light freezing rain \uD83C\uDF27";
        else if (code.equals("67")) condition = "\uD83C\uDF27 Heavy freezing rain \uD83C\uDF27";
        else if (code.equals("71")) condition = "\uD83C\uDF28 Lightly snowfall \uD83C\uDF28";
        else if (code.equals("73")) condition = "\uD83C\uDF28 Moderately snowfall \uD83C\uDF28";
        else if (code.equals("75")) condition = "\uD83C\uDF28 Heavy snowfall \uD83C\uDF28";
        else if (code.equals("77")) condition = "\uD83C\uDF28 Snow grains \uD83C\uDF28";
        else if (code.equals("80")) condition = "\uD83C\uDF27 Light rain showers \uD83C\uDF27";
        else if (code.equals("81")) condition = "\uD83C\uDF27 Moderate rain showers \uD83C\uDF27";
        else if (code.equals("82")) condition = "\uD83C\uDF27 Heavy rain showers \uD83C\uDF27";
        else if (code.equals("85")) condition = "\uD83C\uDF28 Light snow showers \uD83C\uDF27";
        else if (code.equals("86")) condition = "\uD83C\uDF28 Heavy snow showers \uD83C\uDF27";
        else if (code.equals("95")) condition = "\uD83C\uDF29 Slight or moderate thunderstorm \uD83C\uDF29";
        else if (code.equals("96")) condition = "\uD83C\uDF29 Slight or moderate thunderstorm with hail \uD83C\uDF29";
        else if (code.equals("97")) condition = "\u26c8 Heavy thunderstorm \u26c8";
        else if (code.equals("99")) condition = "\u26c8 Heavy thunderstorm with hail \u26c8";
        return condition;
    }
}
