package de.fhws.app.presentation.showcase.db;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class ORMapper {
	Connection conn;

	public ORMapper(Connection conn) {
		this.conn = conn;
	}

	public void save(DBObject dbo) {

		String clazzName = dbo.getClass().getSimpleName();
		String tableName = clazzName;

		try {

			String sql = "INSERT into " + tableName + "(";

			ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM " + tableName);
			ResultSetMetaData meta = rs.getMetaData();

			List<String> columnNames = new ArrayList<>();
			for (int i = 0; i < meta.getColumnCount(); i++)
				columnNames.add(meta.getColumnName(i + 1));

			sql += String.join(", ", columnNames.toArray(new String[] {}));
			sql += ")";

			sql += " values (";
			StringJoiner sj = new StringJoiner(", ");
			for (int i = 0; i < meta.getColumnCount(); i++)
				sj.add("?");
			sql += sj.toString() + ");";

			// insert into jdbclog(logTime, comment) values(?,?);
			PreparedStatement pstmt = conn.prepareStatement(sql);

			for (int i = 1; i <= meta.getColumnCount(); i++) {
				String columnName = meta.getColumnName(i);
				String methodName = "get" + columnName.substring(0, 1).toUpperCase() + columnName.substring(1).toLowerCase();

				Method method = dbo.getClass().getMethod(methodName, new Class[] {});

				Object value = method.invoke(dbo, new Object[] {});

				pstmt.setObject(i, value);
			}
			
			pstmt.executeUpdate();

		} catch (SQLException | NoSuchMethodException | SecurityException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}

	}

}
