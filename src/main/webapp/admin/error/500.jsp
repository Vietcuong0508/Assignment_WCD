<%@ page import="java.util.List" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="com.example.t2009m1java.entity.Category" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.t2009m1java.entity.myenum.ProductStatus" %>
<%@ page import="com.example.t2009m1java.entity.Product" %>
<%
    List<Category> categories = (List<Category>) request.getAttribute("categories");
    if (categories == null) {
        categories = new ArrayList<>();
    }
    Product products = (Product) request.getAttribute("product");
    if (products == null) {
        products = Product.ProductBuilder.aProduct().build();
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
                        <h3>Create New Product</h3>
                    </div>
                    <div class="col-12 col-md-6 order-md-2 order-first">
                        <nav aria-label="breadcrumb" class='breadcrumb-header'>
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="/admin/products/list">Product Management</a></li>
                                <li class="breadcrumb-item active" aria-current="page">Product Detail</li>
                            </ol>
                        </nav>
                    </div>
                </div>

            </div>
            <div id="error">

                <div class="container text-center pt-32">
                    <h1 class='error-title'>500</h1>
                    <%=request.getAttribute("message")%>
                    <a href="index.html" class='btn btn-primary'>Go Home</a>
                </div>

                <div class="footer pt-32">
                    <p class="text-center">Copyright &copy; Voler 2020</p>
                </div>
            </div>
        </div>

        <jsp:include page="/admin/includes/footer.jsp"/>
    </div>
</div>
<jsp:include page="/admin/includes/script.jsp"/>

<script src="https://upload-widget.cloudinary.com/global/all.js" type="text/javascript"></script>

<script type="text/javascript">
    var myWidget = cloudinary.createUploadWidget({
            cloudName: 'cuong0508',
            uploadPreset: 'wsmp4snv'
        }, (error, result) => {
            if (!error && result && result.event === "success") {
                // console.log('Done! Here is the image info: ', result.info.secure_url);
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