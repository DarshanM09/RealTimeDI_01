package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.nit.bo.customerBo;

public class CustomerDAOImpl implements iCustomerDAO {

	private static final String CUST_INSERT_QUERY = "INSERT INTO `realtime_customerdisc`.`custome_new_disc`  VALUES (?,?,?,?,?,?)";
	private DataSource ds;

	int result = 0;

	public CustomerDAOImpl(DataSource ds) {
		System.out.println("CustomerDAOImpl.CustomerDAOImpl()");
		this.ds = ds;
	}

	@Override
	public int insertCustomer(customerBo bo) throws Exception {

		Connection con = null;
		PreparedStatement ps = null;
		try {

			con = ds.getConnection();
			ps = con.prepareStatement(CUST_INSERT_QUERY);
			ps.setInt(1, bo.getCno());
			ps.setString(2, bo.getCname());
			ps.setString(3, bo.getCadd());
			ps.setFloat(4, bo.getTotalBillamount());
			ps.setFloat(5, bo.getBillamount());
			ps.setFloat(6, bo.getDiscount());

			int result = ps.executeUpdate();

		} catch (SQLException se) {

			se.printStackTrace();
			throw se;

		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
				throw e2;

			}

			try {
				if (ps != null) {
					ps.close();
				}

			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
				throw e2;

			}
		}

		return result;
	}

}
