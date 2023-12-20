package org.example.application.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.application.view.AddNumberView;
import org.example.framework.controller.ControllerMapping;
import org.example.framework.controller.IController;
import org.example.framework.ds.ModelAndView;
import org.example.framework.model.SimpleModel;

@ControllerMapping("/add-numbers")
public class AddNumberController implements IController {

    // ?num1 = 5 & num2 = 7
    @Override
    public ModelAndView handleRequest(HttpServletRequest request) {
        var simpleModel = new SimpleModel();
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));

        simpleModel.set("num1", String.valueOf(num1));
        simpleModel.set("num2", String.valueOf(num2));

        simpleModel.set("result", String.valueOf(num1 + num2));

        return new ModelAndView(simpleModel,
                new AddNumberView());
    }
}
