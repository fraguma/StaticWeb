package mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author escofet
 */
@WebServlet(name = "PicServlet", urlPatterns = {"/showpic"})
public class PicServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger("staticweb.mypackage.PicServlet");
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>  methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //String content = new String(Files.readAllBytes(Paths.get("htmllist.html")));
        try (PrintWriter out = response.getWriter()) {
            out.println(" <!DOCTYPE html>\n" +
                            "<html>\n" +
                            "<body>\n" +
                            "\n" +
                            "<h2>Spectacular Mountain</h2>\n" +
                            "<img src=\"/images/pic_mountain.jpg\" alt=\"Mountain View\" style=\"width:304px;height:228px;\">\n" +
                            "\n" +
                            "</body>\n" +
                            "</html>" );
            logger.info("Ok");
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch(IOException e) {
            logger.error("Error accessing file " + e.getLocalizedMessage());
        }
    }
    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch(IOException e) {
            logger.error("Error accessing file " + e.getLocalizedMessage());
        }
    }
    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return null;
    }// </editor-fold>
}
