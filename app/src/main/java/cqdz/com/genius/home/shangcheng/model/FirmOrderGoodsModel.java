package cqdz.com.genius.home.shangcheng.model;

import java.util.List;

import cqdz.com.genius.http.GeniusResponse;

public class FirmOrderGoodsModel {
    public static class Response extends GeniusResponse
    {
        public List<Data> getData() {
            return data;
        }

        public void setData(List<Data> data) {
            this.data = data;
        }

        public List<Data> data;
        public static class Data
        {
            String name="";
            String model="";
            String color="";
            String price="";
            String img;
            String num;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getModel() {
                return model;
            }

            public void setModel(String model) {
                this.model = model;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
            }
        }
    }
}
