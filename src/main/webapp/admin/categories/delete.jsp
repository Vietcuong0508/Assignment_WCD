<%@ page import="com.example.assignment_wcd.entity.Category" %>
<%
    Category categories = (Category) request.getAttribute("categories");
    if (categories == null) {
        categories = Category.CategoryBuilder.aCategory().build();
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
                        <h3>Category Detail</h3>
                    </div>
                    <div class="col-12 col-md-6 order-md-2 order-first">
                        <nav aria-label="breadcrumb" class='breadcrumb-header'>
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="/admin/categories/list">Category Management</a></li>
                                <li class="breadcrumb-item active" aria-current="page">Category Detail</li>
                            </ol>
                        </nav>
                    </div>
                </div>

            </div>
            <div class="col-12">
                <form action="/admin/categories/delete" method="post">
                    <div class="card">
                        <div class="card-header">
                            <h4 class="card-title">Category detail</h4>
                        </div>
                        <div class="card-content">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-6 col-12">
                                        <div class="form-group">
                                            <label>Name: </label>
                                            <%=categories.getName()%>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-12">
                                        <div class="form-group">
                                            <label>Status: </label>
                                            <%=categories.getStatus().name()%>
                                        </div>
                                    </div>
                                </div>
                                <button type="submit" value="Submit" class="btn btn-primary me-1 mb-1">Delete</button>
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