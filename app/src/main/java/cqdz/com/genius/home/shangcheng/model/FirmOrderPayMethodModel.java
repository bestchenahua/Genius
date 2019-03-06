package cqdz.com.genius.home.shangcheng.model;

import java.util.List;

import cqdz.com.genius.http.GeniusResponse;

public class FirmOrderPayMethodModel {
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
            String name="";

            String img;

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
        }
    }
}
