package cqdz.com.genius.home.wode.model;


import cqdz.com.genius.http.GeniusResponse;

public class CollectionCommodityModel {
    public static class Response extends GeniusResponse
    {
        public static class Data
        {
            String img;
            String title;
            String colloction;

            public String getColloction() {
                return colloction;
            }

            public void setColloction(String colloction) {
                this.colloction = colloction;
            }

            public String getPrice() {

                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            String price;
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
