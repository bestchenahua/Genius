package cqdz.com.genius.home.model;

import java.util.ArrayList;
import java.util.List;

import cqdz.com.genius.http.GeniusResponse;

public class TeachExpModel {
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
            public String date;
            public String experience;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getExperience() {
                return experience;
            }

            public void setExperience(String experience) {
                this.experience = experience;
            }
        }
    }
}
