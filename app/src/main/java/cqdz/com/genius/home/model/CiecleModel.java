package cqdz.com.genius.home.model;

import java.util.ArrayList;
import java.util.List;

import cqdz.com.genius.http.GeniusResponse;

public class CiecleModel {
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
            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
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

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public ArrayList<String> getImgs() {
                return imgs;
            }

            public void setImgs(ArrayList<String> imgs) {
                this.imgs = imgs;
            }

            public String getIsZan() {
                return isZan;
            }

            public void setIsZan(String isZan) {
                this.isZan = isZan;
            }

            public String getZanNum() {
                return zanNum;
            }

            public void setZanNum(String zanNum) {
                this.zanNum = zanNum;
            }

            public String getLiuyNum() {
                return liuyNum;
            }

            public void setLiuyNum(String liuyNum) {
                this.liuyNum = liuyNum;
            }

            String img;
            String name;
            String date;
            String title;
            String content;
            ArrayList<String> imgs;
            String isZan;
            String zanNum;
            String liuyNum;
        }
    }
}
