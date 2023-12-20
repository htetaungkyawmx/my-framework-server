package org.example.framework.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.framework.ds.ModelAndView;

public interface IController {
    ModelAndView handleRequest(HttpServletRequest request);


}
