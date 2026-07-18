package com.springboot.servlet.Servlets;

import com.springboot.servlet.Model.User;
import com.springboot.servlet.Services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private final UserService userService= new UserService();


    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {

        String idParam = req.getParameter("id");
    //Case:1---If GetAll
        if(idParam==null){
            List<User> usersresp = userService.getAllUsers();
            resp.setStatus(200);
            resp.setContentType("application/json");
            resp.getWriter().write(usersToJson(usersresp));
            return;
        }
    //case:2---If Get User by id
        Integer id = Integer.parseInt(idParam);

        User userResp = userService.getUserById(id);

        if(userResp==null){
            resp.setStatus(404);
            resp.setContentType("application/json");
            return;
        }

        resp.setStatus(200);
        resp.setContentType("application/json");
        resp.getWriter().write(userToJson(userResp));


    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {

        Integer id =Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        Integer number = Integer.parseInt(req.getParameter("number"));

        if(id==null || name==null ||email==null || number==null){
            resp.setStatus(400);
            resp.setContentType("application/json");
            resp.getWriter().write(
                    """
                            {
                            "message" :"Some fields are missing "
                            }"""
            );
        }

        User createdUser = new User(id,name,email,number);
        User user = userService.createUser(createdUser);

        resp.setStatus(201);
        resp.setContentType("application/json");
        resp.getWriter().write("""
                            {
                            "message" :"Data added successfully"
                            }""");
    }

    @Override
    protected void doPut(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        Integer Id = Integer.parseInt(req.getParameter("id"));

        User user = userService.getUserById(Id);

        if(user==null){
            resp.setStatus(404);
            resp.setContentType("application/json");
        }

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        Integer number = Integer.parseInt(req.getParameter("number"));

        User user2 = new User(Id,name,email,number);
        userService.createUser(user2);

        resp.setStatus(200);
        resp.setContentType("application/json");
        resp.getWriter().write(
                """
                        {
                        "message" : "User data updated successfully"
                        }
                        """
        );
    }

    @Override
    protected void doDelete(HttpServletRequest req,
                            HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        User user =userService.getUserById(id);

        if(user==null){
            resp.setStatus(404);
            resp.setContentType("application/json");
            resp.getWriter().write(
                    """
                        {
                        "message" : "User data not found"
                        }
                        """
            );
        }
        else{
            userService.deleteById(id);
            resp.setStatus(200);
            resp.setContentType("application/json");
            resp.getWriter().write(
                    """
                        {
                        "message" : "User data deleted successfully"
                        }
                        """
            );
        }

    }

    private String userToJson(User user){
        return "{\n"+
                "   \"id\": " + user.getId() +",\n"+
                "   \"name\": " + user.getName() +",\n"+
                "   \"email\": " + user.getEmail() +",\n"+
                "   \"number\": " + user.getNumber() +"\n"+
                "}";
    }

    private String usersToJson(List<User> users){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Integer count=0;
        for(User user:users){
            count++;
//            stringBuilder.append("{\n"+
//                    "   \"id\": " + user.getId() +",\n"+
//                    "   \"name\": " + user.getName() +",\n"+
//                    "   \"email\": " + user.getEmail() +",\n"+
//                    "   \"number\": " + user.getNumber() +"\n"+
//                    "}");
            stringBuilder.append(userToJson(user));
            if(count<users.size()){
                stringBuilder.append(",");
            }

        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
