package cqdz.com.genius.home.wode.model;

import java.util.List;

import cqdz.com.genius.http.GeniusResponse;

public class LotteryModel {
    public static class Response extends GeniusResponse
    {
        public List<LotteryModel.Response.Data> data;

        public List<LotteryModel.Response.Data> getData() {
            return data;
        }

        public void setData(List<LotteryModel.Response.Data> data) {
            this.data = data;
        }

        public static class Data
        {
            String name;
            String time;
            String money;
            int type=0;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
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
