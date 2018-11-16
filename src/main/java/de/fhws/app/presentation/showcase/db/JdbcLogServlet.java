package de.fhws.app.presentation.showcase.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("jdbc-log")
public class JdbcLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "java:jboss/datasources/FHWSDS")
	DataSource dataSource;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		JdbcLog log = new JdbcLog(new Date(), "just a test2");

		try {
			Connection conn = dataSource.getConnection();
			conn.setAutoCommit(false);

			//PreparedStatement pstmt = conn.prepareStatement("INSERT into JDBCLOG (logTime, comment) values (?, ?)");
			//pstmt.setTimestamp(1, new java.sql.Timestamp(log.getLogtime().getTime()));
			//pstmt.setString(2, log.getComment());
			//pstmt.executeUpdate();
			
			new ORMapper(conn).save(log);

			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
