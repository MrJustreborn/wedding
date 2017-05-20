/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mjrb.wedding.core;

import io.dropwizard.hibernate.AbstractDAO;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author mrjustreborn
 */
public class SurveyDAO extends AbstractDAO<Survey> {

    public SurveyDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Survey findById(Long id) {
        Survey surv = get(id);
        
        return surv;
    }

    public long create(Survey surv) {
        return persist(surv).getIdsurvey();
    }

    public List<Survey> findAll() {
        return list(namedQuery("Survey.findAll"));
    }
    
    public List<Survey> findId(String id) {
        return list(namedQuery("Survey.findById").setParameter("id", id));
    }
    
    public void delete(Long id) {
        Survey surv = findById(id);
        
        currentSession().delete(surv);
    }
    
    public void update(Survey surv) {
        currentSession().merge(surv);
    }
}
