package org.example.application.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.application.view.SquareNumberView;
import org.example.framework.controller.ControllerMapping;
import org.example.framework.controller.IController;
import org.example.framework.ds.ModelAndView;
import org.example.framework.model.SimpleModel;

@ControllerMapping("/square-number")
public class SquareNumberController implements IController {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request) {
        var simpleModel = new SimpleModel();
        int num = Integer.parseInt(request.getParameter("num"));
        simpleModel.set("num", String.valueOf(num));
        simpleModel.set("result", String.valueOf(num * num));

        return new ModelAndView(simpleModel,
                new SquareNumberView());
    }
}
