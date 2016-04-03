import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@ComponentScan
@EnableAutoConfiguration
@Controller
public class Application {

    @RequestMapping("")
    @ResponseBody
    public String index() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("D:\\site\\file.txt"));
        String html = "";

        while (scanner.hasNextLine()) {
            html += scanner.nextLine();
        }

        return html;
    }

    @RequestMapping("/home")
    @ResponseBody
    public String homePage() {
        String html = "<a href=\"/\">Got to index</a>";
        return html;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}