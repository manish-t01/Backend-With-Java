package com.backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/submitform")
public class MyServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String myname1 = req.getParameter("name1");
        String myemail1 = req.getParameter("email1");

        // Print on Eclipse console
        System.out.println("Name 1: " + myname1);
        System.out.println("Email 1: " + myemail1);

        // Tell browser that we are sending HTML
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");

        out.println("<title>Welcome</title>");

        out.println("<style>");

        out.println("""
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                font-family: Arial, sans-serif;
            }

            body {
                min-height: 100vh;
                display: flex;
                justify-content: center;
                align-items: center;

                background: linear-gradient(
                    135deg,
                    #0f172a,
                    #1e3a8a,
                    #312e81
                );

                background-size: 300% 300%;
                animation: backgroundMove 8s ease infinite;
            }

            .card {
                width: 400px;
                padding: 40px;

                background: rgba(255, 255, 255, 0.12);
                backdrop-filter: blur(15px);

                border: 1px solid rgba(255, 255, 255, 0.2);
                border-radius: 20px;

                color: white;
                text-align: center;

                box-shadow: 0 25px 50px rgba(0,0,0,0.35);

                animation: appear 0.8s ease;
            }

            h1 {
                margin-bottom: 25px;
                font-size: 30px;
            }

            p {
                margin: 15px 0;
                padding: 14px;

                background: rgba(255,255,255,0.1);
                border-radius: 10px;

                transition: 0.3s;
            }

            p:hover {
                transform: translateY(-3px);
                background: rgba(255,255,255,0.2);
            }

            @keyframes backgroundMove {
                0% {
                    background-position: 0% 50%;
                }

                50% {
                    background-position: 100% 50%;
                }

                100% {
                    background-position: 0% 50%;
                }
            }

            @keyframes appear {
                from {
                    opacity: 0;
                    transform: translateY(40px) scale(0.95);
                }

                to {
                    opacity: 1;
                    transform: translateY(0) scale(1);
                }
            }
        """);

        out.println("</style>");
        out.println("</head>");

        out.println("<body>");

        out.println("<div class='card'>");

        out.println("<h1>🎉 Welcome 🎉</h1>");

        out.println("<p>" + myname1 + "</p>");
        out.println("<p>" + myemail1 + "</p>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}