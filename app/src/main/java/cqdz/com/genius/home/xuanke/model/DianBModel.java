package cqdz.com.genius.home.xuanke.model;

import java.util.List;

import cqdz.com.genius.http.GeniusResponse;

public class DianBModel {
    public static class Response extends GeniusResponse {
        public Data data;

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }

        public static class Data {
            String name;
            String img;
            String introduction;
            String grade;
            List<Child> childList;

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

            public String getIntroduction() {
                return introduction;
            }

            public void setIntroduction(String introduction) {
                this.introduction = introduction;
            }

            public String getGrade() {
                return grade;
            }

            public void setGrade(String grade) {
                this.grade = grade;
            }

            public List<Child> getChildList() {
                return childList;
            }

            public void setChildList(List<Child> childList) {
                this.childList = childList;
            }

            public static class Child
            {
                String name;
                List<Item> items;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public List<Item> getItems() {
                    return items;
                }

                public void setItems(List<Item> items) {
                    this.items = items;
                }

                public static class Item
                {
                    String name;

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }
                }
            }
        }
    }
}
