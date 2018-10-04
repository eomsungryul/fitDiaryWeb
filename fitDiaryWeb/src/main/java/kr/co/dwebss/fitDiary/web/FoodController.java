package kr.co.dwebss.fitDiary.web;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.co.dwebss.fitDiary.model.Food;
import kr.co.dwebss.fitDiary.service.FoodService;

/**
* Created by 엄성렬 on 2018/10/04.
*/
@RestController
public class FoodController {
	
	
    @Resource
    private FoodService foodService;

	/**
	 * 음식 관리 목록
	 *
	 * @param CommonCode codeSearchVO
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
    @RequestMapping("/admin/food/list")
	public ModelAndView list(@ModelAttribute("food") Food food,
			HttpServletRequest request ,
			HttpSession session ,
			ModelMap model) throws Exception {
		
		food.setFirstIndex((food.getPageIndex() - 1 ) * food.getPageUnit());
		
		List<HashMap> resultList = foodService.selectList(food);
		
		int totalCnt=foodService.selectListCnt(food);
		
		food.setTotalRecordCount(totalCnt);
		food.setTotalPage();
		

		ModelAndView mav = new ModelAndView("admin/food/list");
		mav.addObject("resultList", resultList);
		mav.addObject("totalCnt", totalCnt);
		mav.addObject("pni", food);
		
//		model.addAttribute("power", commonService.getMenuPower((String)session.getAttribute("roleId"), EgovStringUtil.uriPathDeletePageUrl(request.getRequestURI(), request.getContextPath())));

		return mav;
	}




	/**
	 * 음식 등록 및 수정 화면
	 *
	 * @param HttpServletRequest request
	 * @param CommonCode searchVO
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/food/regist")
	public ModelAndView regist(
			HttpServletRequest request,
			@ModelAttribute("food") Food food
			) throws Exception {
		
		ModelAndView mav = new ModelAndView("admin/food/regist");
		String flag= request.getParameter("flag");

		if(flag.equals("U")){
			String userFoodId= request.getParameter("userFoodId");
			Food result = new Food();
			result = foodService.findById(Integer.parseInt(userFoodId));
			mav.addObject("result", result);
			mav.addObject("userFoodId", userFoodId);
		}

		mav.addObject("searchVO", food);
		mav.addObject("flag", flag);

		return mav;
	}

	/**
	 * 음식 등록
	 *
	 * @param HttpServletRequest request
	 * @param Map<String, Object> codeMap
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/food/insert")
	public ModelAndView insert(
			HttpServletRequest request,
			@ModelAttribute("food") Food food) throws Exception {
		ModelAndView mav = new ModelAndView("forward:/admin/food/list");
		foodService.save(food);
		return mav;
	}
	
	/**
	 * 음식 수정
	 *
	 * @param HttpServletRequest request
	 * @param Map<String, Object> codeMap
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/food/update")
	public ModelAndView update(
			HttpServletRequest request,
			Food food
			) throws Exception {
		ModelAndView mav = new ModelAndView("forward:/admin/food/list");
		foodService.update(food);
		return mav;
	}

	/**
	 * 음식 삭제
	 *
	 * @param HttpServletRequest request
	 * @param Map<String, Object> codeMap
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/food/delete")
	public ModelAndView delete(
			HttpServletRequest request,
			@ModelAttribute("food") Food food) throws Exception {
		ModelAndView mav = new ModelAndView("forward:/admin/food/list");
		foodService.deleteById(food.getFoodId());
		return mav;
	}
}
