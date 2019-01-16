package customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ShoppingUtil.DBManager;

public class CustomerDAO {
	private static final Logger LOG = LoggerFactory.getLogger(CustomerDAO.class);
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	BCrypt bc = new BCrypt();
	
	public boolean addCustomer(Customers customer) {
		LOG.trace("addCustomers()");
		LOG.debug(customer.toString());
		conn = DBManager.getConnection();
		String sql = "insert into customers(c_name, c_password, c_email, c_tel) values(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, customer.getcName());
			pstmt.setString(2, bc.hashpw(customer.getcPassword(), bc.gensalt(10)));
			pstmt.setString(3, customer.getcEmail());
			pstmt.setString(4, customer.getcTel());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.info("Error Code : {}", e.getErrorCode());
			return false;
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public boolean login(String cId, String cPassword) {
	      LOG.trace("login()");
	      conn = DBManager.getConnection();
	      String sql = "select c_password from customers where c_id =?";
	      boolean result = false;
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, Integer.parseInt(cId));
	         rs = pstmt.executeQuery();
	         if(rs.next()) {
	               String hashedpsw = rs.getString("c_password");
	                  if(bc.checkpw(cPassword, hashedpsw)) {
	                     result = true;
	                  }
	           }
	         rs.close();
	      } catch (SQLException e) {
	         e.printStackTrace();
	         LOG.info("Error Code : {}",e.getErrorCode());
	      }
	      finally {
	         try {
	            pstmt.close();
	            conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      return result;
	   }
	

	public ArrayList<String> getAllCustomers() {
		ArrayList<String> customerList = new ArrayList<String>();
		conn = DBManager.getConnection();
		String sql = "select * from customers order by c_id desc";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				customerList.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.info("Error Code : {}",e.getErrorCode());
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return customerList;
	}
	
	public Customers getCustomer(String cId) {
		Customers cusotmer = new Customers();
		conn = DBManager.getConnection();
		String sql = "select * from customers where c_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(cId));
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			cusotmer.setcId(rs.getString(1));
			cusotmer.setcName(rs.getString(2));
			cusotmer.setcPassword(rs.getString(3));
			cusotmer.setcEmail(rs.getString(4));
			cusotmer.setcTel(rs.getString(5));
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
			LOG.info("Error Code : {}",e.getErrorCode());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return cusotmer;
	}
}
