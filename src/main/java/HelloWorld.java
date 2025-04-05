import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import spark.Response;
import spark.servlet.SparkApplication;

import static spark.Spark.get;


public class HelloWorld implements SparkApplication {
    private static final Logger logger = LogManager.getLogger(SparkApplication.class);
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            // Log an INFO message
            logger.info("Processing GET request for /hello");

            // Respond to the client
            response.setContentType("text/html");
            response.getWriter().write("<h1>Hello from Log4j2!</h1>");

            // Log a DEBUG message
            logger.debug("Response successfully sent to the client");
        }        

	@Override
	public void init() {
		get("/hello", (req, res) -> "Hello World");
        // Log an INFO message
			logger.info("Deployed app");
			logger.info("please check with  sparkjava-war-example-master/hello/hello last");
	}

}
