package cqdz.com.genius.home.xuanke.model;


import java.util.List;

import cqdz.com.genius.http.GeniusResponse;

public class SubjectModel {
    public static class Response extends GeniusResponse {
        List<Data> data;

        public List<Data> getData() {
            return data;
        }

        public void setData(List<Data> data) {
            this.data = data;
        }

        public static class Data {
            int serial;

            public int getSerial() {
                return serial;
            }

            public void setSerial(int serial) {
                this.serial = serial;
            }

            String subject;
            String type;
            List<String> options;

            public String getSubject() {
                return subject;
            }

            public void setSubject(String subject) {
                this.subject = subject;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<String> getOptions() {
                return options;
            }

            public void setOptions(List<String> options) {
                this.options = options;
            }
        }
    }
}
