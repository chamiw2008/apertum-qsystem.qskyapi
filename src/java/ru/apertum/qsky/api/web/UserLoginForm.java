package ru.apertum.qsky.api.web;

import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;

public class UserLoginForm {

    private User user = new User();

   

    public User getUser() {
        final User cl = (User) Sessions.getCurrent().getAttribute("DATA");
        if (cl != null) {
            user = cl;
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Command
    public void submit() {
        try {
            Sessions.getCurrent().setAttribute("DATA", user);
            //Executions.sendRedirect("/selectService");
            Executions.sendRedirect("/inputParams.zul");
        } catch (Throwable t) {
            System.err.println("Server SOO is down! " + t);
            Executions.sendRedirect("/error.zul");
        }
    }
}
