package com.task.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bookLords.model.User;

import model.DBConnection;

public class SearchDao {

	private Connection connection = DBConnection.getInstance().getConnection();

	private static final String CHECK_NAME_SQL = "select t.FULL_NAME,t.PIN, a.ADDR_TYPE, a.ADDR_INFO, m.EMAIL_TYPE, m.EMAIL"
			+ "from t_people t join t_addresses a" + "on t.ID = a.ID" + "join t_mails m" + "on t.ID = m.ID"
			+ "where UPPER(t.FULL_NAME) = UPPER(?);";

	public ArrayList<String> getPerson(String name) {
		ArrayList<String> list = new ArrayList<>();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(CHECK_NAME_SQL);
			preparedStatement.setString(1, name);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String fullName = resultSet.getString(1);
				list.add(fullName);
				String pin = resultSet.getString(2);
				list.add(pin);
				String addrType = resultSet.getString(3);
				list.add(addrType);
				String addrInfo = resultSet.getString(4);
				list.add(addrInfo);
				String emailType = resultSet.getString(5);
				list.add(emailType);
				String email = resultSet.getString(6);
				list.add(email);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
