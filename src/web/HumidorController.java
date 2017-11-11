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
		mv.setViewName("index");
		return mv;
	}
	
	
	@RequestMapping(path = "add.do", method = RequestMethod.GET)
	public String addCigar(Model model) {
		Cigar c = new Cigar();
		model.addAttribute("cigar",c);
		model.addAttribute("wrapperValues", WrapperType.values());
		model.addAttribute("shapeValues", Shape.values());

		
		return "add";
	}
	
	@RequestMapping(path = "addCigar.do", method = RequestMethod.POST)
	public ModelAndView doAdd(Cigar c) {
		ModelAndView mv = new ModelAndView();
		dao.addCigar(c);
		System.out.println("Cigar Added");
		mv.setViewName("added");
		return mv;
	}
	
	
}
