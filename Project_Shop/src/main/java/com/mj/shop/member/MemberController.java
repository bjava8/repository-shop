package com.mj.shop.member;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/member/listView", method = RequestMethod.GET)
	public ModelAndView listView(ModelAndView model) {
		logger.info("[MemberController/listView] START");
		ListVO listVO = new ListVO();
		
		listVO.setStart(11);
		listVO.setEnd(20);
		List<MemberVO> list = memberService.listView(listVO);
		
		
		logger.info("[MemberController/listView] "+list.toString());
		
		//model.addAttribute("serverTime", formattedDate );
		model.addObject("list", list);
		model.setViewName("listView");
		return model;
	}
	


	
	
}
