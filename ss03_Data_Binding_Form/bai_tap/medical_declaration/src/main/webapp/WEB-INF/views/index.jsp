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

<form:form action="/" method="post" modelAttribute="medical">
    <div class="container-fluid">
        <div class="text-center">
            <h1>TỜ KHAI Y TẾ</h1>
            <h5>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH / CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ GIÚP PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM.</h5>
            <h6 class="text-danger">Khuyến cáo: Khai báo thông tin sai là vi phạm Pháp Luật Việt Nam và có thể xử lí hình sự</h6>
            <hr>
        </div>
        <table class="table w-100">
            <tr>
                <td>
                    <form:label path="name">Họ Tên (ghi chữ IN HOA) <span class="text-danger fst-italic"> (*) </span></form:label><br>
                    <form:input path="name"/>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="birth">Năm Sinh <span class="text-danger fst-italic"> (*) </span></form:label><br>
                    <form:select path="birth">
                        <form:option value="1990">1990</form:option>
                        <form:option value="1991">1991</form:option>
                        <form:option value="1992">1992</form:option>
                    </form:select>
                </td>

                <td>
                    <form:label path="gender">Giới Tính <span class="text-danger fst-italic"> (*) </span></form:label><br>
                    <form:select path="gender">
                        <form:option value="Nam">Nam</form:option>
                        <form:option value="Nữ">Nữ</form:option>
                        <form:option value="Khác">Khác</form:option>
                    </form:select>
                </td>

                <td>
                    <form:label path="nationality">Quốc Tịch <span class="text-danger fst-italic"> (*) </span></form:label><br>
                    <form:select path="nationality">
                        <form:option value="Việt Nam">Việt Nam</form:option>
                        <form:option value="Mỹ">Mỹ</form:option>
                        <form:option value="Anh">Anh</form:option>
                    </form:select>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="passport">Số Hộ Chiếu hoặc Số CMND hoặc Giấy Thông hành Hợp pháp khác <span class="text-danger fst-italic"> (*) </span></form:label><br>
                    <form:input path="passport"/>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="travel">Thông tin đi lại <span class="text-danger fst-italic"> (*) </span></form:label><br>
                    <form:radiobutton path="travel" value="Tàu Bay"/> &nbsp; Tàu Bay &nbsp;
                    <form:radiobutton path="travel" value="Tàu Thuyền"/> &nbsp; Tàu Thuyền &nbsp;
                    <form:radiobutton path="travel" value="Ô Tô"/> &nbsp; Ô Tô &nbsp;
                    <form:radiobutton path="travel" value=""/> &nbsp; Khác (Ghi Rõ) &nbsp;
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="vehicle">Số Hiệu Phương Tiện <span class="text-danger fst-italic"> (*) </span></form:label><br>
                    <form:input path="vehicle"/>
                </td>

                <td>
                    <form:label path="seat">Số Ghế <span class="text-danger fst-italic"> (*) </span></form:label><br>
                    <form:input path="seat"/>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="startDate">Ngày Khởi Hành <span class="text-danger fst-italic"> (*) </span></form:label><br>
                    <form:input path="startDate"/>
                </td>

                <td>
                    <form:label path="endDate">Ngày Kết Thúc <span class="text-danger fst-italic"> (*) </span></form:label><br>
                    <form:input path="endDate"/>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="">Trong vòng 14 ngày qua, Anh / Chị có đến Tỉnh / Thành Phố nào ? <span class="text-danger fst-italic"> (*) </span></form:label><br>
<%--                    <form:input path=""/>--%>
                </td>
            </tr>

            <tr>
                <th>Địa Chỉ Liên Lạc</th>
            </tr>

        </table>
    </div>

</form:form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
