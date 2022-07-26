<%--
  Created by IntelliJ IDEA.
  User: ntlonq
  Date: 17/07/2022
  Time: 10:29 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2 class="text-center">Danh sách tờ khai y tế</h2>
<table class="table table-striped table-hover">
    <tr>
        <th></th>
        <th>Họ Tên</th>
        <th>Năm Sinh</th>
        <th>Giới Tính</th>
        <th>Quốc Tịch</th>
        <th>CMND</th>
        <th>Thông Tin Đi Lại</th>
        <th>Số Hiệu</th>
        <th>Số Ghế</th>
        <th>Ngày Khởi Hành</th>
        <th>Tháng Khởi Hành</th>
        <th>Năm Khởi Hành</th>
        <th>Ngày Kết Thúc</th>
        <th>Tháng Kết Thúc</th>
        <th>Năm Kết Thúc</th>
        <th>Thông Tin Di Chuyển</th>
        <th></th>
    </tr>
    <c:forEach items="${medicals}" var="medical">
        <tr>
            <td></td>
            <td>${medical.name}</td>
            <td>${medical.birth}</td>
            <td>${medical.gender}</td>
            <td>${medical.nationality}</td>
            <td>${medical.idCard}</td>
            <td>${medical.travel}</td>
            <td>${medical.vehicle}</td>
            <td>${medical.seat}</td>
            <td>${medical.startDay}</td>
            <td>${medical.startMonth}</td>
            <td>${medical.startYear}</td>
            <td>${medical.endDay}</td>
            <td>${medical.endMonth}</td>
            <td>${medical.endYear}</td>
            <td>${medical.travelInfo}</td>
            <td>
                <a href="/edit?idCard=${medical.idCard}">
                    <button class="btn btn-outline-secondary">Sửa</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
<div class="container-fluid">
    <div>
        <a href="/create">
            <button class="btn btn-outline-secondary">Thêm Mới</button>
        </a>
    </div>
</div>
</body>
</html>
