package vaadin.crm.frontend;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "schools", layout = MainLayout.class)
public class SchoolsListView extends VerticalLayout {
    public SchoolsListView() {
        add(new H1("schools list"));
    }
}
