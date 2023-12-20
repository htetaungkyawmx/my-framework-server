package org.example.application.view;

import org.example.framework.model.Model;
import org.example.framework.view.View;

public class SquareNumberView implements View {
    @Override
    public String render(Model model) {
        return String.format("square of [%s] equals to [%s]",
                model.get("num"), model.get("result"));
    }
}
