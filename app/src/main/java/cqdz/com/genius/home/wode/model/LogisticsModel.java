package cqdz.com.genius.home.wode.model;


import cqdz.com.genius.http.GeniusResponse;

public class LogisticsModel {
    public static class Response extends GeniusResponse
    {
        public static class Data
        {
            String content;
            String time;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }
        }
    }
}
