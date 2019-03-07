package cqdz.com.genius.home.wode.model;

import java.util.List;

import cqdz.com.genius.http.GeniusResponse;

public class Currency2Model {
    public static class Response extends GeniusResponse
    {
        public List<Currency2Model.Response.Data> data;

        public List<Currency2Model.Response.Data> getData() {
            return data;
        }

        public void setData(List<Currency2Model.Response.Data> data) {
            this.data = data;
        }

        public static class Data
        {
            String name;
            String img;
            String money;
            int type=0;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getMoney() {
                return money;
            }

            public void setMoney(String money) {
                this.money = money;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }
    }
}
