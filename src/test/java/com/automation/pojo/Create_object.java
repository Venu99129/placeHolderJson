package com.automation.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Create_object {
    @JsonProperty("name")
    private String name;

    @JsonProperty("data")
    private Data data;

    // Getters and Setters for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getters and Setters for data
    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    // Inner class Data
    public static class Data {

        @JsonProperty("year")
        private int year;

        @JsonProperty("price")
        private double price;

        @JsonProperty("CPU model")
        private String cpuModel;

        @JsonProperty("Hard disk size")
        private String hardDiskSize;

        // Getters and Setters for year
        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        // Getters and Setters for price
        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        // Getters and Setters for cpuModel
        public String getCpuModel() {
            return cpuModel;
        }

        public void setCpuModel(String cpuModel) {
            this.cpuModel = cpuModel;
        }

        // Getters and Setters for hardDiskSize
        public String getHardDiskSize() {
            return hardDiskSize;
        }

        public void setHardDiskSize(String hardDiskSize) {
            this.hardDiskSize = hardDiskSize;
        }


        @Override
        public String toString() {
            return "Data{" +
                    "year=" + year +
                    ", price=" + price +
                    ", cpuModel='" + cpuModel + '\'' +
                    ", hardDiskSize='" + hardDiskSize + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Create_object{" +
                "name='" + name + '\'' +
                ", data=" + data +
                '}';
    }
}
