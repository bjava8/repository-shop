package com.mj.shop.product;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
//@SessionAttributes("product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	/**
	 * http://localhost:8080/shop/category/101
	 * JEWELRY 	 * http://www.jestina.co.kr/Brand/JESTINA/Category/101
	 * 	Earring http://www.jestina.co.kr/Brand/JESTINA/Category/101101100
	 * Necklace http://www.jestina.co.kr/Brand/JESTINA/Category/101102100
	 * 
	 * 
	 * IN : category, page
	 * OUT : category, page(pvo), list,
	 */
	@RequestMapping(value = "/category/{category}", method = RequestMethod.GET)
	//public ModelAndView listView(ModelAndView model,  @PathVariable(value = "category") String category) {
	public ModelAndView listView(ModelAndView model,  ListVO vo) {	
		logger.info("[ProductController/listView] START " + vo);

		int totalCount = productService.getTotal(vo); // category
		
		// paging totalCount, pageSize
		Paging p = new Paging(totalCount, vo.getPage());
		logger.info("[ProductController/listView] " + p);
		
		vo.setStart(p.getBeginNum());
		vo.setEnd(p.getEndNum());

		List<ProductVO> list = productService.listView(vo);

		logger.info("[ProductController/listView] " + list);
		
		// category
		model.addObject("list", list);
		model.addObject("pvo", p);
		model.addObject("category", vo.getCategory());
		model.setViewName("productList");
		return model;
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(ModelAndView model, @RequestParam(value="p_code", defaultValue="", required=false) String id) {
		logger.info("[ProductController/detail] START");
		
		ProductVO vo = productService.getProduct(id);
		
		logger.info("[ProductController/detail] " + vo.toString());
		
		model.addObject("product", vo);
		model.setViewName("productDetail");
		return model;
	}
	
	@RequestMapping(value = "/insertForm")
	public ModelAndView insertForm(ProductVO vo, ModelAndView model) {
		 logger.info("[ProductCont.insertForm] START");

		 model.setViewName("insertForm");
		  
		 return model;
	}
	
	
	/**
	 * id=id, name=name, category=101101100, price=1, imgFile=org.springframework.web.multipart.commons.CommonsMultipartFile@36def2ad, detail=, soldout=null, discount_rate=, discount_price=, hit=null]
	 * @param model
	 * @param vo ProductVO2 Product Form File
	 * @return
	 */
	@RequestMapping(value = "/insertProduct", method = RequestMethod.POST)
	//public ModelAndView insertProduct(ProductVO vo, ModelAndView model, HttpServletRequest request, @RequestParam("imgFile") MultipartFile file) {
	public String insertProduct(ModelAndView model, ProductVO2 vo) {
		 logger.info("[ProductCont.insertProduct] START " + vo);
		 
		 MultipartFile imgFile = vo.getImgFile();
		 if (!imgFile.isEmpty()) {
			 //String fileName = imgFile.getOriginalFilename(); //실제파일명
			 
			logger.info("name : " + imgFile.getName());
			logger.info("filename : " + imgFile.getOriginalFilename());
			logger.info("size : " + imgFile.getSize());
			/*
			 * name : imgFile
INFO : com.mj.shop.product.ProductController - filename : JJMENQ7AF403SR420.jpg
INFO : com.mj.shop.product.ProductController - size : 88583
			 */
		 }	 
			//uploadFile.transferTo(new File("c:/MyStudy/temp/" + fileName));
			
			//String path = request.getSession().getServletContext().getRealPath("/");
			//logger.info("path : " + path);
			/*
			try {
				imgFile.transferTo(new File("c:/MyStudy/temp/" + imgFile.getOriginalFilename()));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			*/
		 
		 //productService.insertProduct(vo);
		
		 //model.setViewName("detail?p_code="+vo.getId());
		 //WARN : org.springframework.web.servlet.PageNotFound - No mapping found for HTTP request with URI [/shop/WEB-INF/views/detail] in DispatcherServlet with name 'appServlet'
		 //return "detail?p_code=JJT1EI7AF445SW017";
		 //model.addObject("p_code", "JJT1EI7AF445SW017")
		 //return new ModelAndView("redirect:/redirectedUrl", model);
		 return "redirect:detail?p_code=JJT1EI7AF445SW017";
	}
	
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public ModelAndView order(ProductVO vo, ModelAndView model) {
		 logger.info("[ProductCont.order] START");
		 logger.info(vo.toString());
		  
		 model.addObject("product", vo);
		 model.setViewName("order");
		  
		 return model;
	}
	
	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	 public ModelAndView payment(ProductVO vo, ModelAndView model) {
		 logger.info("[ProductCont.payment] START");
		 logger.info(vo.toString());
		  
		 model.addObject("product", vo);
		 model.setViewName("payment");
		  
		 return model;
	 }
	
	

	
	
}
