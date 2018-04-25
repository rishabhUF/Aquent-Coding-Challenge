package rishabh.AquentCodingChallenge;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"Controller", "DataProcessing", "Service", "Repository" ,"Entity"})
@SpringBootApplication
public class AquentCodingChallengeApplication{

	public static void main(String[] args) {
		SpringApplication.run(AquentCodingChallengeApplication.class, args);
	}
}
