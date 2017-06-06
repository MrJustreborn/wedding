/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mjrb.wedding.api;

import java.util.ArrayList;
import java.util.Objects;


/**
 *
 * @author mrjustreborn
 */
public class UpdateAnswers {
    private ArrayList<String> answers;
    private String question;
    private String newAnswer;

    public UpdateAnswers() {
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String id) {
        this.question = id;
    }

    public String getNewAnswer() {
        return newAnswer;
    }

    public void setNewAnswer(String newAnswer) {
        this.newAnswer = newAnswer;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UpdateAnswers other = (UpdateAnswers) obj;
        if (!Objects.equals(this.question, other.question)) {
            return false;
        }
        if (!Objects.equals(this.newAnswer, other.newAnswer)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.question);
        hash = 23 * hash + Objects.hashCode(this.newAnswer);
        return hash;
    }


}
