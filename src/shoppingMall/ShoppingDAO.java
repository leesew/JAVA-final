package shoppingMall;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ShoppingUtil.DBManager;
import customer.CustomerDAO;

public class ShoppingDAO {
	private static final Logger LOG = LoggerFactory.getLogger(ShoppingDAO.class);
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	private String pId;
	private String sQuantity;

	public ArrayList<Products> mainProducts() { // 메인화면에 노출되는 랜덤 5개 상품
		ArrayList<Products> mainList = new ArrayList<Products>();
		conn = DBManager.getConnection();
		String sql = "select * from products order by rand() limit 5;";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Products products = new Products();
				products.setpId(Integer.toString(rs.getInt(1)));
				products.setpName(rs.getString(2));
				products.setpUnitPrice(Integer.toString(rs.getInt(3)));
				products.setpImgName(rs.getString(4));
				products.setpDescription(rs.getString(5));
				mainList.add(products);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.info("Error Code : {}", e.getErrorCode());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return mainList;
	}

	public ArrayList<Products> AllByProducts(String pId) { // 상품목록
		ArrayList<Products> categoryList = new ArrayList<Products>();
		conn = DBManager.getConnection();
		String sql = "select * from products where p_id >= ? limit 5;";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(pId));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Products products = new Products();
				products.setpId(Integer.toString(rs.getInt(1)));
				products.setpName(rs.getString(2));
				products.setpUnitPrice(Integer.toString(rs.getInt(3)));
				products.setpImgName(rs.getString(4));
				products.setpDescription(rs.getString(5));
				categoryList.add(products);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.info("Error Code : {}", e.getErrorCode());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return categoryList;
	}

	public Products selectOneProduct(String pId) { // 상품 하나
		LOG.trace("selectOneProduct()");
		conn = DBManager.getConnection();
		String sql = "select*from products where p_id=?";
		Products product = new Products();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(pId));
			rs = pstmt.executeQuery();
			rs.next();
			product.setpId(Integer.toString(rs.getInt(1)));
			product.setpName(rs.getString(2));
			product.setpUnitPrice(Integer.toString(rs.getInt(3)));
			product.setpImgName(rs.getString(4));
			product.setpDescription(rs.getString(5));
			rs.close();
			return product;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public int getOrderId(String cId) {
		LOG.trace("getOrderId()");
		conn = DBManager.getConnection();
		int orderId = 0;
		String sql = "select o_id from orders where o_customerId=? order by o_id desc limit 1";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(cId));
			rs = pstmt.executeQuery();
			rs.next();
			orderId = rs.getInt(1);
			rs.close();
			return orderId;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return orderId;
	}

	public void insertOrder(String cId, String price) {
		conn = DBManager.getConnection();
		String sql = "insert into orders ( o_customerId, o_date, o_price) values (?, now(), ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(cId));
			pstmt.setInt(2, Integer.parseInt(price));
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void insertSoldProduct(String orderId, String productId, String quantity) { // sold_products에 insert
		LOG.trace("insertSoldProduct()");
		LOG.debug(orderId + ", " + productId + ", " + quantity);
		conn = DBManager.getConnection();
		String sql = "insert into sold_products(s_orderId, s_productId, s_quantity) values (?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(orderId));
			pstmt.setInt(2, Integer.parseInt(productId));
			pstmt.setInt(3, Integer.parseInt(quantity));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.info("Error Code : {}", e.getErrorCode());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public ArrayList<Orders> selectOrderList(String cId) {
		ArrayList<Orders> orderList = new ArrayList<Orders>();
		LOG.trace("selectOrderList()");
		conn = DBManager.getConnection();
		String sql = "select o_id, o_price, date(o_date) from orders where o_customerId=?;";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(cId));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Orders order = new Orders();
				order.setoId(rs.getString(1));
				order.setoPrice(rs.getString(2));
				order.setoDate(rs.getString(3));
				orderList.add(order);
				LOG.debug(order.toString());
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.info("Error Code : {}", e.getErrorCode());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return orderList;
	}

	public ArrayList<Inventory> selectInventory(String oId) {
		ArrayList<Inventory> inventoryList = new ArrayList<Inventory>();
		LOG.trace("selectInventory()");
		conn = DBManager.getConnection();
		String sql = "select p.p_id, p.p_name, p.p_unitPrice, sp.s_quantity from products as p "
				+ "join sold_products as sp on sp.s_productId=p.p_id where s_orderId=?;";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(oId));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Inventory order = new Inventory();
				order.setpId(rs.getString(1));
				order.setpName(rs.getString(2));
				order.setUnitPrice(rs.getString(3));
				order.setQuantity(rs.getString(4));
				inventoryList.add(order);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.info("Error Code : {}", e.getErrorCode());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return inventoryList;
	}
	
	public ArrayList<CustomerInfo> viewCustomerInfo(String oId) {
		ArrayList<CustomerInfo> customerList = new ArrayList<CustomerInfo>();
		LOG.trace("viewCustomerInfo()");
		conn = DBManager.getConnection();
		String sql = "select orders.o_date , orders.o_customerId , customers.c_name , sold_products.s_orderId , orders.o_price "
				+ "from orders,customers,sold_products where customers.c_id = orders.o_customerId "
				+ "and orders.o_id = sold_products.s_orderId; ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(oId));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CustomerInfo cDto = new CustomerInfo();
				cDto.setoDate(rs.getString(1));
				cDto.setcName(rs.getString(2));
				cDto.setcName(rs.getString(3));
				cDto.setoId(rs.getString(4));
				cDto.setoPrice(rs.getString(5));;
				customerList.add(cDto);
				LOG.debug(cDto.toString());
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.info("Error Code : {}", e.getErrorCode());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return customerList;
	}
	void disconnect() {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean deleteCart(String oId) {
		conn = DBManager.getConnection();
		String sql = "DELETE FROM orders WHERE o_id;";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(oId));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			disconnect();
		}
		return true;
	}

}
