package cqdz.com.genius.home.wode.model;

import cqdz.com.genius.http.GeniusResponse;

public class MyCurriculumModel {
    public static class Response extends GeniusResponse
    {
        public static class Data
        {
            String img;
            String title;
            String name;
            String num;
            String price;
            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }
        }
    }
}
