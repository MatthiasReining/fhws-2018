package de.fhws.app.showcase.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class JDBCTest {

	final static String DB_URL = "jdbc:h2:tcp://localhost/C:/Users/matthias/dev/fhws/2018/db/storage";
	final static String DB_USER = "sa";
	final static String DB_PW = "sa";

	static Connection conn;

	@BeforeClass
	public static void init() throws SQLException {
		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PW);
		conn.createStatement().execute("DROP table test");
		conn.createStatement().execute("CREATE TABLE TEST(ID INT PRIMARY KEY, NAME VARCHAR(255))");
		conn.setAutoCommit(false);
	}

	@AfterClass
	public static void after() throws SQLException {
		if (conn != null)
			conn.close();
	}

	@Test
	public void shouldRunInsertStatement() throws SQLException {
		Statement stmt = conn.createStatement();
		stmt.execute("INSERT INTO TEST VALUES(1, 'Hello FHWS');");
		conn.commit();
	}

	@Test
	public void shouldRunTwoCommits() throws SQLException {
		conn.createStatement().execute("INSERT INTO TEST VALUES(2, 'Hi FHWS');");
		conn.commit();
		conn.createStatement().execute("INSERT INTO TEST VALUES(3, 'Servus FHWS');");
		conn.commit();
	}

	@Test
	public void shouldRunWithRollback() throws SQLException {
		conn.createStatement().execute("INSERT INTO TEST VALUES(4, 'Hi World');");
		conn.commit();
		conn.createStatement().execute("INSERT INTO TEST VALUES(5, 'Servus World');");
		conn.rollback();
	}

	@Test
	public void selectData() throws SQLException {
		final String name1 = "Hi Students";
		final String name2 = "Hello Students";

		conn.createStatement().execute("INSERT INTO TEST VALUES(6, '" + name1 + "');");
		conn.createStatement().execute("INSERT INTO TEST VALUES(7, '" + name2 + "');");
		conn.commit();

		List<String> names = new ArrayList<>();
		ResultSet rs = conn.createStatement().executeQuery("SELECT id, name from TEST");
		while (rs.next()) {
			String name = rs.getString(2);
			names.add(name);
			System.out.println("name: " + name);
		}

		Assert.assertTrue(names.size() >= 2);
		Assert.assertTrue(names.contains(name1));
		Assert.assertTrue(names.contains(name2));

	}

	@Test
	public void selectDataWithSQLInjection() throws SQLException {
		conn.createStatement().execute("INSERT INTO TEST VALUES(8, 'Servus Studenten');");
		conn.commit();

		// String id = "8";
		String id = "8; Delete test";

		ResultSet rs = conn.createStatement().executeQuery("SELECT id, name from TEST WHERE id = " + id);

		ResultSet rs2 = conn.createStatement().executeQuery("select count(*) from test");
		rs2.next();
		long rows = rs2.getLong(1);
		Assert.assertEquals(0l, rows); // we were hacked.
	}

	@Test
	public void selectDataWithPreparedStatement() throws SQLException {
		final String name1 = "Servus Students";

		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO TEST VALUES(8, ?);");
		pstmt.setString(1, name1);
		pstmt.execute();
		conn.commit();

		// String id = "8";
		String hackedName = name1 + "; Delete test";

		pstmt = conn.prepareStatement("SELECT id, name from TEST WHERE name = ?");
		pstmt.setString(1, hackedName);
		pstmt.executeQuery();

		ResultSet rs2 = conn.createStatement().executeQuery("select count(*) from test");
		rs2.next();
		long rows = rs2.getLong(1);
		Assert.assertTrue(rows >= 1);
	}

	@Test
	public void shouldRollbackTx() throws SQLException {
		final String name1 = "Guten Tag Students";

		try {

			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO TEST VALUES(9, ?);");
			pstmt.setString(1, name1);
			pstmt.execute();

			System.out.println("Berechnung" + (42 / 0));
			conn.commit();

		} catch (Exception e) {
			conn.rollback();
		}
	}

	@Test
	public void shouldThrowContrainxception() throws SQLException {

		conn.createStatement().execute("INSERT INTO TEST VALUES(6, 'Hey FHWS');");
		conn.commit();

		try {
			System.out.println("bin da1");
			conn.createStatement().execute("INSERT INTO TEST VALUES(6, 'Hey FHWS');");
			System.out.println("bin da2");
			conn.commit();
		} catch (SQLException e) {
			System.out.println("Rollback " + e.getMessage());
			conn.rollback();
		}
	}

}
