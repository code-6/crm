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
        var page1 = new Tab();
        var page2 = new Tab("Page 2");

        home.add(new RouterLink("Home", HomeView.class));
        page1.add(new RouterLink("Page 1",Page1View.class));

        var tabs = new Tabs(home, page1, page2);
        addToNavbar(tabs);

    }
}
