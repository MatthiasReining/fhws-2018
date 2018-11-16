package de.fhws.app.presentation.showcase.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Standalone.xml entry
 * (<code>WILDFLY_HOME/standalone/configuration/standalone.xml</code>)
 * 
 * <pre>
 *  <datasource jndi-name="java:jboss/datasources/FHWSDS" pool-name=
"FHWSDS" enabled="true" use-java-context="true" statistics-enabled="true">
 *    <connection-url>jdbc:h2:tcp://localhost/C:/Users/matthias/dev/fhws/2018/db/storage</connection-url>
 *     <driver>h2</driver>
 *     <security>
 *       <user-name>sa</user-name>
 *       <password>sa</password>
 *    </security>
 *  </datasource>
 * </pre>
 * 
 * @author matthias
 *
 */
@WebServlet("tx")
public class TxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "java:jboss/datasources/FHWSDS")
	DataSource dataSource;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("JDBC Servlet");
		

		try {
			Connection conn = dataSource.getConnection();
			conn.setAutoCommit(false);

			conn.createStatement().execute("INSERT INTO TEST VALUES(32, 'Hey FHWS');");
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
