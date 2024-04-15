<%@ page import="org.example.club_sportif.Repository.MembreRepository" %>
<%@ page import="org.example.club_sportif.Entities.Membre" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.club_sportif.Repository.SportRepository" %>
<%@ page import="org.example.club_sportif.Entities.Sport" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<body>
<div class="wrapper">
    <div class="sidebar" data-image="../assets/img/sidebar-5.jpg">
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
                    <a class="nav-link" href="table.jsp">
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
                <a class="navbar-brand"> List of informations </a>
                <button href="" class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-bar burger-lines"></span>
                    <span class="navbar-toggler-bar burger-lines"></span>
                    <span class="navbar-toggler-bar burger-lines"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-end" id="navigation">
                    <ul class="nav navbar-nav mr-auto">
                        <li class="nav-item">
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
                    <div class="col-md-12">
                        <div class="card strpied-tabled-with-hover">
                            <div class="card-header ">
                                <h4 class="card-title">List of members</h4>
                            </div>
                            <div class="card-body table-full-width table-responsive">
                                <table class="table table-hover table-striped">
                                    <thead>
                                    <th>ID</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Phone Number</th>
                                    <th>Birthdate</th>
                                    <th>Subscription Plan</th>
                                    <th>Group</th>
                                    <th>Sports</th>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="membre" items="${membres}">
                                        <tr>
                                            <td>${membre.id_membre}</td>
                                            <td>${membre.prenom}</td>
                                            <td>${membre.nom}</td>
                                            <td>${membre.numerotelephone}</td>
                                            <td>${membre.dateNaissance}</td>
                                            <td>${membre.cotisation.methodePaiement}</td>
                                            <td>${membre.groupe.id_group}</td>
                                            <td>${membre.sports.nomSprot}
                                            <td>
                                                <!-- Form for deleting this row -->
                                                <form action="deleteMember" method="post">
                                                    <input type="hidden" name="memberId" value="${membre.id_membre}">
                                                    <button type="submit" class="btn btn-danger btn-sm">Delete</button>
                                                    <a href="updateMember.jsp" class="btn btn-primary btn-sm">Update</a>
                                                </form>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="card strpied-tabled-with-hover">
                            <div class="card-header ">
                                <h4 class="card-title">List of trainers</h4>
                            </div>
                            <div class="card-body table-full-width table-responsive">
                                <table class="table table-hover table-striped">
                                    <thead>
                                    <th>ID</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
<%--                                    <th>Phone Number</th>--%>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="trainer" items="${trainers}">
                                        <tr>
                                            <td>${trainer.id_entraineur}</td>
                                            <td>${trainer.prenom}</td>
                                            <td>${trainer.nom}</td>
<%--                                            <td>${trainer.Numerotelephone}</td>--%>
                                            <td>
                                                <!-- Form for deleting this row -->
                                                <form action="deleteTrainer" method="post">
                                                    <input type="hidden" name="trainerId" value="${trainer.id_entraineur}">
                                                    <button type="submit" class="btn btn-danger btn-sm">Delete</button>
                                                </form>
                                                <a href="updateTrainert.jsp" class="btn btn-primary btn-sm">Update</a>
                                            </td>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-12">
                        <div class="card strpied-tabled-with-hover">
                            <div class="card-header ">
                                <h4 class="card-title">List of Sports</h4>
                            </div>
                            <div class="card-body table-full-width table-responsive">
                                <table class="table table-hover table-striped">
                                    <thead>
                                    <th>ID</th>
                                    <th>Category</th>
                                    <th>Name</th>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="sport" items="${sports}">
                                        <tr>
                                            <td>${sport.idSport}</td>
                                            <td>${sport.category}</td>
                                            <td>${sport.nomSprot}</td>
                                            <td>
                                                <!-- Form for deleting this row -->
                                                <form action="deleteSport" method="post">
                                                    <input type="hidden" name="sportId" value="${sport.idSport}">
                                                    <input type="submit" class="btn btn-danger btn-sm" value="Delete">
                                                </form>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="card strpied-tabled-with-hover">
                            <div class="card-header ">
                                <h4 class="card-title">List of Facilities</h4>
                            </div>
                            <div class="card-body table-full-width table-responsive">
                                <table class="table table-hover table-striped">
                                    <thead>
                                    <th>ID</th>
                                    <th>Facility Name</th>
                                    <th>Sport</th>
                                    <th>Accessibility</th>
                                    <th>Address</th>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="facility" items="${facilities}">
                                        <tr>
                                            <td>${facility.idEndroit}</td>
                                            <td>${facility.nomEndroit}</td>
                                            <td>${facility.sport.nomSprot}</td>
                                            <td>${facility.disponibilite}</td>
                                            <td>${facility.adresse}</td>
                                            <td>
                                                <a href="updateFacility.jsp" class="btn btn-primary btn-sm">Update</a>
                                            </td>

                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="card strpied-tabled-with-hover">
                            <div class="card-header ">
                                <h4 class="card-title">List of Groups</h4>
                            </div>
                            <div class="card-body table-full-width table-responsive">
                                <table class="table table-hover table-striped">
                                    <thead>
                                    <th>ID</th>
                                    <th>Category</th>
                                    <th>Trainer Name</th>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="groupe" items="${groups}">
                                        <tr>
                                            <td>${groupe.id_group}</td>
                                            <td>${groupe.categorie}</td>
                                            <td>Trainer Id :${groupe.entraineur.id_entraineur} ${groupe.entraineur.nom} ${groupe.entraineur.prenom}</td>
                                            <td>
                                                <form action="deleteGroup" method="post">
                                                    <input type="hidden" name="groupeId" value="${groupe.id_group}">
                                                    <button type="submit" class="btn btn-danger btn-sm">Delete</button>
                                                </form>
                                                <a href="updateGroupe.jsp" class="btn btn-primary btn-sm">Update</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
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
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
<!--  Chartist Plugin  -->
<script src="Dashboard/assets/js/plugins/chartist.min.js"></script>
<!--  Notifications Plugin    -->
<script src="Dashboard/assets/js/plugins/bootstrap-notify.js"></script>
<!-- Control Center for Light Bootstrap Dashboard: scripts for the example pages etc -->
<script src="Dashboard/assets/js/light-bootstrap-dashboard.js?v=2.0.0 " type="text/javascript"></script>
<!-- Light Bootstrap Dashboard DEMO methods, don't include it in your project! -->
<script src="Dashboard/assets/js/demo.js"></script>

</html>
