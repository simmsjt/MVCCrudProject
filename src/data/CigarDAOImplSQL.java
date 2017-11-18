package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;


@Repository
@Primary
public class CigarDAOImplSQL implements CigarDAO {
	private static final String url = "jdbc:mysql://localhost:3306/humidordb";
	private String user = "smoker";
	private String pass = "smoker";
	
	private Cigar currentWorkingCigar;
	
	public CigarDAOImplSQL() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Error loading MySQL Driver!!!");
		}
	}
	
	public void setCurrentWorkingCigar(Cigar c) {
		currentWorkingCigar = c;
	}

	
	@Override
	public List<Cigar> getAllCigars() {
		List<Cigar> humidor = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT c.id,c.brand,c.name,c.amount,s.shape,w.name "
					+ "FROM cigar c JOIN shape s ON "
					+ "c.shape_id = s.id JOIN wrapper w ON w.id = c.wrapper_id;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cigar c = new Cigar();
				c.setId(rs.getInt(1));
				c.setBrand(rs.getString(2));
				c.setName(rs.getString(3));
				c.setAmount(rs.getInt(4));
				System.out.println(rs.getString(5));
				c.setShape(Shape.valueOf(rs.getString(5).toUpperCase()));
				c.setWrapper(WrapperType.valueOf(rs.getString(6).toUpperCase()));
				humidor.add(c);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return humidor;
	}

	@Override
	public Cigar addCigar(Cigar c) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			conn.setAutoCommit(false);
			String sql = "INSERT INTO cigar (brand,name,amount,wrapper_id,shape_id) "
					+ "VALUES (?,?,?,?,?);";
			PreparedStatement stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();
			int lastId;
			while(rs.next()) {
				lastId = rs.getInt(1);
				c.setId(lastId);
				System.out.println(lastId);
			}
			
			//SET STATMENT WITH VALUES
			stmt.setString(1, c.getBrand());
			stmt.setString(2, c.getName());
			stmt.setInt(3, c.getAmount());
			stmt.setInt(4, c.getWrapper().ordinal()+1);
			stmt.setInt(5, c.getShape().ordinal()+1);
			int count = stmt.executeUpdate();
			if (count == 1) {
				System.out.println(c.getName() + " " + c.getBrand() + " cigar added.");
			}
			conn.commit();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("Error during inserts.");
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.err.println("Error rolling back.");
					e1.printStackTrace();
				}
			}
		}
		
		return c;
	}
	
	@Override
	public Cigar deleteCigar(Cigar c) {
		if(c.getAmount()>1) {
			c.setAmount(c.getAmount()-1);
		}else {
		}
		return null;
	}

	@Override
	public Cigar editCigar(Cigar newCigar) {
		currentWorkingCigar.setAmount(newCigar.getAmount());
		currentWorkingCigar.setBrand(newCigar.getBrand());
		currentWorkingCigar.setName(newCigar.getName());
		currentWorkingCigar.setShape(newCigar.getShape());
		currentWorkingCigar.setWrapper(newCigar.getWrapper());
		/*
		currentWorkingCigar.setAmount(amount);
		System.out.println(newCigar);
		System.out.println(currentWorkingCigar);
		for (Cigar cigar : humidor) {
			System.out.println(cigar);
			if(cigar.getName().equals(newCigar.getName())) {
				cigar.setAmount(newCigar.getAmount());
				cigar.setBrand(newCigar.getBrand());
				cigar.setShape(newCigar.getShape());
				cigar.setWrapper(newCigar.getWrapper());
			}
		}*/
		
		return null;
	}
	
	public Cigar getCigarById(int id) {
		Cigar c = new Cigar();
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT id,brand,name,amount,wrapper_id,shape_id FROM" + 
						"cigar WHERE id = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
			    c.setId(rs.getInt(1));
				c.setBrand(rs.getString(2));
				c.setName(rs.getString(3));
				c.setAmount(rs.getInt(4));
				System.out.println(rs.getString(5));
				c.setShape(Shape.valueOf(rs.getString(5).toUpperCase()));
				c.setWrapper(WrapperType.valueOf(rs.getString(6).toUpperCase()));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<Cigar> getCigarsByShape(Shape s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cigar> getCigarsByWrapper(WrapperType w) {
		// TODO Auto-generated method stub
		return null;
	}


}
