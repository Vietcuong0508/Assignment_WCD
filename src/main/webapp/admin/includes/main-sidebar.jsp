<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="sidebar-wrapper active">
    <div class="sidebar-header">
        <img src="/admin/assets/images/logo.svg" alt="" srcset="">
    </div>
    <div class="sidebar-menu">
        <ul class="menu">


            <li class='sidebar-title'>Main Menu</li>


            <li class="sidebar-item active ">

                <a href="index.html" class='sidebar-link'>
                    <i data-feather="home" width="20"></i>
                    <span>Dashboard</span>
                </a>


            </li>


            <li class="sidebar-item  has-sub">

                <a href="#" class='sidebar-link'>
                    <i data-feather="sliders" width="20"></i>
                    <span>Quản lý món ăn</span>
                </a>

                <ul class="submenu ">
                    <li>
                        <a href="/admin/dish/create" class="sidebar-link">
                            <i data-feather="file-plus" width="20"></i>
                            <span>Tạo mới</span>
                        </a>
                    </li>

                    <li>
                        <a href="/admin/dish/list" class="sidebar-link">
                            <i data-feather="list" width="20"></i>
                            <span>Danh sách</span>
                        </a>
                    </li>
                </ul>

            </li>
            <li class="sidebar-item  has-sub">

                <a href="#" class='sidebar-link'>
                    <i data-feather="sliders" width="20"></i>
                    <span>Quản lý danh mục</span>
                </a>

                <ul class="submenu ">
                    <li>
                        <a href="/admin/categories/create" class="sidebar-link">
                            <i data-feather="file-plus" width="20"></i>
                            <span>Tạo mới</span>
                        </a>
                    </li>

                    <li>
                        <a href="/admin/categories/list" class="sidebar-link">
                            <i data-feather="list" width="20"></i>
                            <span>Danh sách</span>
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
    <button class="sidebar-toggler btn x"><i data-feather="x"></i></button>
</div>