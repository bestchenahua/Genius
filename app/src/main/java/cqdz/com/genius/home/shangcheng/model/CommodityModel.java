package cqdz.com.genius.home.shangcheng.model;

import java.util.List;

import cqdz.com.genius.http.GeniusResponse;

/**
 * 商品model
 */
public class CommodityModel {
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
            String introduction="";
            String price= "";
            String num = "";
            String img = "";

            public String getIntroduction() {
                return introduction;
            }

            public void setIntroduction(String introduction) {
                this.introduction = introduction;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }
        }
    }
}
