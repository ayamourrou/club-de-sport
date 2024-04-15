<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <style>
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
            width: 400px;
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
<div class="form-container sign-up-container">
    <form action="AddMember" method="post">
        <h1>Create Account</h1>
        <span>or use your email for registration</span>
        <input type="text" placeholder="First Name" name="firstname" />
        <input type="text" placeholder="Last Name" name="lastname"/>
        <input type="text" placeholder="Address" name="address"/>
        <input type="text" placeholder="Phone Number" name="phone"/>
        <input type="date" placeholder="Birthdate" name="birthdate"/>
        <button>Next</button>
    </form>
</div>
</body>
</html>
