package vaadin.crm.frontend;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import javax.validation.GroupSequence;

@Route(value = "page1", layout = MainLayout.class)
public class Page1View extends VerticalLayout {
    public Page1View() {
        add(new H1("This is PAGE #1"));
    }
}
