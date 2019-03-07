package cqdz.com.genius.home.wode.model;

import java.util.List;

import cqdz.com.genius.http.GeniusResponse;

public class LeaningBeansModel {
    public static class Response extends GeniusResponse
    {
        public List<LeaningBeansModel.Response.Data> data;

        public List<LeaningBeansModel.Response.Data> getData() {
            return data;
        }

        public void setData(List<LeaningBeansModel.Response.Data> data) {
            this.data = data;
        }

        public static class Data
        {
            String name;
            String date;
            String money;
            int type=0;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
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
