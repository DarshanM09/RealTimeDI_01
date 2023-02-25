package com.nit.controller;

import com.nit.dto.customerDTO;
import com.nit.service.iCustomerMngtService;
import com.nit.vo.customerVo;

public class MainController {

	private iCustomerMngtService service;

	public MainController(iCustomerMngtService service) {
		System.out.println("MainController.MainController()");
		this.service = service;
	}

	public String processEmployee(customerVo vo) throws Exception {
		// convert employeevo obj to empdto obj
		customerDTO dto = new customerDTO();
		dto.setCno(Integer.parseInt(vo.getCno()));
		dto.setCname(vo.getCname());
		dto.setCadd(vo.getCadd());
		dto.setTotalBillamount(Float.parseFloat(vo.getTotalBillamount()));

		// use service
		String registerCust = service.registerCustomer(dto);

		return registerCust;

	}

}
