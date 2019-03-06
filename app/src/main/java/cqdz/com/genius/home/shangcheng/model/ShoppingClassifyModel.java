package cqdz.com.genius.home.shangcheng.model;

import java.util.List;

import cqdz.com.genius.home.model.AddressModel;
import cqdz.com.genius.http.GeniusResponse;

public class ShoppingClassifyModel {
    public static class Response extends GeniusResponse
    {
        public AddressModel.Response.Data getData() {
            return data;
        }

        public void setData(AddressModel.Response.Data data) {
            this.data = data;
        }

        public AddressModel.Response.Data data;

        public static class Data
        {
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
                public String img;//图片
                public String name;//名称
                public String price;//价格
                public String purchased;//已购买人数

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

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public String getPurchased() {
                    return purchased;
                }

                public void setPurchased(String purchased) {
                    this.purchased = purchased;
                }
            }
        }
    }

}
