package web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import data.Cigar;
import data.CigarDAO;
import data.Shape;
import data.WrapperType;

@Controller
public class HumidorController {
	
	@Autowired
	CigarDAO dao;
	
	@RequestMapping(path = "home.do", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		List<Cigar> allCigars = dao.getAllCigars();
		mv.addObject("list", allCigars);
		mv.addObject("wrapperValues", WrapperType.values());
		mv.addObject("shapeValues", Shape.values());
		mv.setViewName("index");
		return mv;
	}
	
	
	@RequestMapping(path = "addCigar.do", method = RequestMethod.POST)
	public String addGiraffe(Model model) {
		Cigar c = new Cigar("Tim", "apples", WrapperType.CLARO, Shape.CHURCHILL);
		dao.addCigar(c);
		model.addAttribute("cigar", c);
		model.addAttribute("wrapperType", WrapperType.values());
		return "index";
	}

}
