package securepage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserFileReader userFileReader;

    @Override
    public void init() {
        userFileReader = new UserFileReader();
        System.out.println("Login Servlet initialized");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("Login attempt for user: " + username);

        // Authenticate user
        User user = userFileReader.authenticate(username, password);

        if (user != null) {

            // SUCCESS: Create session and store user
            HttpSession session = request.getSession(true);
            session.setAttribute("user", username);


            System.out.println("Login successful for: " + username);
            System.out.println("Session ID: " + session.getId());

            // Redirect to welcome page (secured area)
            response.sendRedirect("welcome");
        } else {
            // FAILURE: Show error
            System.out.println("Login failed for: " + username);
            request.setAttribute("error", "Invalid username or password");
            request.getRequestDispatcher("/login.html").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirect to login page
        response.sendRedirect("login.html");
    }
}
