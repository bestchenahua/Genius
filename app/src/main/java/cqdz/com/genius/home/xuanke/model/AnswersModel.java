package cqdz.com.genius.home.xuanke.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cqdz.com.genius.http.GeniusRequest;
import cqdz.com.genius.http.GeniusResponse;

public class AnswersModel {
    public static class Response extends GeniusResponse {

    }
    public static class Request extends GeniusRequest  implements Serializable
    {
        List<Answer> answers;

        public List<Answer> getAnswers() {
            return answers;
        }

        public void setAnswers(List<Answer> answers) {
            this.answers = answers;
        }

        public static class Answer  implements Serializable
        {
            public static class Item  implements Serializable
            {
                String option;
                String answer = "false";

                public String getOption() {
                    return option;
                }

                public void setOption(String option) {
                    this.option = option;
                }

                public String getAnswer() {
                    return answer;
                }

                public void setAnswer(String answer) {
                    this.answer = answer;
                }
            }
            int serial=-1;
            String answer;
            String type;
            List<Item> options = new ArrayList<>();

            public int getSerial() {
                return serial;
            }

            public void setSerial(int serial) {
                this.serial = serial;
            }

            public String getAnswer() {
                return answer;
            }

            public void setAnswer(String answer) {
                this.answer = answer;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<Item> getAnswers() {
                return options;
            }

            public void setAnswers(List<Item> answers) {
                this.options = answers;
            }
        }
    }
}
