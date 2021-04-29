package com.ssafy.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.Product;
import com.ssafy.util.DBUtil;

@Repository
public class ProductRepoImpl implements ProductRepo {

	@Autowired
	private DataSource dataSource;
	
	@Override
	public List<Product> selectAll() throws SQLException {
		List<Product> list = new LinkedList<Product>();
		
		StringBuilder sql = new StringBuilder();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			sql.append("select code, pname, company, price, discription from product_info");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("code"));
				product.setName(rs.getString("pname"));
				product.setCompany(rs.getString("company"));
				product.setPrice(rs.getInt("price"));
				product.setDescription(rs.getString("discription"));
				list.add(product);
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public Product select(String id) throws SQLException {
		Product product = null;
		
		StringBuilder sql = new StringBuilder();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			sql.append("select code, pname, company, price, discription from product_info where code = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				product = new Product();
				product.setId(rs.getString("code"));
				product.setName(rs.getString("pname"));
				product.setCompany(rs.getString("company"));
				product.setPrice(rs.getInt("price"));
				product.setDescription(rs.getString("discription"));
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return product;
	}

	@Override
	public int insert(Product product) throws SQLException {
		int result = -1;
		
		StringBuilder sql = new StringBuilder();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			sql.append("insert into product_info values(?, ?, ?, ?, ?)");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, product.getId());
			pstmt.setString(2, product.getName());
			pstmt.setString(3, product.getCompany());
			pstmt.setInt(4, product.getPrice());
			pstmt.setString(5, product.getDescription());
			result = pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt, conn);
		}
		return result;
	}

	@Override
	public int update(Product product) throws SQLException {
		int result = -1;
		
		StringBuilder sql = new StringBuilder();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			sql.append("update product_info set company=?, pname=?, price=?, discription=? where code=?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, product.getCompany());
			pstmt.setString(2, product.getName());
			pstmt.setInt(3, product.getPrice());
			pstmt.setString(4, product.getDescription());
			pstmt.setString(5, product.getId());
			result = pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt, conn);
		}
		return result;
	}

	@Override
	public int delete(String id) throws SQLException {
		int result = -1;
		
		StringBuilder sql = new StringBuilder();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			sql.append("delete from product_info where code=?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt, conn);
		}
		return result;
	}

}
