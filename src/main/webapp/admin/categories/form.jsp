<%@ page import="java.util.HashMap" %>
<%@ page import="com.example.assignment_wcd.entity.Category" %>
<%
    int action = 1;
    String url = "/admin/categories/create";
    String title = "Create new category";
    action = (int) request.getAttribute("action");
    if (action == 2) {
        url = "/admin/categories/update";
        title = "Update category";
    }
    Category category = (Category) request.getAttribute("category");
    if (category == null) {
        category = new Category();
    }
    HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
    if (errors == null) {
        errors = new HashMap<>();
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
                        <h3><%=title%></h3>
                    </div>
                    <div class="col-12 col-md-6 order-md-2 order-first">
                        <nav aria-label="breadcrumb" class='breadcrumb-header'>
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="/admin/categories/list">Category Management</a></li>
                                <li class="breadcrumb-item active" aria-current="page"><%=title%></li>
                            </ol>
                        </nav>
                    </div>
                </div>

            </div>
            <div class="col-md-12">
                <form action="<%=url%>" method="post">
                    <%if (action == 2) {%>
                    <input type="hidden" name="id" value="<%=category.getId()%>">
                    <%}%>
                    <div class="card">
                        <div class="card-header">
                            <h4 class="card-title">Thể loại</h4>
                        </div>

                        <div class="card-body">
                            <div class="row">
                                <div class="form-group">
                                    <label for="basicInput">Name</label>
                                    <input type="text" name="name" class="form-control" id="basicInput"
                                           placeholder="Category" value="<%=category.getName()%>">
                                    <%
                                        if (errors.containsKey("name")) {
                                    %>
                                    <span class="w3-text-red">* <%=errors.get("name")%></span>
                                    <%}%>
                                </div>
                            </div>

                            <div class="col-12 d-flex justify-content-end">
                                <button type="submit" value="Submit" class="btn btn-primary me-1 mb-1">Submit</button>
                                <button type="reset" value="Reset" class="btn btn-light-secondary me-1 mb-1">Reset
                                </button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <jsp:include page="/admin/includes/footer.jsp"/>
    </div>
</div>
<jsp:include page="/admin/includes/script.jsp"/>
</body>
</html>