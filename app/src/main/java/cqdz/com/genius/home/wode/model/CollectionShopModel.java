package cqdz.com.genius.home.wode.model;


import cqdz.com.genius.http.GeniusResponse;

public class CollectionShopModel {
    public static class Response extends GeniusResponse
    {
        public static class Data
        {
            String img;
            String title;

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
