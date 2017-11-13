package web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		model.addAttribute("cigar", c);
		model.addAttribute("wrapperValues", WrapperType.values());
		model.addAttribute("shapeValues", Shape.values());

		return "add";
	}

	@RequestMapping(path = "deleteCigar.do")
	public ModelAndView deleteCigar(@RequestParam("cigarName") String cn) {
		ModelAndView mv = new ModelAndView("deleted");
		dao.deleteCigar(dao.getCigarByName(cn));
		return mv;
	}


	@RequestMapping(path = "addCigar.do", method = RequestMethod.POST)
	public ModelAndView doAdd(Cigar c) {
		ModelAndView mv = new ModelAndView();
		dao.addCigar(c);
		System.out.println("Cigar Added");
		mv.setViewName("added");
		return mv;
	}
	
	/*
	@RequestMapping(path="update.do")
	public ModelAndView update(@RequestParam("name") String name) {
		ModelAndView mv = new ModelAndView("update");
		Cigar c = dao.getCigarByName(name);
		mv.addObject("cigar", c);
		mv.addObject("wrapperValues", WrapperType.values());
		mv.addObject("shapeValues", Shape.values());
		mv.addObject("amount", c.getAmount());
		return mv;
	}*/
	
	@RequestMapping(path="update.do" , params="name")
	public ModelAndView update(@RequestParam("name") String cigarName) {
		ModelAndView mv = new ModelAndView("update");
		Cigar c = dao.getCigarByName(cigarName);
		dao.setCurrentWorkingCigar(c);
		mv.addObject("cigar", c);
		mv.addObject("wrapperValues", WrapperType.values());
		mv.addObject("shapeValues", Shape.values());
		mv.addObject("amount", c.getAmount());
		return mv;
	}
	
	
	@RequestMapping(path = "updateCigar.do", method = RequestMethod.POST)
	public ModelAndView doUpdate(Cigar c) {
		ModelAndView mv = new ModelAndView();
		dao.editCigar(c);
		mv.setViewName("added");
		return mv;
	}

}
