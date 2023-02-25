package com.nit.service;

import com.nit.bo.customerBo;
import com.nit.dao.iCustomerDAO;
import com.nit.dto.customerDTO;

public class CustomerMngtServiceImpl implements iCustomerMngtService {

	private iCustomerDAO dao;

	public CustomerMngtServiceImpl(iCustomerDAO dao) {
		System.out.println("CustomerMngtServiceImpl.CustomerMngtServiceImpl()");

		this.dao = dao;
	}

	@Override
	public String registerCustomer(customerDTO dto) throws Exception {

		float discount = 0f;
		if (dto.getTotalBillamount() > 1000 && dto.getTotalBillamount() < 2000) {
			discount = dto.getTotalBillamount() - dto.getTotalBillamount() * 0.2f;
		} else if (dto.getTotalBillamount() > 2000 && dto.getTotalBillamount() < 4000) {
			discount = dto.getTotalBillamount() - dto.getTotalBillamount() * 0.3f;
		}

		else if (dto.getTotalBillamount() > 4000) {
			discount = dto.getTotalBillamount() - dto.getTotalBillamount() * 0.5f;
		}
		float bill = dto.getTotalBillamount() - discount;

		customerBo bo = new customerBo();
		bo.setCno(dto.getCno());
		bo.setCname(dto.getCname());
		bo.setCadd(dto.getCadd());
		bo.setTotalBillamount(dto.getTotalBillamount());
		bo.setDiscount(discount);
		bo.setBillamount(bill);
		int insertCustomer = dao.insertCustomer(bo);

		return insertCustomer == 1 ? "Customer Register with Bill ::" + bill
				: "Customer not register rwith Bill" + bill;

	}

}
