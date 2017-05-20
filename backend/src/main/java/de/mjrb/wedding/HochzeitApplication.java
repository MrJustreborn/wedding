package de.mjrb.wedding;

import de.mjrb.wedding.core.Survey;
import de.mjrb.wedding.core.SurveyDAO;
import de.mjrb.wedding.resources.SurveyResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import java.util.EnumSet;
import javax.servlet.DispatcherType;

public class HochzeitApplication extends Application<HochzeitConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HochzeitApplication().run(args);
    }

    private final HibernateBundle<HochzeitConfiguration> hibernate = new HibernateBundle<HochzeitConfiguration>(Survey.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(HochzeitConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    @Override
    public String getName() {
        return "HochzeitFragen";
    }

    @Override
    public void initialize(final Bootstrap<HochzeitConfiguration> bootstrap) {
        bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(final HochzeitConfiguration configuration,
            final Environment environment) {

        final SurveyDAO dao = new SurveyDAO(hibernate.getSessionFactory());

        environment.servlets()
            .addFilter("cors", new CORSFilter())
            .addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), false, "/*");
        
        environment.jersey().register(new SurveyResource(dao));
    }

}
