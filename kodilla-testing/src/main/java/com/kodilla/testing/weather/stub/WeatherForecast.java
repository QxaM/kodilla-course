package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {

    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

        public Map<String, Double> calculateForecast(){
            Map<String, Double> resultMap = new HashMap<>();

            for(Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()){

                resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
            }
            return resultMap;
        }

        public double calculateAverage(){
            double sum = 0;
            for(Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()){
                sum += temperature.getValue();
            }
            return sum/temperatures.getTemperatures().size();
        }

        public double calculateMedian(){
            List<Double> temperaturesList = new ArrayList<>(temperatures.getTemperatures().values());
            Collections.sort(temperaturesList);

            double median;
            int middlePoint = temperatures.getTemperatures().size()/2;
            if (temperatures.getTemperatures().size()%2 == 0){
                median = (temperaturesList.get(middlePoint) + temperaturesList.get(middlePoint-1))/2;
            } else {
                median = temperaturesList.get(middlePoint);
            }

            return median;
        }
}

