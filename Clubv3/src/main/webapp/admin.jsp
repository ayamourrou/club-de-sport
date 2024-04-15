<%@ page import="org.example.club_sportif.Entities.Admin" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="Dashboard/assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="Dashboard/assets/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>Admin Dashboard</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
    <!-- CSS Files -->
    <link href="Dashboard/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="Dashboard/assets/css/light-bootstrap-dashboard.css?v=2.0.0 " rel="stylesheet" />
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="Dashboard/assets/css/demo.css" rel="stylesheet" />
</head>

<body>
<div class="wrapper">
    <div class="sidebar" data-image="src/main/webapp/Dashboard/assets/img/sidebar-5.jpg">
        <!--
    Tip 1: You can change the color of the sidebar using: data-color="purple | blue | green | orange | red"

    Tip 2: you can also add an image using data-image tag
-->
        <div class="sidebar-wrapper">
            <ul class="nav">
                <li>
                    <p>Dashboard</p>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="admin.jsp">
                        <p>Admin Profile</p>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ctrl?action=informations">
                        <p>Different Information Lists</p>
                    </a>
                </li>
                <li>
                    <a class="nav-link" href="updateMember.jsp">
                        <p>Update Member</p>
                    </a>
                </li>
                <li>
                    <a class="nav-link" href="updateFacility.jsp">
                        <p>Update Facility</p>
                    </a>
                </li>
                <li>
                    <a class="nav-link" href="updateTrainert.jsp">
                        <p>Update Trainer</p>
                    </a>
                </li>
                <li>
                    <a class="nav-link" href="updateGroupe.jsp">
                        <p>Update Group</p>
                    </a>
                </li>
                <li>
                    <a class="nav-link" href="addSport.jsp">
                        <p>Add Sport </p>
                    </a>
                </li>
                <li>
                    <a class="nav-link" href="addTrainer.jsp">
                        <p>Add Trainer</p>
                    </a>
                </li>
                <li>
                    <a class="nav-link" href="addGroup.jsp">
                        <p>Add Group</p>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <div class="main-panel">
        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg " color-on-scroll="500">
            <div class="container-fluid">
                <a class="navbar-brand">${admin2.nom} ${admin2.prenom} </a>
                <button href="" class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-bar burger-lines"></span>
                    <span class="navbar-toggler-bar burger-lines"></span>
                    <span class="navbar-toggler-bar burger-lines"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-end" id="navigation">
                    <ul class="nav navbar-nav mr-auto">
                        <li class="nav-item">
                            <span class="d-lg-none">Dashboard</span>
                            </a>
                        </li>
                    </ul>
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
                    <div class="col-md-8">
                        <div class="card">
                            <div class="card-header">
                                <h4 class="card-title">Admin Profile</h4>
                            </div>
                            <div class="card-body">
                                <form>
                                    <div class="row">
                                        <div class="col-md-3 px-1">
                                            <div class="form-group">
                                                <label>Username</label>
                                                <input type="text" class="form-control" placeholder="Username" value="${admin2.username}" disabled="">
                                            </div>
                                        </div>
                                        <div class="col-md-4 pl-1">
                                            <div class="form-group">
                                                <label >Phone number</label>
                                                <input type="email" class="form-control" placeholder="Email" disabled="" value="${admin2.numeroTelephone}">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 pr-1">
                                            <div class="form-group">
                                                <label>First Name</label>
                                                <input type="text" class="form-control" placeholder="Company" value="${admin2.prenom}" disabled>
                                            </div>
                                        </div>
                                        <div class="col-md-6 pl-1">
                                            <div class="form-group">
                                                <label>Last Name</label>
                                                <input type="text" class="form-control" placeholder="Last Name" value="${admin2.nom}" disabled>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>Address</label>
                                                <input type="text" class="form-control" placeholder="Home Address" value="${admin2.adresse}" disabled>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                    </div>
                </div>
            </div>
        </div>

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
<!-- <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script> -->
<!--  Chartist Plugin  -->
<script src="Dashboard/assets/js/plugins/chartist.min.js"></script>
<!--  Notifications Plugin    -->
<%--<script src="Dashboard/assets/js/plugins/bootstrap-notify.js"></script>--%>
<!-- Control Center for Light Bootstrap Dashboard: scripts for the example pages etc -->
<script src="Dashboard/assets/js/light-bootstrap-dashboard.js?v=2.0.0 " type="text/javascript"></script>
<!-- Light Bootstrap Dashboard DEMO methods, don't include it in your project! -->
<script src="Dashboard/assets/js/demo.js"></script>
<script>
    $(document).ready(function() {
        // Javascript method's body can be found in assets/js/demos.js
        demo.initDashboardPageCharts();

        demo.showNotification();

    });
</script>

</html>
