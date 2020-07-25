import com.pluralsight.model.Speaker;
import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>
 *     Spring Fundamentals course in Pluralsight by Bryan Hanson. 
 * </p>
 * <p>
 *     Course URL: https://app.pluralsight.com/library/courses/spring-framework-spring-fundamentals/
 * </p>
 */
public class Application {

    public static void main(String[] args) {
        System.out.println("Conference Java : ");

        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

        //SpeakerService service = new SpeakerServiceImpl();
        SpeakerService service = appContext.getBean("speakerService", SpeakerService.class);
        System.out.println("service Instance : " + service);

        //System.out.println(service.findAll().get(0).getFirstName());
        //System.out.println(service.findAll().get(0));

        Speaker speaker = service.findAll().get(0);
        System.out.println("Speaker Name : " + speaker.getFirstName());
        System.out.println("Speaker : " + speaker);
        System.out.println("Speaker SeedNum : " + speaker.getSeedNum());

        /*System.out.println("---------------------------------------");
        SpeakerService service2 = appContext.getBean("speakerService", SpeakerService.class);
        System.out.println("service2 Instance : " + service2);*/
    }
}
