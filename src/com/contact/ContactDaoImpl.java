package com.contact;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class ContactDaoImpl implements ContactDao {

	private JdbcTemplate jdbcTemplate;

	public ContactDaoImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int save(Contact contact) {
		String sql = "INSERT into contact (name,email,address,phone) VALUES (?,?,?,?)";
		return jdbcTemplate.update(sql, contact.getName(), contact.getEmail(), contact.getAddress(),
				contact.getPhone());
	}

	@Override
	public int update(Contact contact) {
		String sql = "UPDATE contact set name= ? , email=?,address=?,phone=? where contact_id = ?";
		return jdbcTemplate.update(sql, contact.getName(), contact.getEmail(), contact.getAddress(), contact.getPhone(),
				contact.getContact_id());
	}

	@Override
	public Contact get(Integer id) {
		String sql = "Select * from contact where contact_id=" + id;
		ResultSetExtractor<Contact> extractor = new ResultSetExtractor<Contact>() {

			@Override
			public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Contact result = new Contact(id,rs.getString("name"), rs.getString("email"), rs.getString("address"),
							rs.getString("phone"));
					return result;
				} else {
					return null;
				}
			}
		};
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM contact where contact_id=" + id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Contact> list() {
		String sql = "SELECT * from contact";
		
		return jdbcTemplate.query(sql,new ContactRowMapper());
	}
}
