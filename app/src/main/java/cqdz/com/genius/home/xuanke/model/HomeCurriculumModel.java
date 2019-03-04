package cqdz.com.genius.home.xuanke.model;

import java.util.ArrayList;
import java.util.List;

import cqdz.com.genius.http.GeniusResponse;

public class HomeCurriculumModel {
    public static class Response extends GeniusResponse
    {
        public List<Data> data;

        public List<Data> getData() {
            return data;
        }

        public void setData(List<Data> data) {
            this.data = data;
        }

        public static class Data
        {

            String img;
            String name;
            String price;
            String unit;
            String state;
            String content;

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }
    }
}
