package cqdz.com.genius.home.model;

import java.util.List;

import cqdz.com.genius.http.GeniusResponse;

public class PriveteLetterModel {
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
            public String img;
            public String comtent;
            public String name;
            public String time;
            public String num;

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getComtent() {
                return comtent;
            }

            public void setComtent(String comtent) {
                this.comtent = comtent;
            }

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

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
            }
        }
    }
}
