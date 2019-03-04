package cqdz.com.genius.home.model;

import java.util.List;

import cqdz.com.genius.http.GeniusResponse;

public class AddressModel {
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
            String name;
            String tel;
            String addr;
            String isDefault;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getIsDefault() {
                return isDefault;
            }

            public void setIsDefault(String isDefault) {
                this.isDefault = isDefault;
            }
        }
    }
}
