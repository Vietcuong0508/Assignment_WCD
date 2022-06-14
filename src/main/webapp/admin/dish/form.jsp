<%@ page import="java.util.List" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="com.example.assignment_wcd.entity.Category" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.assignment_wcd.entity.myenum.DishStatus" %>
<%@ page import="com.example.assignment_wcd.entity.Dish" %>
<%@ page import="java.util.HashMap" %>
<%
    int action = 1;
    String url = "/admin/dish/create";
    String title = "Create new dish";
    action = (int) request.getAttribute("action");
    if (action == 2) {
        url = "/admin/dish/update";
        title = "Update dish";
    }
    List<Category> categories = (List<Category>) request.getAttribute("categories");
    if (categories == null) {
        categories = new ArrayList<>();
    }
    HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
    if (errors == null) {
        errors = new HashMap<>();
    }
    Dish dish = (Dish) request.getAttribute("dish");
    if (dish == null) {
        dish = Dish.DishBuilder.aDish().build();
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
                        <h3><%=title%>
                        </h3>
                    </div>
                    <div class="col-12 col-md-6 order-md-2 order-first">
                        <nav aria-label="breadcrumb" class='breadcrumb-header'>
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="/admin/products/list">Product Management</a></li>
                                <li class="breadcrumb-item active" aria-current="page"><%=title%>
                                </li>
                            </ol>
                        </nav>
                    </div>
                </div>

            </div>
            <div class="col-12">
                <div class="card">
                    <div class="card-header">
                        <h4 class="card-title">Product form</h4>
                    </div>
                    <div class="card-content">
                        <div class="card-body">
                            <form class="form" action="<%=url%>" method="post">
                                <%if (action == 2) {%>
                                <input type="hidden" name="id" value="<%=dish.getId()%>">
                                <%}%>
                                <div class="row">
                                    <div class="col-md-6 col-12">
                                        <div class="form-group">
                                            <label for="name-column">Name</label>
                                            <input type="text" id="name-column" class="form-control"
                                                   placeholder="Name" name="name" value="<%=dish.getFood()%>">
                                            <%if (errors.containsKey("name")) {%>
                                            <span class="text-danger">*<%=errors.get("name")%></span>
                                            <%}%>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-12">
                                        <div class="form-group">
                                            <label for="price-column">Price</label>
                                            <input type="text" id="price-column" class="form-control"
                                                   name="price" placeholder="Price" value="<%=dish.getPrice()%>">
                                            <%if (errors.containsKey("price")) {%>
                                            <span class="text-danger">*<%=errors.get("price")%></span>
                                            <%}%>
                                        </div>
                                    </div>
                                    <div class="col-md-12 col-12">
                                        <div class="form-group">
                                            <label for="exampleFormControlTextarea1"
                                                   class="form-label">Description</label>
                                            <textarea name="description" class="form-control"
                                                      id="exampleFormControlTextarea1" rows="3"
                                                      spellcheck="false"
                                                      data-value="<%=dish.getDescription()%>"></textarea>
                                            <%if (errors.containsKey("description")) {%>
                                            <span class="text-danger">*<%=errors.get("description")%></span>
                                            <%}%>
                                        </div>
                                    </div>
                                    <div class="col-md-12 col-12">
                                        <div class="form-group">
                                            <label>Thumbnail</label>
                                            <div class="m-2">
                                                <%--                                                    <div class="form-file">--%>
                                                <%--                                                        <input name="thumbnail" type="file" class="form-file-input" id="inputGroupFile01"--%>
                                                <%--                                                               aria-describedby="inputGroupFileAddon01">--%>
                                                <%--                                                    </div>--%>
                                                <button type="button" id="upload_widget"
                                                        class="btn btn-outline-primary">Choose Image
                                                </button>
                                            </div>
                                            <div>
                                                <img id="preview-image" class="img-size-64 img-rounded img-thumbnail" src="https://imgv3.fotor.com/images/homepage-feature-card/Upload-an-image.jpg" width="250" height="180">
                                                <input type="hidden" name="thumbnail" id="hidden-thumbnails">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4 col-12">
                                        <label>Category</label>
                                        <div class="form-group">
                                            <select name="categoryId" class="choices form-select"
                                                    data-value="<%=dish.getCategoryId()%>">
                                                <%for (int i = 0; i < categories.size(); i++) {%>
                                                <option value="<%=categories.get(i).getId()%>"><%=categories.get(i).getName()%>
                                                </option>
                                                <%}%>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-md-4 col-12">
                                        <div class="form-group">
                                            <label for="date-column">Sale date</label>
                                            <input type="datetime-local" id="date-column" class="form-control" name="saleDate" value="<%=dish.getSaleDate()%>">
                                        </div>
                                    </div>
                                    <div class="col-md-4 col-12">
                                        <label>Status</label>
                                        <div class="form-group">
                                            <select name="status" class="choices form-select"
                                                    data-value="<%=dish.getStatus()%>">
                                                <%for (int i = 0; i < DishStatus.values().length; i++) {%>
                                                <option value="<%=DishStatus.values()[i].getValue()%>"><%=DishStatus.values()[i].name()%>
                                                </option>
                                                <%}%>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-12 d-flex justify-content-end">
                                        <button type="submit" value="Submit" class="btn btn-primary me-1 mb-1">Submit
                                        </button>
                                        <button type="reset" value="Reset" class="btn btn-light-secondary me-1 mb-1">
                                            Reset
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="/admin/includes/footer.jsp"/>
    </div>
</div>
<jsp:include page="/admin/includes/script.jsp"/>

<script src="https://upload-widget.cloudinary.com/global/all.js" type="text/javascript"></script>

<script type="text/javascript">
    document.getElementById("exampleFormControlTextarea1").value = <%=dish.getDescription()%>;
    var myWidget = cloudinary.createUploadWidget({
            cloudName: 'cuong0508',
            uploadPreset: 'wsmp4snv'
        }, (error, result) => {
            if (!error && result && result.event === "success") {
                console.log('Done! Here is the image info: ', result.info.secure_url);
                $('#preview-image').attr('src', result.info.secure_url);
                $('#hidden-thumbnails').val(result.info.secure_url);
            }
        }
    )

    document.getElementById("upload_widget").addEventListener("click", function () {
        myWidget.open();
    }, false);
</script>
</body>
</html>