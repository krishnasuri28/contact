package com.contact;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ContactRowMapper implements RowMapper<Contact>{

	@Override
	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Contact(rs.getInt("contact_id"),rs.getString("name"), rs.getString("email"), rs.getString("address"),
				rs.getString("phone"));
	}
}
