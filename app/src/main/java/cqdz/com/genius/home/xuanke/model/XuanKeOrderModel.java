package cqdz.com.genius.home.xuanke.model;
import cqdz.com.genius.http.GeniusResponse;

public class XuanKeOrderModel {

    public static class Response extends GeniusResponse
    {
        public static class Data
        {
            String title;
            String time;
            String price;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
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
