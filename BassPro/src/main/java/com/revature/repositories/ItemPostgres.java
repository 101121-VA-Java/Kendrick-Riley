package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.daos.ItemDao;
import com.revature.models.Employee;
import com.revature.models.Item;

import Utilites.ConnectionUtil;

public class ItemPostgres implements ItemDao {


	@Override
	public List<Item> getAll() {
		String sql = "select * from items;";
		List<Item> items = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("i_id");
				String decription = rs.getString("i_decription");
				int i_quantity = rs.getInt("i_quantity");
				double i_itemprice = rs.getDouble("i_itemprice");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
		
			e1.printStackTrace();
		}
		return items;
}	public Item add(Item item) {
	String sql = "insert into item ( i_decription, i_quantity, i_itemprice) "
			+ "values (?, ?, ?,) returning i_id;";

	try (Connection con = ConnectionUtil.getConnectionFromFile()) {
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, item.getDecription());
		ps.setInt(2, item.getQuantity());
		ps.setDouble(3, item.getPrice());
	
		

		ResultSet rs = ps.executeQuery();

//		if (rs.next()) {
//			genId = rs.getInt("e_id");
//		}

	} catch (SQLException | IOException e1) {
	
		e1.printStackTrace();
	}

	return item;
}
@Override
public Item getById(int id) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean update(Item t) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public Item delete(Item item) {
	String sql = "delete from Item where i_id = ?;";
	int rowsChanged = -1;
	int id = item.getId();
	
	try (Connection con = ConnectionUtil.getConnectionFromFile();) {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
				
		rowsChanged = ps.executeUpdate();
	}
	catch (SQLException | IOException e) {
	
		e.printStackTrace();
	}
	if(rowsChanged > 0) {
		return null;
	}else {
		return item;
	}
}

}