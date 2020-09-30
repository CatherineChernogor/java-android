package com.company;

import com.google.gson.Gson;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;


class Main_w {
    public float temp;
}

class Weather {
    Main_w main;
}

class City implements Comparable<City>{
    public String name;
    public float temp;

    public City(String c_name, float c_temp) {
        this.name = c_name;
        this.temp = c_temp;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' + ", temp=" + temp;
    }

    @Override
    public int compareTo(City c) {
        return new Float(this.temp).compareTo(c.temp);
    }

}

public class Main {
    public static float getTempByCity(String name) {
        Gson gson = new Gson();
        String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=" + name + "&appid=71ae4c16dab12c08024913ad7a8870b3&units=metric";
        try {
            URL url = new URL(API_URL);
            InputStream stream = (InputStream) url.getContent(); // передаём сетевой поток специальному считывателю
            InputStreamReader reader = new InputStreamReader(stream);
            Weather weather = gson.fromJson(reader, Weather.class); // создать нужные классы
            return weather.main.temp;
        } catch (IOException e) {
            System.out.println(e.getMessage()); // в случае исключения выдаём ошибку на экран
        }
        return -1; // вернуть значение температуры из объекта weather
    }

    public static void main(String[] args) {

        ArrayList<City> cities = new ArrayList<City>();

        try {
            File file = new File("src/cities.txt");     //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);               //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);     // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {

                City c = new City(line, getTempByCity(line));
                cities.add(c);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(cities, Collections.reverseOrder());

        for (City c : cities) {
            System.out.println(c);
        }
    }
}