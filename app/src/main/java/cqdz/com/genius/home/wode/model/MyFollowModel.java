package cqdz.com.genius.home.wode.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import cqdz.com.genius.http.GeniusResponse;

public class MyFollowModel {
    public static class Response extends GeniusResponse
    {
        public static class Data
        {
            String img;
            String name;

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

            public String getIsFollow() {
                return isFollow;
            }

            public void setIsFollow(String isFollow) {
                this.isFollow = isFollow;
            }

            String isFollow;
        }
    }
}
