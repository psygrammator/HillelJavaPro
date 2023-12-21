<%@ page import="top.jsoft.model.Product" %>
<%@ page import="java.util.List" %>
<html>
    <head>
        <title>Products List</title>
    </head>
    <body>
        <h1>All Products</h1>
        <br/>
        <table>
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Cost</td>
            </tr>
        <%
            List<Product> products = (List<Product>) request.getAttribute("products");
            for(Product product : products){
                out.println("<tr>");
                out.println("<td>" + product.getId() + "</td>");
                out.println("<td>" + product.getName() + "</td>");
                out.println("<td>" + product.getCost() + "</td>");
                out.println("</tr>");
            }
        %>
        </table>
    </body>
</html>