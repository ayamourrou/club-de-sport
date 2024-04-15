<!--
=========================================================
Light Bootstrap Dashboard - v2.0.1
=========================================================

Product Page: https://www.creative-tim.com/product/light-bootstrap-dashboard
Copyright 2019 Creative Tim (https://www.creative-tim.com)
Licensed under MIT (https://github.com/creativetimofficial/light-bootstrap-dashboard/blob/master/LICENSE)

Coded by Creative Tim

=========================================================

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="Dashboard/assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="Dashboard/assets/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>Light Bootstrap Dashboard - Free Bootstrap 4 Admin Dashboard by Creative Tim</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
    <!-- CSS Files -->
    <link href="Dashboard/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="Dashboard/assets/css/light-bootstrap-dashboard.css?v=2.0.0 " rel="stylesheet" />
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="Dashboard/assets/css/demo.css" rel="stylesheet" />
</head>

<body>
<div class="wrapper">
    <div class="sidebar" data-image="../assets/img/sidebar-5.jpg">

        <div class="sidebar-wrapper">

            <ul class="nav">
                <li >
                    <a class="nav-link" href="ctrl?action=Member">
                        <p>Member Profile</p>
                    </a>
                </li>
                <li>
                    <a class="nav-link" href="ctrl?action=SportsList">
                        <p>Sports Lists</p>
                    </a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="ctrl?action=Group">
                        <p>Groups</p>
                    </a>
                </li>
                <li>
                    <a class="nav-link" href="ctrl?action=MemberShip">
                        <p>MemberShip</p>
                    </a>
                </li>

            </ul>
        </div>
    </div>
    <div class="main-panel">
        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg " color-on-scroll="500">
            <div class="container-fluid">
                <a class="navbar-brand" href="#pablo"> ${user.prenom} ${user.nom} </a>
                <button href="" class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-bar burger-lines"></span>
                    <span class="navbar-toggler-bar burger-lines"></span>
                    <span class="navbar-toggler-bar burger-lines"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-end" id="navigation">

                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="ctrl?action=logout">
                                <span class="no-icon">Log out</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <!-- End Navbar -->
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card strpied-tabled-with-hover">
                            <div class="card-header ">
                                <h4 class="card-title">Sport</h4>
                                <p class="card-category">Select the sport you want to add.</p>
                            </div>
                            <div class="card-body table-full-width table-responsive">
                                <form action="AddGroupToMember" method="post">
                                    <table class="table table-hover table-striped">
                                        <thead>
                                        <th>Select</th>
                                        <th>Category</th>
                                        <th>Group Name</th>
                                        <th>Coach</th>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="groupe" items="${sessionScope.groupes}">
                                            <tr>
                                                <td><input type="radio" name="selectedGroups" value="${groupe.id_group}"></td>
                                                <td>${groupe.categorie}</td>
                                                <td>${groupe.nomequipe}</td>
                                                <td>${groupe.entraineur.prenom} ${groupe.entraineur.nom}</td>                                             </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <div class="d-flex justify-content-center">
                                        <button type="submit" class="btn btn-primary">Add</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer class="footer">
            <div class="container-fluid">
                <nav>
                    <ul class="footer-menu">
                        <li>
                            <a href="#">
                                Home
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                Company
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                Portfolio
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                Blog
                            </a>
                        </li>
                    </ul>
                    <p class="copyright text-center">
                        ©
                        <script>
                            document.write(new Date().getFullYear())
                        </script>
                        <a href="http://www.creative-tim.com">Creative Tim</a>, made with love for a better web
                    </p>
                </nav>
            </div>
        </footer>
    </div>

</div>

</body>
<!--   Core JS Files   -->
<script src="Dashboard/assets/js/core/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="Dashboard/assets/js/core/popper.min.js" type="text/javascript"></script>
<script src="Dashboard/assets/js/core/bootstrap.min.js" type="text/javascript"></script>
<!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
<script src="Dashboard/assets/js/plugins/bootstrap-switch.js"></script>
<!--  Google Maps Plugin    -->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
<!--  Chartist Plugin  -->
<script src="Dashboard/assets/js/plugins/chartist.min.js"></script>
<!--  Notifications Plugin    -->
<script src="Dashboard/assets/js/plugins/bootstrap-notify.js"></script>
<!-- Control Center for Light Bootstrap Dashboard: scripts for the example pages etc -->
<script src="Dashboard/assets/js/light-bootstrap-dashboard.js?v=2.0.0 " type="text/javascript"></script>
<!-- Light Bootstrap Dashboard DEMO methods, don't include it in your project! -->
<script src="Dashboard/assets/js/demo.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        // Javascript method's body can be found in assets/js/demos.js
        demo.initGoogleMaps();

    });
</script>

</html>
