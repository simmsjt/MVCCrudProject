package data;

import java.util.List;

public interface CigarDAO {
	List<Cigar> getAllCigars();
	Cigar getCigarById(int id); 
	Cigar addCigar(Cigar g);
	Cigar deleteCigar(Cigar g);
	Cigar editCigar(Cigar g);
}
