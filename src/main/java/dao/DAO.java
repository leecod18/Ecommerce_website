package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Account;
import entity.Category;
import context.DBContext;
import entity.Product;

public class DAO {
	// LOAD du lieu tu db len

	Connection conn = null;
	// connect voi mysql
	PreparedStatement ps = null;
	// nem cau lenh sang query sang mysql
	ResultSet rs = null;

	public List<Product> getAllProduct() {
		List<Product> list = new ArrayList<>();
		String query = "select * from product";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery(query);

			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5)));
			}
		} catch (Exception e) {

		}
		return list;
	}

	public List<Category> getAllCategory() {
		List<Category> list = new ArrayList<>();
		String query = "select * from category";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Category(rs.getInt(1), rs.getString(2)));
			}
		} catch (Exception e) {

		}
		return list;
	}

	public Product getLast() {
		String query = "select * from product order by id desc limit 1";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	public List<Product> getProductByCID(String cid) {
		List<Product> list = new ArrayList<>();
		String query = "select * from product where cateID = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, cid);
			// set cid vao dau cham hoi thu nhat
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5)));
			}
		} catch (Exception e) {

		}
		return list;
	}

	public Product getProductByID(String id) {
		String query = "select * from product where id = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			// set cid vao dau cham hoi thu nhat
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5));
			}
		} catch (Exception e) {

		}
		return null;
	}

	public List<Product> searchByName(String txtSearch) {
		List<Product> list = new ArrayList<>();
		String query = "select * from product where name like  ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + txtSearch + "%");
			// set cid vao dau cham hoi thu nhat
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5)));
			}
		} catch (Exception e) {

		}
		return list;
	}

	public Account login(String user, String pass) {
		String query = "select * from account where user = ? and pass = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public Account checkAccountExit(String user) {
		String query = "select * from account where user = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public void signUp(String user, String pass) {
		String query = "INSERT INTO account (user,pass,isSell, isAdmin) VALUES (?,?,0,0)";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public List<Product> getProductBySellID(int id) {
		List<Product> list = new ArrayList<>();
		String query = "select * from product where sell_ID = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			// set cid vao dau cham hoi thu nhat
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5)));
			}
		} catch (Exception e) {

		}
		return list;
	}

	public void deleteProduct(String pid) {
		String query = "delete from product where id = ?";

		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, pid);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void insertProduct(String name, String image, String price, String title, String description, String category, int sid) {
		String query = "INSERT INTO  product(name,image,price,title,description,cateID, sell_ID)" + " VALUES(?,?,?,?,?,?,?)";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, image);
			ps.setString(3, price);
			ps.setString(4, title);
			ps.setString(5, description);
			ps.setString(6, category);
			ps.setInt(7, sid);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Product loadProductByID(String id) {
		String query = "select * from product where id = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			// set cid vao dau cham hoi thu nhat
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5));
			}

		} catch (Exception e) {

		}
		return null;

	}

	public void editProduct(String name, String image, String price, String title, String description, String category, String pid) {
		String query = "update product \r\n" + "set name = ?,image=?,price=?,title=?,description=?, cateID=?" + "where id = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, image);
			ps.setString(3, price);
			ps.setString(4, title);
			ps.setString(5, description);
			ps.setString(6, category);
			ps.setString(7, pid);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Product find(String id) {
		String query = "select * from product where id = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			// set cid vao dau cham hoi thu nhat
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5));
			}

		} catch (Exception e) {

		}
		return null;

	}

	public List<Product> findAll(String id) {
		List<Product> list = new ArrayList<>();
		String query = "select * from product where id = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			// set cid vao dau cham hoi thu nhat
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5)));
			}

		} catch (Exception e) {

		}
		return null;

	}

	public Account loadAccount(String id) {
		String query = " select * from account where uID= ? ";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public void updatePass(Account a) {
		String query = "update account set pass=? where user =?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, a.getPass());
			ps.setString(2, a.getUser());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Account checkPass(String pass, String id) {
		String query = "select * from account where pass = ? and uID= ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, pass);
			ps.setString(2, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	// test
	public static void main(String[] args) {
		DAO dao = new DAO();
	
		List<Category> list = dao.getAllCategory();
		System.out.println(list);

	}

}
