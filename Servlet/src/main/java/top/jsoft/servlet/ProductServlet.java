package top.jsoft.servlet;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.jsoft.service.GetService;

import java.io.IOException;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    private final GetService orderService = new GetService();
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (var writer = resp.getWriter()) {
            String id = req.getParameter("id");
            if (id == null)
                writer.println(gson.toJson(orderService.getAllProducts()));
            else
                writer.println(gson.toJson(orderService.getProductsByOrderId(Integer.parseInt(id))));
        }
    }

}
