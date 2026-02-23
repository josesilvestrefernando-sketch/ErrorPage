package securepage;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

      
       String user = session.getAttribute("user").toString();



        System.out.println("WelcomeServlet - User from session: " + user);


        // Set attributes for JSP
        request.setAttribute("sessionUser", user);

        // Forward to welcome page
        request.getRequestDispatcher("/welcome.jsp").forward(request, response);
    }
}