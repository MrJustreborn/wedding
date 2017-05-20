/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mjrb.wedding.resources;

import de.mjrb.wedding.api.Answer;
import de.mjrb.wedding.api.Answers;
import de.mjrb.wedding.core.Survey;
import de.mjrb.wedding.core.SurveyDAO;
import io.dropwizard.hibernate.UnitOfWork;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author René Lottes
 */
@Path("/survey")
@Produces(MediaType.APPLICATION_JSON)
public class SurveyResource {

    private final SurveyDAO dao;

    public SurveyResource(SurveyDAO dao) {
        this.dao = dao;
    }

    @POST
    @UnitOfWork
    public Response addSurvey(Survey[] survey) {
//        System.out.println(Arrays.toString(survey));

        for (Survey s : survey) {
            try {
                dao.create(s);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return Response.ok().build();
    }

    @GET
    @UnitOfWork
    public Response getSurvey() {

        List<Survey> d = dao.findAll();

        return Response.ok(d).build();
    }

    @GET
    @Path("sum")
    @UnitOfWork
    public Response getSumSurvey() {

        List<Survey> allSurveys = dao.findAll();

        ArrayList<String> ids = new ArrayList<>();

        allSurveys.stream().filter((s) -> (!ids.contains(s.getId()))).forEachOrdered((s) -> {
            ids.add(s.getId());
        });

//        Collections.reverse(ids);

        ArrayList<Answers> answers = new ArrayList<>();

        for (String id : ids) {
            for (Survey s : allSurveys) {
                if (s.getId().equals(id)) {

                    Answers a = new Answers(id, s.getTitle());
                    if (!answers.contains(a)) {
                        answers.add(a);
                    } //else {
                        ArrayList<Answer> arr = answers.get(answers.indexOf(a)).getAnswer();

                        Answer anw = new Answer(s.getAnswer());
                        if (!arr.contains(anw)) {
                            arr.add(anw);
                        } else {
                            arr.get(arr.indexOf(anw)).incTotal();
                        }
                    //}

                }
            }
            
            ArrayList<Answer> arr = answers.get(answers.size() - 1).getAnswer();
            
            arr.sort(new Comparator<Answer>() {
                @Override
                public int compare(Answer t, Answer t1) {
                    return t1.getTotal() - t.getTotal();
                }
            });
        }

//        answers.sort(new Comparator<Answers>() {
//            @Override
//            public int compare(Answers t, Answers t1) {
//                return t1.getTotal() - t.getTotal();
//            }
//        });
        return Response.ok(answers).build();
    }
}
