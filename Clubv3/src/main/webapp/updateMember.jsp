<%@ page import="org.example.club_sportif.Repository.MembreRepository" %>
<%@ page import="org.example.club_sportif.Entities.Membre" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.club_sportif.Repository.SportRepository" %>
<%@ page import="org.example.club_sportif.Entities.Sport" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%

    MembreRepository memberRepository = new MembreRepository();
    List<Membre> membres = memberRepository.findAll();
    SportRepository sportRepository=new SportRepository();
    List<Sport> sports=sportRepository.findAll();
%>

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
    <style>
        .sidebar {
            position: fixed;
            top: 0;
            left: 0;
            height: 100%;
            width: 260px;
            z-index: 1;
            background-color: #333;
            overflow-x: hidden;
            padding-top: 20px;
        }

        .main-panel {
            margin-left: 260px;
            padding: 20px;
        }

        body {
            font-family: 'Montserrat', sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f6f5f7;
        }

        .form-container {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 14px 28px rgba(0,0,0,0.25),
            0 10px 10px rgba(0,0,0,0.22);
            padding: 50px;
            max-width: 90%; /* Ajout de max-width pour la responsivité */
        }

        .form-container h1 {
            margin-bottom: 20px;
            font-size: 24px;
            font-weight: bold; /* Ajout de la police en gras */
        }

        .form-container span {
            font-size: 14px;
            color: #666;
            margin-bottom: 20px;
            display: block;
        }

        .form-container input {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .form-container button {
            width: 100%;
            padding: 12px 45px;
            background-color: #FF4B2B;
            color: #FFFFFF;
            border: none;
            border-radius: 20px;
            cursor: pointer;
            font-size: 12px;
            font-weight: bold;
            text-transform: uppercase;
            transition: transform 80ms ease-in;
        }

        .form-container button:hover {
            background-color: #FF416C;
        }
    </style>
</head>

<body>
<div class="sidebar" data-image="../assets/img/sidebar-5.jpg">
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

</div>
</div>
</div>

<div class="main-panel">
    <div class="form-container sign-up-container">
        <form action="updateMember" method="post">
            <h1>Update Member</h1>
            <input type="text" placeholder="First Name" name="firstname" />
            <input type="text" placeholder="Last Name" name="lastname"/>
            <input type="text" placeholder="Address" name="address"/>
            <input type="text" placeholder="Phone Number" name="phone"/>
            <input type="date" placeholder="Birthdate" name="birthdate"/>
            <button>Update</button>
        </form>
    </div>
</div>

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

</body>

</html>
