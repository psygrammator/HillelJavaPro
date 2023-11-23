package top.jsoft.servlet;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.jsoft.model.Order;
import top.jsoft.service.OrderService;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    private final OrderService orderService = new OrderService();
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter writer = resp.getWriter()) {
            final String id = req.getParameter("id");
            if (id == null) {
                System.out.println(orderService.getOrders());
                writer.println(gson.toJson(orderService.getOrders()));
            } else {
                System.out.println(orderService.getOrder(Integer.parseInt(id)));
                writer.println(gson.toJson(orderService.getOrder(Integer.parseInt(id))));
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Order order = gson.fromJson(req.getReader(), Order.class);
        orderService.addOrder(order);
        System.out.println(order);
        try (PrintWriter writer = resp.getWriter()) {
            writer.println("Order id=" + gson.toJson(order.getId()) + " has been added");
        }
    }

}
