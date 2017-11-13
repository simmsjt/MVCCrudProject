package data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class CigarDAOImpl implements CigarDAO {

	private List<Cigar> humidor;
	
	public CigarDAOImpl() {
		humidor = new ArrayList<Cigar>();
		humidor.add(new Cigar("Jim", "apples", WrapperType.CLARO, Shape.CHURCHILL));
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
	public Cigar editCigar(Cigar c) {
		System.out.println(c);
		for (Cigar cigar : humidor) {
			if(cigar.getName().equals(c.getName())) {
				cigar = c;
				System.out.println(cigar);
			}
		}
	
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
