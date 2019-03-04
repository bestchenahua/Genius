package cqdz.com.genius.home.xuanke.model;


import cqdz.com.genius.http.GeniusResponse;

public class DaGangModel {
    public static class Response extends GeniusResponse {
        public static class Data {
            String day;
            String name;
            String date;
            String btn ;

            public String getBtn() {
                return btn;
            }

            public void setBtn(String btn) {
                this.btn = btn;
            }

            public String getDay() {
                return day;
            }

            public void setDay(String day) {
                this.day = day;
            }

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
        }
    }
}
