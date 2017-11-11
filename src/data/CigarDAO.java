package data;

import java.util.List;

public interface CigarDAO {
	List<Cigar> getAllCigars();
	List<Cigar> getCigarsByShape(Shape s);
	List<Cigar> getCigarsByWrapper(WrapperType w);
	Cigar getCigarById(int id); 
	Cigar addCigar(Cigar g);
	Cigar deleteCigar(Cigar g);
	Cigar editCigar(Cigar g);
}
