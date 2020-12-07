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
        if (registerBean.checkFields()) {
%>
            <div style="align-content: center; color: red; justify-content: center; align-items: center;">
                <p style="font-weight: bold; color: white; background: red; margin: 0 auto; padding: 1em; text-align: center">Please insert valid data</p>
            </div>
<%
        } else {
            switch (request.getParameter("register")) {

                case "Band Room":
                    if (registerBean.checkName()) {
%>
                        <div style="align-content: center; color: red; justify-content: center; align-items: center;">
                            <p style="font-weight: bold; color: white; background: red; margin: 0 auto; padding: 1em; text-align: center">Please insert a valid Name</p>
                        </div>
<%
                    } else {
                        userBean = registerBean.registerUser(3);
                        if (userBean != null) {
                            //Forward to page with user parameters
                        } else {
                            //Display error message
%>
                            <div style="align-content: center; color: red; justify-content: center; align-items: center;">
                                <p style="font-weight: bold; color: white; background: red; margin: 0 auto; padding: 1em; text-align: center">Something went wrong during registration process</p>
                            </div>
<%
                        }
                    }
                    break;

                case "Band":
                    if (registerBean.checkName()) {
%>
                            <div style="align-content: center; color: red; justify-content: center; align-items: center;">
                                <p style="font-weight: bold; color: white; background: red; margin: 0 auto; padding: 1em; text-align: center">Please insert a valid Name</p>
                            </div>
<%
                    } else {
                        userBean = registerBean.registerUser(2);
                        if (userBean != null) {
                            //Forward to page with user parameters
                        } else {
                            //Display error message
%>
                            <div style="align-content: center; color: red; justify-content: center; align-items: center;">
                                <p style="font-weight: bold; color: white; background: red; margin: 0 auto; padding: 1em; text-align: center">Something went wrong during registration process</p>
                            </div>
<%
                        }
                    }
                    break;
                case "Solo":
                    userBean = registerBean.registerUser(1);
                    if (userBean != null) {
                        //Forward
                    } else {
%>
                        <div style="align-content: center; color: red; justify-content: center; align-items: center;">
                            <p style="font-weight: bold; color: white; background: red; margin: 0 auto; padding: 1em; text-align: center">Something went wrong during registration process</p>
                        </div>
<%
                    }
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
            <input type="text" name="name" id="band-name" value="" class="band-name-form"
                   placeholder="Band Name...">
        </div>
        <%
                break;
            case "Band Room":
        %>
        <div class="specific-form">
            <input type="text" name="name" id="band-room-name" value="" class="band-name-form"
                   placeholder="Band Room Name...">
        </div>
        <%
                break;
            case "Solo":
                break;
            }
        %>

        <input type="submit" value="Continue" class="btn continue-btn" name="continue">
    </form>
</div>

</body>