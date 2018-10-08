package kr.co.dwebss.fitDiary.web;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import kr.co.dwebss.fitDiary.model.Food;
import kr.co.dwebss.fitDiary.model.UserFood;
import kr.co.dwebss.fitDiary.model.UserFoodDetail;
import kr.co.dwebss.fitDiary.service.FoodService;
import kr.co.dwebss.fitDiary.service.UserFoodDetailService;
import kr.co.dwebss.fitDiary.service.UserFoodService;

/**
* Created by 엄성렬 on 2018/10/04.
*/
@RestController
public class UserFoodController {
	
    @Resource
    private FoodService foodService;
    
    @Resource
    private UserFoodService userFoodService;

    @Resource
    private UserFoodDetailService userFoodDetailService;

//    @PostMapping("/add")
//    public Result add(UserFood userFood) {
//        userFoodService.save(userFood);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/delete")
//    public Result delete(@RequestParam Integer id) {
//        userFoodService.deleteById(id);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/update")
//    public Result update(UserFood userFood) {
//        userFoodService.update(userFood);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/detail")
//    public Result detail(@RequestParam Integer id) {
//        UserFood userFood = userFoodService.findById(id);
//        return ResultGenerator.genSuccessResult(userFood);
//    }
//
//    @PostMapping("/list")
//    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
//        PageHelper.startPage(page, size);
//        List<UserFood> list = userFoodService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultGenerator.genSuccessResult(pageInfo);
//    }

	/**
	 * 음식 관리 목록
	 *
	 * @param CommonCode codeSearchVO
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
    @RequestMapping("/admin/userfood/list")
	public ModelAndView list(@ModelAttribute("userFood") UserFood userFood,
			HttpServletRequest request ,
			HttpSession session ,
			ModelMap model) throws Exception {
		
    	userFood.setFirstIndex((userFood.getPageIndex() - 1 ) * userFood.getPageUnit());
		
//		List<HashMap> resultList = userFoodService.selectList(userFood);
		List<UserFood> resultList = userFoodService.selectList(userFood);
		
		int totalCnt=userFoodService.selectListCnt(userFood);
		
		userFood.setTotalRecordCount(totalCnt);
		userFood.setTotalPage();
		

		ModelAndView mav = new ModelAndView("admin/userfood/list");
		mav.addObject("resultList", resultList);
		mav.addObject("totalCnt", totalCnt);
		mav.addObject("pni", userFood);
		
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
	@RequestMapping(value = "/admin/userfood/regist")
	public ModelAndView regist(
			HttpServletRequest request,
			@ModelAttribute("userFood") UserFood userFood
			) throws Exception {
		
		ModelAndView mav = new ModelAndView("admin/userfood/regist");
		String flag= request.getParameter("flag");

		if(flag.equals("U")){
			String userFoodId= request.getParameter("userFoodId");
			UserFood result = new UserFood();
			result = userFoodService.findById(Integer.parseInt(userFoodId));

			List<UserFoodDetail> detailList = userFoodDetailService.selectUserFoodDetail(Integer.parseInt(userFoodId));
			mav.addObject("result", result);
			mav.addObject("userFoodId", userFoodId);
			mav.addObject("detailList", detailList);
		}

		mav.addObject("searchVO", userFood);
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
	@RequestMapping(value = "/admin/userfood/insert")
	public ModelAndView insert(
			HttpServletRequest request,
			@ModelAttribute("userFood") UserFood userFood) throws Exception {
		ModelAndView mav = new ModelAndView("forward:/admin/userfood/list");
		userFoodService.save(userFood);
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
	@RequestMapping(value = "/admin/userfood/update")
	public ModelAndView update(
			HttpServletRequest request,
			@ModelAttribute("userFood") UserFood userFood
			) throws Exception {
		ModelAndView mav = new ModelAndView("forward:/admin/userfood/list");
		userFoodService.update(userFood);
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
	@RequestMapping(value = "/admin/userfood/delete")
	public ModelAndView delete(
			HttpServletRequest request,
			@ModelAttribute("userFood") UserFood userFood) throws Exception {
		ModelAndView mav = new ModelAndView("forward:/admin/userfood/list");
		userFoodService.deleteById(userFood.getUserFoodId());
		return mav;
	}

	/**
	 * 음식 관리 목록
	 *
	 * @param CommonCode codeSearchVO
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
    @RequestMapping("/admin/userfood/popupFoodList")
	public ModelAndView list(@ModelAttribute("food") Food food,
			HttpServletRequest request ,
			HttpSession session ,
			ModelMap model) throws Exception {
		
		food.setFirstIndex((food.getPageIndex() - 1 ) * food.getPageUnit());
		System.out.println("food : "+food.getSearchKeyword());
		List<HashMap> resultList = foodService.selectList(food);
		
		int totalCnt=foodService.selectListCnt(food);
		
		food.setTotalRecordCount(totalCnt);
		food.setTotalPage();

		ModelAndView mav = new ModelAndView("admin/userfood/popup/foodList");
		mav.addObject("resultList", resultList);
		mav.addObject("totalCnt", totalCnt);
		mav.addObject("pni", food);
		
//		model.addAttribute("power", commonService.getMenuPower((String)session.getAttribute("roleId"), EgovStringUtil.uriPathDeletePageUrl(request.getRequestURI(), request.getContextPath())));

		return mav;
	}

	/**
	 * 변경 사항 수정 (클래스일경우)
	 *
	 * @param HttpServletRequest request
	 * @param Map<String, Object> codeMap
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
    @Transactional(rollbackFor=Exception.class)
	@RequestMapping(value = "/admin/userfood/updateFoodDetail")
	public ModelAndView updateFoodDetail(
			HttpServletRequest request,
			ModelMap model) throws Exception {

	ModelAndView mav = new ModelAndView("forward:/admin/userfood/list");
	String param = request.getParameter("param");
    JSONObject objParam = (JSONObject) JSON.parse(param);
    
	UserFoodDetail vo = null;
	JSONArray addList = (JSONArray) objParam.get("addList");

	String userFoodId =(String) objParam.get("userFoodId");

	userFoodDetailService.deleteUserFoodDetail(Integer.parseInt(userFoodId));
	
	for(int i = 0; i<addList.size(); i++) {
	   JSONObject obj = (JSONObject) addList.get(i);
	   vo = new UserFoodDetail();
	   vo.setUserFoodId(Integer.parseInt(userFoodId));
	   vo.setFoodId(Integer.parseInt(obj.get("foodId").toString()));
	   BigDecimal ad= new BigDecimal(obj.get("amountDish").toString());
	   vo.setAmountDish(ad);
	   
	   userFoodDetailService.save(vo);
	}
				
		return mav;
	}
    

    
    
}
