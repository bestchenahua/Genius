package cqdz.com.genius.home.shangcheng.model;

import java.util.List;

public class ShoppingClassifyBean {

    public String id;//一级菜单id
    public String typeName;//	一级菜单名称
    public List<ShoppingMenuBean> data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<ShoppingMenuBean> getData() {
        return data;
    }

    public void setData(List<ShoppingMenuBean> data) {
        this.data = data;
    }

    public static class ShoppingMenuBean {
        public String id;//二级菜单编号
        public String img;//二级菜单图标
        public String typeName;//二级菜单名称

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }
    }
}
