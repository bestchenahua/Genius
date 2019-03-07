package cqdz.com.genius.home.wode.model;

import java.util.List;

import cqdz.com.genius.http.GeniusResponse;

public class ErrorSubjectModel {
    public static class Response extends GeniusResponse {
        List<ErrorSubjectModel.Response.Data> data;

        public List<ErrorSubjectModel.Response.Data> getData() {
            return data;
        }

        public void setData(List<ErrorSubjectModel.Response.Data> data) {
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

            public List<Options> getOptions() {
                return options;
            }

            public void setOptions(List<Options> options) {
                this.options = options;
            }

            List<Options> options;

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

            public static class Options
            {
                String item;
                String option;

                public String getOption() {
                    return option;
                }

                public void setOption(String option) {
                    this.option = option;
                }

                int isRirht = 0;

                public String getItem() {
                    return item;
                }

                public void setItem(String item) {
                    this.item = item;
                }

                public int getIsRirht() {
                    return isRirht;
                }

                public void setIsRirht(int isRirht) {
                    this.isRirht = isRirht;
                }
            }
        }
    }
}
