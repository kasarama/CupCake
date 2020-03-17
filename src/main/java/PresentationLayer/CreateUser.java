package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//Register Class changed to CreateUser class
//TODO:
// 1. seperate the login and create user page - each one should be on a page and should communnicate together.
// 2. create an error message that redirects to create user page if wrong password/email.

public class CreateUser extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        if (password1.equals(password2)) {
            User user = LogicFacade.createUser(email, password1);
            HttpSession session = request.getSession();

            session.setAttribute("email", email);
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());
            return user.getRole() + "page";
        } else {
            throw new LoginSampleException("the two passwords did not match");
        }
    }
}


