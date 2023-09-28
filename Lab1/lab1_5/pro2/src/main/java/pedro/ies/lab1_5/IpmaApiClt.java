package pedro.ies.lab1_5;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;


public class IpmaApiClt {
    private Retrofit retrofit;
    private IpmaService service;
    private int city_id = 0;
    private String city_name;

    public IpmaApiClt() {
        
         // get a retrofit instance, loaded with the GSon lib to convert JSON into objects
         Retrofit retrofit = new Retrofit.Builder()
         .baseUrl("http://api.ipma.pt/open-data/")
         .addConverterFactory(GsonConverterFactory.create())
         .build();

        // create a typed interface to use the remote API (a client)
        service = retrofit.create(IpmaService.class);
    }

    private List<Integer> getAvailableCities() {
        IpmaCities cities = getCitiesData();
        List<Integer> cityList = new ArrayList<Integer>();
        ListIterator<CityData> citiesIterator = cities.getData().listIterator();
        while (citiesIterator.hasNext()) {
            cityList.add(citiesIterator.next().getGlobalIdLocal());
        }

        return cityList;
    }

    private IpmaCityForecast getCityForecast() {
        Random random = new Random();
        List<Integer> cityList = getAvailableCities();
        IpmaCityForecast forecast = null;


        int lst_pos = random.nextInt(cityList.size());
        city_id = cityList.get(lst_pos);
        forecast = getCityForecastFromId(cityList.get(lst_pos));

        return forecast;
    }

    public void displayCityForecast() {
        IpmaCityForecast forecast = getCityForecast();
        
        IpmaCities cities = getCitiesData();
        ListIterator<CityData> citiesIterator = cities.getData().listIterator();

        while(citiesIterator.hasNext()) {
            CityData city = citiesIterator.next();
            if(city.getGlobalIdLocal() == city_id) {
                city_name = city.getLocal();
                break;
            }
        }

        List<CityForecast> forecastList = forecast.getData();
        
        System.out.println();
        System.out.println("--- Weather Forecast for " + city_name + " ---");
        for(CityForecast df : forecastList) {
            System.out.println("    --- " + df.getForecastDate() + " ---");
            System.out.printf("MaxTemp: %4.1f ºC%n", Double.parseDouble(df.getTMax()));
            System.out.printf("MinTemp: %4.1f ºC%n", Double.parseDouble(df.getTMin()));
            System.out.printf("ProbPrecip: %2.1f %% %n", Double.parseDouble(df.getPrecipitaProb()));
            System.out.println();
        }
    }

    private IpmaCities getCitiesData() {
        Call<IpmaCities> callCities = service.getDistritsIslands();
        IpmaCities cities = null;

        try {
            Response<IpmaCities> responseCities = callCities.execute();
            cities = responseCities.body();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cities;
    }

    private IpmaCityForecast getCityForecastFromId(int cityId) {
        Call<IpmaCityForecast> callForecast = service.getForecastForACity(cityId);
        IpmaCityForecast forecast = null;

        try  {
            Response<IpmaCityForecast> responseForecast = callForecast.execute();
            forecast = responseForecast.body();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return forecast;
    }
}