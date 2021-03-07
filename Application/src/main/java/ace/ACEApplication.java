package ace;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 *  Main class for starting program
 */
@SpringBootApplication
public class ACEApplication {
    /**
     * @param args additional arguments for program, none is expected
     */
    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(ACEApplication.class);
        builder.headless(false);
        builder.run(args);
    }
}
