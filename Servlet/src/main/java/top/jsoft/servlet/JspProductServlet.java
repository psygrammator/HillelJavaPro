package top.jsoft.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.jsoft.model.Product;
import top.jsoft.service.GetService;

import java.io.IOException;
import java.util.List;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@WebServlet("/products")
public class JspProductServlet extends HttpServlet {
    private final GetService getService = new GetService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = getService.getAllProducts();
        req.setAttribute("products", products);

        req.getRequestDispatcher("/products.jsp").forward(req, resp);
    }
}
