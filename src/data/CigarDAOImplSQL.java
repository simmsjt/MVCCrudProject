package data;

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
	
	private List<Cigar> humidor;
	private Cigar currentWorkingCigar;
	
	public CigarDAOImplSQL() {
		humidor = new ArrayList<Cigar>();
		humidor.add(new Cigar("Andalusian Bull", "La Flor Dominicana", WrapperType.OSCURO, Shape.BELICOSO));
		humidor.get(0).setAmount(3);
	}
	
	public void setCurrentWorkingCigar(Cigar c) {
		currentWorkingCigar = c;
	}

	
	@Override
	public List<Cigar> getAllCigars() {
		return humidor;
	}

	@Override
	public Cigar addCigar(Cigar c) {
		int index = -1;
		for (Cigar cigar : humidor) {
			if(cigar.getName().equals(c.getName()))
				index = humidor.indexOf(cigar);
		}
		if(index == -1) {
		humidor.add(c);
		} else
		humidor.get(index).setAmount(humidor.get(index).getAmount()+c.getAmount());
		return null;
	}

	@Override
	public Cigar deleteCigar(Cigar c) {
		if(c.getAmount()>1) {
			c.setAmount(c.getAmount()-1);
		}else {
		humidor.remove(c);
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
	@Override
	public Cigar getCigarByName(String name) {
		for (Cigar cigar : humidor) {
			if(cigar.getName().equals(name))
				return cigar;
		}
		return null;
	}

}
