package org.wangyu.ems.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wangyu.ems.entity.Title;
import org.wangyu.ems.service.ITitleService;

@Controller
@RequestMapping("/title")
public class TitleHandler {

	@Autowired
	private ITitleService titleService;

	@RequestMapping("/titlelist")
	public String titlelist(ModelMap modelMap) {
		List<Title> list = titleService.QueryAll();
		modelMap.addAttribute("list", list);
		return "title/titlelist";
	}
	
	@RequestMapping("/titletoAdd")
	public String titletoAdd() {
		return "title/add";
		
	}
	
	@RequestMapping("/add")
	public String add(Title title) {
		titleService.append(title);
		return "redirect:/title/titlelist";
	}

	@RequestMapping("/remove")
	public String remove(int id) {
		titleService.removeById(id);
		return "redirect:/title/titlelist";
	}

	@RequestMapping("/tomodify")
	public String tomodify(int id, ModelMap modelMap) {
		Title title = titleService.QueryById(id);
		modelMap.addAttribute("title", title);
		return "title/modify";
	}

	@RequestMapping("/modify")
	public String modify(Title title) {
		titleService.modify(title);
		return "redirect:/title/titlelist";
	}

	@RequestMapping("/queryAll")
	@ResponseBody
	public Object queryAll(String titleName) {
		List<Title> list = titleService.QueryByName("%" + titleName + "%");
		return list;
	}
	
	
	@RequestMapping("/query")
	@ResponseBody
	public Object query() {
		List<Title> list = titleService.QueryAll();
		return list;
	}
	
	@RequestMapping("/queryById")
	@ResponseBody
	public Object queryById(int deptnames) {
		List<Title> list = titleService.QueryByDeptId(deptnames);
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
