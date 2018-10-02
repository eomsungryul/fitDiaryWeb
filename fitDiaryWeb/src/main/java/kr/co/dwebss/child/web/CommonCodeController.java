package kr.co.dwebss.child.web;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.co.dwebss.child.model.CommonCode;
import kr.co.dwebss.child.service.CommonCodeService;

/**
* Created by 엄성렬 on 2018/10/02.
*/
@RestController
public class CommonCodeController {
    @Resource
    private CommonCodeService commonCodeService;

//    @RequestMapping("/add")
//    public Result add(CommonCode commonCode) {
//        commonCodeService.save(commonCode);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @RequestMapping("/delete")
//    public Result delete(@RequestParam Integer id) {
//        commonCodeService.deleteById(id);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @RequestMapping("/update")
//    public Result update(CommonCode commonCode) {
//        commonCodeService.update(commonCode);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @RequestMapping("/detail")
//    public Result detail(@RequestParam Integer id) {
//        CommonCode commonCode = commonCodeService.findById(id);
//        return ResultGenerator.genSuccessResult(commonCode);
//    }
//
//    @RequestMapping("/list")
//    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
//        PageHelper.startPage(page, size);
//        List<CommonCode> list = commonCodeService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultGenerator.genSuccessResult(pageInfo);
//    }
    
    

	/**
	 * 코드 관리 목록
	 *
	 * @param CommonCode codeSearchVO
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
    @RequestMapping("/admin/code/list")
	public ModelAndView list(@ModelAttribute("commonCode") CommonCode commonCode,
			HttpServletRequest request ,
			HttpSession session ,
			ModelMap model) throws Exception {
		
		commonCode.setFirstIndex((commonCode.getPageIndex() - 1 ) * commonCode.getPageUnit());
		
		List<HashMap> resultList = commonCodeService.selectList(commonCode);
		
		int totalCnt=commonCodeService.selectListCnt(commonCode);
		
		commonCode.setTotalRecordCount(totalCnt);
		commonCode.setTotalPage();
		

		ModelAndView mav = new ModelAndView("admin/code/list");
		mav.addObject("resultList", resultList);
		mav.addObject("totalCnt", totalCnt);
		mav.addObject("pni", commonCode);
		
//		model.addAttribute("power", commonService.getMenuPower((String)session.getAttribute("roleId"), EgovStringUtil.uriPathDeletePageUrl(request.getRequestURI(), request.getContextPath())));

		return mav;
	}




	/**
	 * 코드 등록 및 수정 화면
	 *
	 * @param HttpServletRequest request
	 * @param CommonCode searchVO
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/code/regist")
	public ModelAndView regist(
			HttpServletRequest request,
			@ModelAttribute("searchVO") CommonCode searchVO
			) throws Exception {
		
		ModelAndView mav = new ModelAndView("admin/code/regist");
		String flag= request.getParameter("flag");

		if(flag.equals("U")){
			String code= request.getParameter("code");
			CommonCode result = new CommonCode();
			result=commonCodeService.findById(Integer.parseInt(code));
			mav.addObject("result", result);
			mav.addObject("code", code);
		}

		mav.addObject("searchVO", searchVO);
		mav.addObject("flag", flag);

		return mav;
	}

	/**
	 * 코드 등록
	 *
	 * @param HttpServletRequest request
	 * @param Map<String, Object> codeMap
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/code/insert")
	public ModelAndView insert(
			HttpServletRequest request,
			@ModelAttribute("commonCode") CommonCode commonCode) throws Exception {
		ModelAndView mav = new ModelAndView("forward:/admin/code/list");
		commonCodeService.save(commonCode);
		return mav;
	}
	
	/**
	 * 코드 수정
	 *
	 * @param HttpServletRequest request
	 * @param Map<String, Object> codeMap
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/code/update")
	public ModelAndView update(
			HttpServletRequest request,
			CommonCode commonCode
			) throws Exception {
		ModelAndView mav = new ModelAndView("forward:/admin/code/list");
		commonCodeService.update(commonCode);
		return mav;
	}

	/**
	 * 코드 삭제
	 *
	 * @param HttpServletRequest request
	 * @param Map<String, Object> codeMap
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/code/delete")
	public ModelAndView delete(
			HttpServletRequest request,
			@ModelAttribute("commonCode") CommonCode commonCode) throws Exception {
		ModelAndView mav = new ModelAndView("forward:/admin/code/list");
		commonCodeService.deleteById(commonCode.getCode());
		return mav;
	}
}
