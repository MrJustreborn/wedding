/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mjrb.wedding.api;

import java.util.Objects;

/**
 *
 * @author mrjustreborn
 */
public class Answer {
    private String answer;
    private int total;

    public Answer(String answer) {
        this.answer = answer;
        this.total = 1;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.answer);
        return hash;
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
        final Answer other = (Answer) obj;
        if (!Objects.equals(this.answer, other.answer)) {
            return false;
        }
        return true;
    }

    public void incTotal() {
        this.total+=1;
    }
}
