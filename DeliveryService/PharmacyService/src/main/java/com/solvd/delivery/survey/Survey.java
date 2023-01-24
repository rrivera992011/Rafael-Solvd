package com.solvd.delivery.survey;


import java.util.List;

public class Survey implements ISurvey {
    private List<Integer> answerList;

    public List<Integer> getAnswerList() {
        return this.answerList;
    }

    public void setAnswerList(List<Integer> answerList) {
        this.answerList = answerList;
    }


}
