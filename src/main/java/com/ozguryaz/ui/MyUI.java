package com.ozguryaz.ui;

import javax.servlet.annotation.WebServlet;

import com.ozguryaz.core.domain.Film;
import com.ozguryaz.ui.page.ContentComponent;
import com.ozguryaz.ui.page.UserLogin;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@Widgetset("com.ozguryaz.MyAppWidgetset")
public class MyUI extends UI {

    public VerticalLayout getMainLayout() {
        return mainLayout;
    }

    public void setMainLayout(VerticalLayout mainLayout) {
        this.mainLayout = mainLayout;
    }

    private VerticalLayout mainLayout;
    private ContentComponent contentComponent;
    private Film film;
    private UserLogin userLogin;
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        buildMainLayout();
        setContent(mainLayout);

    }

    public ContentComponent getContentComponent() {
        return contentComponent;
    }

    public void setContentComponent(ContentComponent contentComponent) {
        this.contentComponent = contentComponent;
    }

    private void buildMainLayout() {
        mainLayout = new VerticalLayout();
        contentComponent = new ContentComponent();
        userLogin= new UserLogin("ilkGiris");
        mainLayout.addComponent(userLogin);
        mainLayout.setSizeFull();
        mainLayout.setComponentAlignment(userLogin, Alignment.MIDDLE_CENTER);


    }
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
