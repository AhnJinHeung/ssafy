package com.ssafy.hw09;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ProductMgrImpl extends Thread implements IProductMgr {
	private static ProductMgrImpl manager = null;
	private ArrayList<Product> products;
	
	private ProductMgrImpl() {
		products = new ArrayList<>();
		load();
	}
	
	public static ProductMgrImpl getInstance() {
		if (manager == null) manager = new ProductMgrImpl();
		return manager;
	}
	
	public void add(Product p) throws DuplicateException {
		if (products.contains(p)) {
			throw new DuplicateException("예외 발생! 이미 존재하는 상품입니다.");
		}
		products.add(p);
	}
	
	public void list() {
		for (Product p : products) {
			System.out.println(p);
		}
	}
	
	public void list(int num) throws CodeNotFoundException {
		for (Product p : products) {
			if (p.getNumber() == num) {
				System.out.println(p);
				return;
			}
		}
		throw new CodeNotFoundException("예외 발생! 상품 번호가 존재하지 않습니다.");
	}
	
	public void list(String name) {
		for (Product p : products) {
			if (p.getName().contains(name)) {
				System.out.println(p);
			}
		}
	}
	
	public void listTV() {
		for (Product p : products) {
			if (p instanceof TV) {
				System.out.println(p);
			}
		}
	}
	
	public void listRef() {
		for (Product p : products) {
			if (p instanceof Refrigerator) {
			System.out.println(p);
			}
		}
	}
	
	public void overCapacity() throws ProductNotFoundException { // 냉장고
		int cnt = 0;
		for (Product p : products) {
			if (p instanceof Refrigerator) {
				if (((Refrigerator) p).getCapacity() >= 400) {
					System.out.println(p);
					cnt++;
				}
			}
		}
		if (cnt == 0) {
			throw new ProductNotFoundException("예외 발생! 상품이 존재하지 않습니다.");
		}
	}
	
	public void overInch() throws ProductNotFoundException { // TV
		int cnt = 0;
		for (Product p : products) {
			if (p instanceof TV) {
				if (((TV) p).getInch() >= 50) {
					System.out.println(p);
					cnt++;
				}
			}
		}
		if (cnt == 0) {
			throw new ProductNotFoundException("예외 발생! 상품이 존재하지 않습니다.");
		}
	}
	
	public void update(int num, int price) {
		for (int i=0; i<products.size(); i++) {
			if (products.get(i).getNumber() == num) {
				products.get(i).setPrice(price);
				break;
			}
		}
	}
	
	public void delete(int num) {
		for (int i=0; i<products.size(); i++) {
			if (products.get(i).getNumber() == num) {
				products.remove(i);
				break;
			}
		}
	}
	
	public void totalPrice() {
		int total = 0;
		for (Product p : products) {
			total += p.getPrice();
		}
		System.out.println(total);
	}
	
	public void save() {
		File f = new File("product.dat");
		synchronized(f) {
			try (ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(f))){
				oos.writeObject(products);
				oos.flush();
				System.out.println("[SYSTEM] 파일 쓰기 성공");
			} catch (Exception e) {
				System.out.println("[SYSTEM] 파일 쓰기 실패");
				e.printStackTrace();
			}
			products = null;
		}
	}
	
	public void load() {
		File f = new File("product.dat");
		if(f.exists()) {
			try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f))){
				products = (ArrayList<Product>)ois.readObject();
				System.out.println("[SYSTEM] 파일 읽기 성공");
			} catch (IOException | ClassNotFoundException e) {
				System.out.println("[SYSTEM] 파일 읽기 실패");
			}
		}
		else System.out.println("product.dat 파일이 존재하지 않습니다.");
	}

	@Override
	public void run() {
		System.out.println("Thread start");
		save();
		System.out.println("Thread end");
	}
}
