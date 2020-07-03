package br.com.globallabs.springmvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.globallabs.springmvc.model.Jedi;
import br.com.globallabs.springmvc.service.JediService;

@Controller
public class JediController {

	@Autowired
	private JediService jediService;

	@GetMapping("/jedi")
	public ModelAndView jedi() {

		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jedi");

		modelAndView.addObject("allJedi", jediService.findAll());

		return modelAndView;
	}

	@GetMapping("/new-jedi")
	public String createJedi(Model model) {

		model.addAttribute("jedi", new Jedi());

		return "new-jedi";
	}

	@PostMapping("/jedi")
	public String createJedi(@Valid @ModelAttribute Jedi jedi, BindingResult result, RedirectAttributes redirect) {

		if (result.hasErrors()) {
			return "new-jedi";
		}

		jediService.save(jedi);
		redirect.addFlashAttribute("message", "Jedi successfully created.");

		return "redirect:jedi";
	}

	@GetMapping("/search")
	public ModelAndView searchJedi(@RequestParam(value = "name") final String name) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jedi");
		
		modelAndView.addObject("allJedi", jediService.findByNameContainingIgnoreCase(name));
		
		return modelAndView;
	}

	@GetMapping("/jedi/{id}/delete")
	public String deleteJedi(@PathVariable("id") final Long id, RedirectAttributes redirectAttributes) {
		jediService.delete(id);
		
		redirectAttributes.addFlashAttribute("message", "Jedi Removido com sucesso");
		
		return "redirect:/jedi";
	}

	@GetMapping("/jedi/{id}/update")
	public String updateJedi(@PathVariable("id") final Long id, Model model) {
		Jedi jedi = jediService.findById(id);
		model.addAttribute("jedi", jedi);
		
		return "edit-jedi";
	}
}
