package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.bean.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	private ProductDao productDao;

	public ProductServiceImpl() {
		productDao=new ProductDaoImpl();
		
	}
	Scanner sc=new Scanner(System.in);
	@Override
	public void addProduct() {
		System.out.println("enter id");
		int id=sc.nextInt();
		
		System.out.println("enter name");
		String nm=sc.next();
		System.out.println("enter id");
		int qty=sc.nextInt();
		Product p=new Product(id,nm,qty);
		productDao.addProduct(p);
	}

	@Override
	public List<Product> displayAll() {
		return productDao.getAllProducts();
		
	}

	@Override
	public Product searchProduct(int id) {
		return productDao.searchById(id);
	}

	@Override
	public void deleteProduct(int id) {
		productDao.deleteProduct(id);
	}

	@Override
	public Product displayById(int id) {
		return productDao.displayById(id);
	}

	@Override
	public void modifyProduct(int id) {
		System.out.println("enter modified name ");
		String mname=sc.next();
		System.out.println("enter modified price ");
		int mprice=sc.nextInt();
		deleteProduct(id);
		Product p=new Product(id,mname,mprice);
		productDao.addProduct(p);
		
	}
	

}
