package org.example.framework.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.framework.controller.IController;
import org.example.framework.ds.ModelAndView;
import org.example.framework.model.Model;
import org.example.framework.util.ApplicationControllersFinder;
import org.example.framework.view.View;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "framework-servlet",urlPatterns = "/*")
public class FrameworkHttpServlet extends HttpServlet {

    private Map<String, IController> controllerMap;

    //add-numbers,AddNumberController

    @Override
    public void init() {
        controllerMap = new ApplicationControllersFinder().findControllers();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestUri = req.getRequestURI();;
        IController controller = controllerMap.get(requestUri); //add-numbers = uri
        if (controller != null) {
            ModelAndView modelAndView = controller.handleRequest(req);
            Model model = modelAndView.getModel();
            View view = modelAndView.getView();

            String renderedView = view.render(model);

            resp.setContentType("text/html");
            resp.getWriter().println(renderedView);
        }
        else
            throw new ServletException(
                    String.format("Unable to find Controller Class for this %s uri",
                            requestUri)
            );
    }


}
