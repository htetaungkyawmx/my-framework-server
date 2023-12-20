package org.example.application.view;

import org.example.framework.model.Model;
import org.example.framework.view.View;

public class AddNumberView implements View {

    @Override
    public String render(Model model) {

        return String.format("num1 = [%s] add num2 = [%s] equals to [%s]",
                model.get("num1"), model.get("num2"), model.get("result"));
    }
}
