package data;

import java.util.ArrayList;
import java.util.List;

public class CigarDAOImpl implements CigarDAO {

	private List<Cigar> humidor = new ArrayList<Cigar>(); 
	
	@Override
	public List<Cigar> getAllCigars() {
		return humidor;
	}

	@Override
	public Cigar addCigar(Cigar c) {
		humidor.add(c);
		return null;
	}

	@Override
	public Cigar deleteCigar(Cigar c) {
		humidor.remove(c);
		return null;
	}

	@Override
	public Cigar editCigar(Cigar c) {
		// TODO Auto-generated method stub
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

}
