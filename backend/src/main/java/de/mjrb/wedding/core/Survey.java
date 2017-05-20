/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mjrb.wedding.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mrjustreborn
 */
@Entity
@Table(name = "survey")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Survey.findAll", query = "SELECT s FROM Survey s")
    , @NamedQuery(name = "Survey.findByIdsurvey", query = "SELECT s FROM Survey s WHERE s.idsurvey = :idsurvey")
    , @NamedQuery(name = "Survey.findById", query = "SELECT s FROM Survey s WHERE s.id = :id")
    , @NamedQuery(name = "Survey.findByTitle", query = "SELECT s FROM Survey s WHERE s.title = :title")
    , @NamedQuery(name = "Survey.findByAnswer", query = "SELECT s FROM Survey s WHERE s.answer = :answer")})
public class Survey implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idsurvey")
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idsurvey;
    @Size(max = 2000000000)
    @Column(name = "id")
    private String id;
    @Size(max = 2000000000)
    @Column(name = "title")
    private String title;
    @Size(max = 2000000000)
    @Column(name = "answer")
    private String answer;

    public Survey() {
    }

    public Survey(Integer idsurvey) {
        this.idsurvey = idsurvey;
    }

    public Integer getIdsurvey() {
        return idsurvey;
    }

    public void setIdsurvey(Integer idsurvey) {
        this.idsurvey = idsurvey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsurvey != null ? idsurvey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Survey)) {
            return false;
        }
        Survey other = (Survey) object;
        if ((this.idsurvey == null && other.idsurvey != null) || (this.idsurvey != null && !this.idsurvey.equals(other.idsurvey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.mjrb.wedding.core.Survey[ idsurvey=" + idsurvey + " ]";
    }
    
}
