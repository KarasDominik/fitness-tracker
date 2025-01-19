package karas.dominik.fitnesstracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.modulith.Modulithic;

@Modulithic(
		sharedModules = "common"
)
@SpringBootApplication
public class FitnesstrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitnesstrackerApplication.class, args);
	}

}
