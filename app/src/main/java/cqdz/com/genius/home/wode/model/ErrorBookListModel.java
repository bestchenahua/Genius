package cqdz.com.genius.home.wode.model;


import cqdz.com.genius.http.GeniusResponse;

public class ErrorBookListModel {
    public static class Response extends GeniusResponse
    {
        public static class Data
        {
            String content;
            String num;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
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
