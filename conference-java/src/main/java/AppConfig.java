import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;
import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import com.pluralsight.util.CalendarFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Calendar;

@Configuration
@ComponentScan({"com.pluralsight"})
public class AppConfig {

    @Bean(name="cal")
    public CalendarFactory calFactory() {
        System.out.println("AppConfig - calFactory() method called to return a new CalendarFactory " +
                "with a date manipulation of 2 days");
        CalendarFactory factory = new CalendarFactory();
        factory.addDays(2);
        return factory;
    }

    @Bean
    public Calendar cal() throws Exception {
        System.out.println("AppConfig - cal() method called that returns the object of type Calendar");
        return calFactory().getObject();
    }

    /*
    @Bean(name = "speakerService")
    //@Scope(BeanDefinition.SCOPE_PROTOTYPE)
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public SpeakerService getSpeakerService()  {
        System.out.println("AppConfig - getSpeakerService() invoked");
        SpeakerServiceImpl service = new SpeakerServiceImpl();
        //service.setRepository(getSpeakerRepository());
       // SpeakerServiceImpl service = new SpeakerServiceImpl(getSpeakerRepository());
        return service;
    }

    @Bean(name = "speakerRepository")
    public SpeakerRepository getSpeakerRepository() {
        System.out.println("AppConfig - getSpeakerRepository() invoked");
        return new HibernateSpeakerRepositoryImpl();
    }
     */
}
