<%@ page import="it.soundmate.beans.UserBean" %><%--
  ~ Copyright (c) 2020.
  ~ This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
  ~ Last Modified: 01/12/20, 22:15
  --%>

<%--
  Created by IntelliJ IDEA.
  User: lpant
  Date: 01/12/2020
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>


<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/register.css">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700&display=swap" rel="stylesheet">
    <title>Register to Soundmate</title>
</head>


<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="registerBean" scope="request" class="it.soundmate.beans.RegisterBean"/>
<jsp:setProperty name="registerBean" property="*"/>
<jsp:useBean id="userBean" scope="session" class="it.soundmate.beans.UserBean"/>

<!-- Register Request -->
<%
    if (request.getParameter("continue")!=null) {
        if (registerBean.emptyCommonFields()) {
%>
            <div style="align-content: center; color: red; justify-content: center; align-items: center;">
                <p style="font-weight: bold; color: white; background: red; margin: 0 auto; padding: 1em; text-align: center">Please insert valid data</p>
            </div>
<%
        } else {
            switch (request.getParameter("register")) {
                case "Band":
                    if (registerBean.getBandName() == null) {
%>
                        <div style="align-content: center; color: red; justify-content: center; align-items: center;">
                            <p style="font-weight: bold; color: white; background: red; margin: 0 auto; padding: 1em; text-align: center">Please insert a Band Name</p>
                        </div>
<%
                        break;
                    } else {
                        userBean = registerBean.registerUser(registerBean.getEmail(), registerBean.getPassword(), registerBean.getFirstName(), registerBean.getLastName(), registerBean.getBandName(), 2);
                        if (userBean!=null) {
                            session.setAttribute("userID", userBean.getUserID());
                            session.setAttribute("firstName", userBean.getFirstName());
                            session.setAttribute("lastName", userBean.getLastName());
%>
                            <jsp:forward page="welcome.jsp"/>
<%
                            break;
                        } else {
%>
                                <div style="align-content: center; color: red; justify-content: center; align-items: center;">
                                    <p style="font-weight: bold; color: white; background: red; margin: 0 auto; padding: 1em; text-align: center">Something went wrong, try again later</p>
                                </div>
<%
                                break;
                        }
                    }
                case "Solo":
                    if (registerBean.emptySoloFields()) {
%>
                        <div style="align-content: center; color: red; justify-content: center; align-items: center;">
                            <p style="font-weight: bold; color: white; background: red; margin: 0 auto; padding: 1em; text-align: center">Please insert valid data for Solo</p>
                        </div>
<%
                        break;
                    } else {
                        userBean = registerBean.registerUser(registerBean.getEmail(), registerBean.getPassword(), registerBean.getFirstName(), registerBean.getLastName(), registerBean.getBandRoomName(), 1);

                        if (userBean!=null) {
                            session.setAttribute("userID", userBean.getUserID());
                            session.setAttribute("firstName", userBean.getFirstName());
                            session.setAttribute("lastName", userBean.getLastName());
%>
                            <jsp:forward page="welcome.jsp"/>
<%
                        } else {
%>
                                <div style="align-content: center; color: red; justify-content: center; align-items: center;">
                                    <p style="font-weight: bold; color: white; background: red; margin: 0 auto; padding: 1em; text-align: center">Something went wrong, try again later</p>
                                </div>
<%
                        }
                    }
                    break;
                case "Band Room":
                    if (registerBean.emptyBandRoomFields()) {
%>
                        <div style="align-content: center; color: red; justify-content: center; align-items: center;">
                            <p style="font-weight: bold; color: white; background: red; margin: 0 auto; padding: 1em; text-align: center">Please insert valid data the Band Room</p>
                        </div>
<%
                        break;
                    } else {
                        userBean = registerBean.registerUser(registerBean.getEmail(), registerBean.getPassword(), registerBean.getFirstName(), registerBean.getLastName(), registerBean.getBandRoomName(), 3);
                        if (userBean!=null) {
                            session.setAttribute("userID", userBean.getUserID());
                            session.setAttribute("firstName", userBean.getFirstName());
                            session.setAttribute("lastName", userBean.getLastName());
%>
                            <jsp:forward page="welcome.jsp"/>
<%
                        } else {
%>
                            <div style="align-content: center; color: red; justify-content: center; align-items: center;">
                                <p style="font-weight: bold; color: white; background: red; margin: 0 auto; padding: 1em; text-align: center">Something went wrong, try again later</p>
                            </div>
<%
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }
%>

<body>

<div class="main">
    <img src="../../resources/it/soundmate/images/logo-v.svg" class="main-img" alt="logo">
    <form action="" method="post" name="register-form">
        <div class="common-form">
            <div class="common-fields">
                <div class="email-and-password">
                    <div class="field">
                        <label for="email">Email</label>
                        <input type="text" name="email" id="email" class="text-field-style">
                    </div>
                    <div class="field">
                        <label for="password-register">Password</label>
                        <input type="text" name="password" id="password-register" class="text-field-style">
                    </div>
                </div>
                <div class="names">
                    <div class="field">
                        <label for="firstName">First Name</label>
                        <input type="text" name="firstName" id="firstName" class="text-field-style">
                    </div>
                    <div class="field">
                        <label for="lastName">Last Name</label>
                        <input type="text" name="lastName" id="lastName" class="text-field-style">
                    </div>
                </div>
            </div>
        </div>

        <%
            switch (request.getParameter("register")) {
                case "Band":
        %>
        <div class="specific-form">
            <input type="text" name="bandName" id="band-name" value="" class="band-name-form"
                   placeholder="Band Name...">
        </div>
        <%
                break;
            case "Band Room":
        %>
        <div class="specific-form-band-room">
            <div class="field">
                <label for="band-room-name">Band Room Name</label>
                <input type="text" name="bandRoomName" id="band-room-name" class="text-field-style">
            </div>
            <div class="field">
                <label for="city">City</label>
                <input type="text" name="city" id="city" class="text-field-style">
            </div>
            <div class="field">
                <label for="address">Address</label>
                <input type="text" name="address" id="address" class="text-field-style">
            </div>
        </div>
        <%
                break;
            case "Solo":
        %>
        <div class="specific-form-band-room">
            <div class="field">
                <label for="main-instrument">Main Instrument</label>
                <input type="text" name="mainInstrument" id="main-instrument" class="text-field-style" placeholder="You can skip this field and add it later">
            </div>
            <div class="field">
                <label for="fav-genres">Favourite Genre</label>
                <input type="text" name="favGenre" id="fav-genres" class="text-field-style" placeholder="You can skip this field and add it later">
            </div>
            <div class="field">
                <label for="city-solo">City</label>
                <input type="text" name="city" id="city-solo" class="text-field-style">
            </div>
        </div>
        <%
                    break;
            }
        %>

        <input type="submit" value="Continue" class="btn continue-btn" name="continue">
    </form>
</div>

</body>