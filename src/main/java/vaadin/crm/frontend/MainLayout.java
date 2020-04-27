package vaadin.crm.frontend;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout {
    public MainLayout() {
        initHeader();
    }

    private void initHeader() {
        var home = new Tab();
        var studentsList = new Tab();
        var schoolList = new Tab();

        home.add(new RouterLink("Home", HomeView.class));
        studentsList.add(new RouterLink("Students", StudentsListView.class));
        schoolList.add(new RouterLink("Schools", SchoolsListView.class));

        var tabs = new Tabs(home, studentsList, schoolList);
        addToNavbar(tabs);

    }
}
