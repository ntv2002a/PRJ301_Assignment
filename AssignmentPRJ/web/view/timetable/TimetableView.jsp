<%-- 
    Document   : TimetableView
    Created on : Jun 22, 2022, 12:00:39 PM
    Author     : trungvu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <div style="text-align: center;">Campus <select name="week">
        <option value="">ALL</option>
    </select> </div>
    <div style="text-align: center;">Lecturer <select name="week">
        <option value="">sonnt5</option>
        </select>
        <input type="submit" value="View"> 
    </div>
    <div class="container">
        <div class="timetable-img text-center">
            <img src="img/content/timetable.png" alt="">
        </div>
        <div class="table-responsive">
            <table class="table table-bordered text-center">
                <thead>
                    <tr class="bg-light-gray">
                        <th class="text-uppercase">Year <select name="year">
                            <option value="">ALL</option>
                        </select>
                        </th>
                        <th class="text-uppercase">Mon</th>
                        <th class="text-uppercase">Tue</th>
                        <th class="text-uppercase">Wed</th>
                        <th class="text-uppercase">Thu</th>
                        <th class="text-uppercase">Fri</th>
                        <th class="text-uppercase">Sat</th>
                        <th class="text-uppercase">Sun</th>
                    </tr>
                    <tr class="bg-light-gray">
                        <th class="text-uppercase">Week <select name="week">
                            <option value="">ALL</option>
                        </select>
                        </th>
                        <th class="text-uppercase">day 1</th>
                        <th class="text-uppercase">day 2</th>
                        <th class="text-uppercase">day 3</th>
                        <th class="text-uppercase">day 4</th>
                        <th class="text-uppercase">day 5</th>
                        <th class="text-uppercase">day 6</th>
                        <th class="text-uppercase">day 7</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td class="align-middle">Slot 1</td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>

                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                    </tr>

                    <tr>
                        <td class="align-middle">Slot 2</td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>

                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                    </tr>

                    <tr>
                        <td class="align-middle">Slot 3</td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>

                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                    </tr>

                    <tr>
                        <td class="align-middle">Slot 4</td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                    </tr>

                    <tr>
                        <td class="align-middle">Slot 5</td>
                        <td>
                            <div class="margin-10px-top font-size14">SE1623</div>
                            <div class="margin-10px-top font-size14">PRJ301</div>
                            <div class="margin-10px-top font-size14">at DE-C202</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="margin-10px-top font-size14">SE1623</div>
                            <div class="margin-10px-top font-size14">PRJ301</div>
                            <div class="margin-10px-top font-size14">at DE-C202</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="margin-10px-top font-size14">SE1623</div>
                            <div class="margin-10px-top font-size14">PRJ301</div>
                            <div class="margin-10px-top font-size14">at DE-C202</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                    </tr>

                    <tr>
                        <td class="align-middle">Slot 6</td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                    </tr>

                    <tr>
                        <td class="align-middle">Slot 7</td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                        <td>
                            <div class="font-size13 text-light-gray">-</div>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</body>
    

</html>
