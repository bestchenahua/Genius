package cqdz.com.genius.home.wode.model;

import java.util.List;

import cqdz.com.genius.http.GeniusResponse;

public class ShoppingCartModel {
    public static class Response extends GeniusResponse
    {
        public static class Data
        {
            String name;
            List<Child> childList;

            public boolean isAll() {
                return isAll;
            }

            public void setAll(boolean all) {
                isAll = all;
            }

            boolean isAll = false;
            public List<Child> getChildList() {
                return childList;
            }

            public void setChildList(List<Child> childList) {
                this.childList = childList;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public static class Child
            {
                String img;
                String name;
                String introduction;
                String price;

                public boolean isCheck() {
                    return isCheck;
                }

                public void setCheck(boolean check) {
                    isCheck = check;
                }

                boolean isCheck=false;
                int num;

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

                public String getIntroduction() {
                    return introduction;
                }

                public void setIntroduction(String introduction) {
                    this.introduction = introduction;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public int getNum() {
                    return num;
                }

                public void setNum(int num) {
                    this.num = num;
                }
            }
        }
    }
}
