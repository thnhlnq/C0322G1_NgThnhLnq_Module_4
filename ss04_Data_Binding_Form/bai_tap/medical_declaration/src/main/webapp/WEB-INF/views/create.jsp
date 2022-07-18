<%--
  Created by IntelliJ IDEA.
  User: ntlon
  Date: 15/07/2022
  Time: 06:48 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <title>Medical Declaration</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<form:form action="/create" method="post" modelAttribute="medical">
    <div class="container-fluid">
        <div class="text-center">
            <h1>TỜ KHAI Y TẾ</h1>
            <h5>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH / CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ GIÚP
                PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM.</h5>
            <h6 class="text-danger">Khuyến cáo: Khai báo thông tin sai là vi phạm Pháp Luật Việt Nam và có thể xử lí
                hình sự</h6>
            <hr>
        </div>
        <table class="table w-100">
            <tr>
                <td>
                    <form:label path="name">Họ Tên (ghi chữ IN HOA) <span
                            class="text-danger fst-italic"> (*) </span></form:label><br>
                    <form:input path="name"/>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="birth">Năm Sinh <span class="text-danger fst-italic"> (*) </span></form:label><br>
                    <form:select path="birth" items="${births}"/>
                </td>

                <td>
                    <form:label path="gender">Giới Tính <span
                            class="text-danger fst-italic"> (*) </span></form:label><br>
                    <form:select path="gender" items="${genders}"/>
                </td>

                <td>
                    <form:label path="nationality">Quốc Tịch <span
                            class="text-danger fst-italic"> (*) </span></form:label><br>
                    <form:select path="nationality" items="${nationalities}"/>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="idCard">Số Hộ Chiếu hoặc Số CMND hoặc Giấy Thông hành Hợp pháp khác <span
                            class="text-danger fst-italic"> (*) </span></form:label><br>
                    <form:input path="idCard"/>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="travel">Thông tin đi lại <span
                            class="text-danger fst-italic"> (*) </span></form:label><br>
                    <form:radiobuttons path="travel" items="${travels}"/>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="vehicle">Số Hiệu Phương Tiện <span
                            class="text-danger fst-italic"> (*) </span></form:label><br>
                    <form:input path="vehicle"/>
                </td>

                <td>
                    <form:label path="seat">Số Ghế <span class="text-danger fst-italic"> (*) </span></form:label><br>
                    <form:input path="seat"/>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="startDay">Ngày Khởi Hành <span class="text-danger fst-italic"> (*) </span></form:label><br>
                    <form:input path="startDay"/>
                </td>

                <td>
                    <form:label path="startMonth"/><br>
                    <form:input path="startMonth"/>
                </td>

                <td>
                    <form:label path="startYear"/><br>
                    <form:input path="startYear"/>
                </td>

                <td>
                    <form:label path="endDay">Ngày Kết Thúc <span class="text-danger fst-italic"> (*) </span></form:label><br>
                    <form:input path="endDay"/>
                </td>

                <td>
                    <form:label path="endMonth"/><br>
                    <form:input path="endMonth"/>
                </td>

                <td>
                    <form:label path="endYear"/><br>
                    <form:input path="endYear"/>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="">Trong vòng 14 ngày qua, Anh / Chị có đến Tỉnh / Thành Phố nào ? <span class="text-danger fst-italic"> (*) </span></form:label><br>
                    <form:input path="travelInfo"/>
                </td>
            </tr>
        </table>
    </div>

    <div class="row mt-2">
        <div class="col-lg-12">
            <p class="text-danger fw-bold">Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho việc phòng chống
                dịch, thuộc quản lý của Ban chỉ đạo quốc gia về phòng chống dịch Covid-19</p>
            <p class="text-danger fw-bold">Khi bạn nhấn nút "Gửi" là bạn đã hiểu và đồng ý.</p>
        </div>
    </div>

    <div class="row mt-2">
        <div class="col-lg-12 text-center">
            <form:button class="btn btn-success">
                Thêm Mới
            </form:button>
        </div>
    </div>
</form:form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
