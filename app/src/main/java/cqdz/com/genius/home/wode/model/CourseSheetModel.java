package cqdz.com.genius.home.wode.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import cqdz.com.genius.http.GeniusResponse;

public class CourseSheetModel {
    public static class Response extends GeniusResponse
    {
        public static class Data implements MultiItemEntity
        {
            String img;
            String title;
            String name;
            String num;
            String price;

            public boolean isChecked() {
                return isChecked;
            }

            public void setChecked(boolean checked) {
                isChecked = checked;
            }

            boolean isChecked = true;
            int valid = 0;

            public int getValid() {
                return valid;
            }

            public void setValid(int valid) {
                this.valid = valid;
            }

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

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            @Override
            public int getItemType() {
                return valid;
            }
        }
    }
}
