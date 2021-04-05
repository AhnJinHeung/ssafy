package com.ssafy.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.member.dto.ProductDto;
import com.ssafy.util.DBUtil;

public class ProductDaoImpl implements ProductDao {

	private static ProductDao productDao;
	
	private ProductDaoImpl() {}
	
	public static ProductDao getProductDao() {
		if(productDao == null)
			productDao = new ProductDaoImpl();
		return productDao;
	}
	
	@Override
	public void registerProduct(ProductDto productDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnect();
			StringBuilder insertMember = new StringBuilder();
			insertMember.append("insert into product (num, name, price, discription) \n");
			insertMember.append("values (?, ?, ?, ?)");
			pstmt = conn.prepareStatement(insertMember.toString());
			pstmt.setString(1, productDto.getNum());
			pstmt.setString(2, productDto.getName());
			pstmt.setString(3, productDto.getPrice());
			pstmt.setString(4, productDto.getDiscription());
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt, conn);
		}
	}

	@Override
	public List<ProductDto> listProduct() throws SQLException {
		List<ProductDto> list = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		String sql = "select * from product order by num desc";
		try {
			con = DBUtil.getConnect();
			pstmt = con.prepareStatement(sql);
			rst = pstmt.executeQuery();
			ProductDto dto = null;
			while(rst.next()) {
				dto = new ProductDto();
				dto.setNum(rst.getString(1));
				dto.setName(rst.getString(2));
				dto.setPrice(rst.getString(3));
				dto.setDiscription(rst.getString(4));
				list.add(dto);
			}	
			
		}finally {
			DBUtil.close(rst, pstmt, con);
		}
		
		return list;
	}

	@Override
	public ProductDto getProduct(int num) throws SQLException {
		ProductDto dto = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		String sql = "select * from product where num = ?";
		try {
			con = DBUtil.getConnect();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rst = pstmt.executeQuery();
			if(rst.next()) {
				dto = new ProductDto();
				dto.setNum(rst.getString(1));
				dto.setName(rst.getString(2));
				dto.setPrice(rst.getString(3));
				dto.setDiscription(rst.getString(4));
			}	
		}finally {
			DBUtil.close(rst, pstmt, con);
		}
		return dto;
	}

	@Override
	public void modifyProduct(ProductDto productDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnect();
			StringBuilder sql = new StringBuilder();
			sql.append("update product set price = ?, discription = ? where num = ? and name = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, productDto.getPrice());
			pstmt.setString(2, productDto.getDiscription());
			pstmt.setString(3, productDto.getNum());
			pstmt.setString(4, productDto.getName());
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt, conn);
		}
	}

	@Override
	public void deleteProduct(int num) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnect();
			StringBuilder sql = new StringBuilder();
			sql.append("delete from product where num = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, Integer.toString(num));
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt, conn);
		}
	}
	
	public List<ProductDto> serchProduct(String key, String gubun) throws SQLException {
		List<ProductDto> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnect();
			String sql = "select * \n";
			sql += "from product \n";
			if (gubun.equals("searchName")) {
				sql += "where name = ?";
			}
			else if (gubun.equals("searchPrice")) {
				sql += "where price <= ?";
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductDto productDto = new ProductDto();
				productDto.setNum(rs.getString("num"));
				productDto.setName(rs.getString("name"));
				productDto.setPrice(rs.getString("price"));
				productDto.setDiscription(rs.getString("discription"));
				
				list.add(productDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		
		return list;
	}
}
