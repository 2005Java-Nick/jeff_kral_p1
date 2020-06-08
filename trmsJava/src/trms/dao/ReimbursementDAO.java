package trms.dao;

import trms.model.Reimbursement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDAO {
	
	private final String jdbcURL = "jdbc:postgresql://freuddb.c4hlxdpgql5j.us-east-2.rds.amazonaws.com:5432/FreudDB";
	private final String jdbcUsername = "postgres";
	
	
	
	private static final String INSERT_REIMBURSEMENT_SQL = "INSERT INTO reimbursement3 (re_id, re_first_name, re_last_name,"
			                                                       + "re_event_name, re_event_type, re_event_date, re_event_description, re_cost, re_grade_format,"
			                                                       + "re_work_justify, re_event_location ) VALUES  (nextVal('id_gen'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	
	private static final String SELECT_REIMBURSEMENT_BY_ID = "select * from reimbursement3 where re_id =?";
	private static final String SELECT_ALL_REIMBURSEMENT = "select * from reimbursement3";
	private static final String DELETE_REIMBURSEMENT_SQL = "delete from reimbursement3 where re_id = ?;";
	private static final String UPDATE_REIMBURSEMENT_SQL = "update reimbursement3 set re_first_name = ?,re_last_name= ?, re_event_name =?,"
			+ " re_event_type= ?, re_event_date = ?, re_event_description =?,  re_cost = ?,"
			+ "re_grade_format = ?, re_work_justify = ?, re_event_location = ? where re_id = ?;";
	
	public ReimbursementDAO() {
	}
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public void insertReimbursement(Reimbursement reimbursement) {
		System.out.println(INSERT_REIMBURSEMENT_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
		     PreparedStatement statement = connection.prepareStatement(INSERT_REIMBURSEMENT_SQL)) {
			statement.setString(1, reimbursement.getFirstName());
			statement.setString(2, reimbursement.getLastName());
			statement.setString(3, reimbursement.getEventName());
			statement.setString(4, reimbursement.getEventType());
			statement.setString(5, reimbursement.getEventDate());
			statement.setString(6, reimbursement.getEventDescription());
			statement.setDouble(7, reimbursement.getEventCost());
			statement.setString(8, reimbursement.getEventGradeFormat());
			statement.setString(9, reimbursement.getWorkJustification());
			statement.setString(10, reimbursement.getEventLocation());
			//statement.setString(10, reimbursement.getAttachment());
			//auto increment id
			System.out.println(statement);
			statement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public Reimbursement findById(int id) {
		Reimbursement reimbursement = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
		     // Step 2:Create a statement using connection object
		     PreparedStatement preparedStatement = connection.prepareStatement(SELECT_REIMBURSEMENT_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				reimbursement = makeObject(rs);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return reimbursement;
	}
	
	
	public List<Reimbursement> getAllReimbursements() {
		
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Reimbursement> reimbursements = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
		
		     // Step 2:Create a statement using connection object
		     PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_REIMBURSEMENT);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				final Reimbursement reimbursement = makeObject(rs);
				reimbursements.add(reimbursement);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return reimbursements;
	}
	
	private Reimbursement makeObject(ResultSet rs) throws SQLException {
		String id = rs.getString("re_id");
		String firstName = rs.getString("re_first_name");
		String lastName = rs.getString("re_last_name");
		String eventName = rs.getString("re_event_name");
		String eventType = rs.getString("re_event_type");
		String eventDate = rs.getString("re_event_date");
		String eventDescription = rs.getString("re_event_description");
		double eventCost = rs.getDouble("re_cost");
		String gradeFormat = rs.getString("re_grade_format");
		String workJustify = rs.getString("re_work_justify");
		String eventLocation = rs.getString("re_event_location");
		return new Reimbursement(id, firstName, lastName, eventName, eventType, eventDate,
				eventDescription, eventCost, gradeFormat, workJustify, eventLocation);
	}
	
	public boolean deleteReimbursement(int id)  {
		boolean rowDeleted = false;
		try (Connection connection = getConnection();
		     PreparedStatement statement = connection.prepareStatement(DELETE_REIMBURSEMENT_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}
	
	public boolean updateReimbursement(int id, Reimbursement reimbursement)  {
		boolean rowUpdated = false;
	
		try (Connection connection = getConnection();
		     PreparedStatement statement = connection.prepareStatement(UPDATE_REIMBURSEMENT_SQL);) {
			statement.setString(1, reimbursement.getFirstName());
			statement.setString(2, reimbursement.getLastName());
			statement.setString(3, reimbursement.getEventName());
			statement.setString(4, reimbursement.getEventType());
			statement.setString(5, reimbursement.getEventDate());
			statement.setString(6, reimbursement.getEventDescription());
			statement.setDouble(7, reimbursement.getEventCost());
			statement.setString(8, reimbursement.getEventGradeFormat());
			statement.setString(9, reimbursement.getWorkJustification());
			statement.setString(10, reimbursement.getEventLocation());
			statement.setString(11, reimbursement.getId());
			
			rowUpdated = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
	
}
