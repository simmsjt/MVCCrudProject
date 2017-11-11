package data;

import java.util.List;

public interface CigarDAO {
	List<Cigar> getAllCigars();
	List<Cigar> getCigarsByShape(Shape s);
	List<Cigar> getCigarsByWrapper(WrapperType w);
	Cigar addCigar(Cigar c);
	Cigar deleteCigar(Cigar c);
	Cigar editCigar(Cigar c);
}
