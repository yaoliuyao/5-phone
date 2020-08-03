package nfit.phone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import nfit.phone.bean.Phone;

public class PhoneDAO {
	public void insert(String name, float price) throws Exception {
		String sql = "insert into my_phone (name, price) values (?, ?)";
		System.out.println("要执行的语句是: " + sql);
		
		try (Connection connection = nfit.phone.utils.DBHelper.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, name);
			statement.setFloat(2, price);
			statement.executeUpdate();
		}
	}
	
	public void delete(int id) throws Exception {
		String sql = "delete  from my_phone where id = ?";
		try (Connection connection = nfit.phone.utils.DBHelper.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id);
			int rows = statement.executeUpdate();
			System.out.println("Delete rows count: " + rows);
		}
	}
	
	public List<Phone> list() throws Exception {
		List<Phone> phones = new ArrayList<Phone>();
		
		String sql = "select id, name, price from my_phone";
		try (Connection connection = nfit.phone.utils.DBHelper.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet resultSet = statement.executeQuery()) {
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				float price = resultSet.getFloat(3);
				
				Phone phone = new Phone();
				phone.setId(id);
				phone.setName(name);
				phone.setPrice(price);
				phones.add(phone);
			}
			return phones;
		}
	}

}
