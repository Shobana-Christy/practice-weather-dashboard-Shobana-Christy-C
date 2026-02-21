package com.example.myproject;

public class Weather {
        private String city;
        private String temperature;
        private String description;
        private int humidity;




    public Weather(String city, String temperature, String description,int humidity) {
            this.city = city;
            this.temperature = temperature;
            this.description = description;
            this.humidity=humidity;
        }

        public String getCity() {
            return city;
        }



        public String getTemperature() {
            return temperature;
        }



        public String getDescription() {
            return description;
        }

        public int getHumidity() {
            return humidity;
        }

}
