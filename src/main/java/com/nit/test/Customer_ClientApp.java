package com.nit.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nit.controller.MainController;
import com.nit.vo.customerVo;


public class Customer_ClientApp {
	public static void main(String[] args) {
		//create ioc continer
		
		DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
	   XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
	   reader.loadBeanDefinitions("com/nit/cfgs/applicationContext.xml");
	   
	   //get springbean class obj refrence	
	   MainController controller=factory.getBean("controller",MainController.class);
	   //read input as a string value and store them in a customervo  class obj
	   
	   Scanner sc=new Scanner(System.in);
	   System.out.println("Enter Customer number :: ");
	   String cnumber = sc.next();
	   System.out.println("Enter Customer Name :: ");
	   String cname = sc.next();
	   System.out.println("Enter Customer Address :: ");
	   String cadd = sc.next();
	   System.out.println("Enter Customer Total Bill Aamount :: ");
	   String totalbill = sc.next();
	   
	   customerVo vo=new customerVo();
	   vo.setCno(cnumber);
	   vo.setCname(cname);
	   vo.setCadd(cadd);
	   vo.setTotalBillamount(totalbill);
	   //invoke methods
	   
	   try {
		
		   String result=controller.processEmployee(vo);
		   System.out.println(result);
		   
	} catch (Exception e) {
		e.printStackTrace();
	}
	   
	   
	}
}
