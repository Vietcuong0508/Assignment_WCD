<%@ page import="java.util.List" %>
<%@ page import="com.example.assignment_wcd.entity.Dish" %>
<%@ page import="java.util.ArrayList" %>
<%
    List<Dish> list = (List<Dish>) request.getAttribute("dish");
    if (list == null) {
        list = new ArrayList<>();
    }
%>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<jsp:include page="/admin/includes/head.jsp"/>
<body>
<div id="app">
    <div id="sidebar" class='active'>
        <jsp:include page="/admin/includes/main-sidebar.jsp"/>
    </div>
    <div id="main">
        <jsp:include page="/admin/includes/navbar.jsp"/>

        <div class="main-content container-fluid">
            <div class="page-title">
                <div class="row">
                    <div class="col-12 col-md-6 order-md-1 order-last">
                        <h3>List Dish</h3>
                    </div>
                    <div class="col-12 col-md-6 order-md-2 order-first">
                        <nav aria-label="breadcrumb" class='breadcrumb-header'>
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="/admin/products/list">Product Management</a></li>
                                <li class="breadcrumb-item active" aria-current="page">List Dish</li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
            <section class="section">
                <div class="card">
                    <div class="card-header">
                        Product Datatable
                    </div>
                    <div class="card-body">
                        <table class='table table-striped' id="table1">
                            <thead>
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Thumbnail</th>
                                <th>Price</th>
                                <th>Status</th>
                                <th>Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%for (int i = 0; i < list.size(); i++) {%>
                            <tr class="<%=i%2 == 0 ? "" : "odd"%>">
                                <td><%=list.get(i).getId()%>
                                </td>
                                <td><%=list.get(i).getFood()%>
                                </td>
                                <td><img src="<%=list.get(i).getThumbnail()%>" class="img-thumbnail img-rounded"
                                         style="width: 192px; height: 128px;"></td>
                                <td><%=list.get(i).getPrice()%>
                                </td>
                                <td>
                                    <%
                                        if (list.get(i).getStatus().getValue() == 1) {
                                    %>
                                    <span class="badge badge-success" style="color: black">ARE SELLING</span>
                                    <%}%>

                                </td>
                                <td>
                                    <a href="/admin/dish/detail?id=<%=list.get(i).getId()%>"
                                       class="btn icon icon-left btn-primary"><i data-feather="info"></i> Detail</a>
                                    <a href="/admin/dish/update?id=<%=list.get(i).getId()%>"
                                       class="btn icon icon-left btn-success"><i data-feather="edit"></i> Edit</a>
                                    <a href="/admin/dish/delete?id=<%=list.get(i).getId()%>"
                                       class="btn icon icon-left btn-danger" onclick="return confirm('Are you sure you want to delete?')"><i data-feather="edit"></i> Delete</a>
                                </td>
                            </tr>
                            <%}%>
                            </tbody>
                        </table>
                    </div>
                </div>

            </section>
        </div>


        <jsp:include page="/admin/includes/footer.jsp"/>
    </div>
</div>
<jsp:include page="/admin/includes/script.jsp"/>
</body>
</html>