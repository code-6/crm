package vaadin.crm.frontend;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import vaadin.crm.backend.jpa.pojos.School;

@Route(value = "students", layout = MainLayout.class)
public class StudentsListView extends VerticalLayout {
    private Grid studentsTable = new Grid();

    public StudentsListView(School school) {
        studentsTable.setItems(school.getStudents());
        add(studentsTable);
    }
}
