/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mjrb.wedding.resources;

import de.mjrb.wedding.api.Answer;
import de.mjrb.wedding.api.Answers;
import de.mjrb.wedding.api.view.Overview;
import de.mjrb.wedding.api.view.Survey;
import de.mjrb.wedding.api.view.Update;
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
@Path("/")
@Produces(MediaType.TEXT_HTML)
public class HtmlResource {

    private final SurveyDAO dao;

    public HtmlResource(SurveyDAO dao) {
        this.dao = dao;
    }

    @GET
    public Survey getSurvey() {
        return new Survey();
    }

    @GET
    @Path("update")
    public Update getUpdateSurvey() {
        return new Update();
    }
    
    @GET
    @Path("overview")
    public Overview getOverviewSurvey() {
        return new Overview();
    }
}
