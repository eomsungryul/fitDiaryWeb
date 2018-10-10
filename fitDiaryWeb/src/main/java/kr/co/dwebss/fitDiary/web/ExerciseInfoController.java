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

import kr.co.dwebss.fitDiary.model.CommonCode;
import kr.co.dwebss.fitDiary.model.ExerciseInfo;
import kr.co.dwebss.fitDiary.service.CommonCodeService;
import kr.co.dwebss.fitDiary.service.ExerciseInfoService;

/**
* Created by 엄성렬 on 2018/10/10.
*/
@RestController
public class ExerciseInfoController {

	@Resource
	private CommonCodeService commonCodeService;
	
    @Resource
    private ExerciseInfoService exerciseInfoService;

//    @PostMapping("/add")
//    public Result add(ExerciseInfo exerciseInfo) {
//        exerciseInfoService.save(exerciseInfo);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/delete")
//    public Result delete(@RequestParam Integer id) {
//        exerciseInfoService.deleteById(id);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/update")
//    public Result update(ExerciseInfo exerciseInfo) {
//        exerciseInfoService.update(exerciseInfo);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/detail")
//    public Result detail(@RequestParam Integer id) {
//        ExerciseInfo exerciseInfo = exerciseInfoService.findById(id);
//        return ResultGenerator.genSuccessResult(exerciseInfo);
//    }
//
//    @PostMapping("/list")
//    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
//        PageHelper.startPage(page, size);
//        List<ExerciseInfo> list = exerciseInfoService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultGenerator.genSuccessResult(pageInfo);
//    }


	/**
	 * 운동 기구-부위 관리 목록
	 *
	 * @param CodeVO codeSearchVO
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/exerciseInfo/list")
	public ModelAndView list(@ModelAttribute("commonCode") CommonCode commonCode,
			HttpServletRequest request ,
			HttpSession session ,
			ModelMap model) throws Exception {
		
		commonCode.setSearchCondition("mappingCategory");
		commonCode.setSearchKeyword("운동기구");
		
		List<HashMap> resultList = commonCodeService.selectList(commonCode);

		ModelAndView mav = new ModelAndView("admin/exerciseInfo/list");
		mav.addObject("resultList", resultList);

		return mav;
	}
	
	/**
	 * 운동 부위 목록
	 *
	 * @param CodeVO codeSearchVO
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/exerciseInfo/partList")
	public ModelAndView partList(@ModelAttribute("commonCode") CommonCode commonCode,
			HttpServletRequest request ,
			HttpSession session ,
			ModelMap model) throws Exception {
		
		commonCode.setSearchCondition("mappingCategory");
		commonCode.setSearchKeyword("운동부위");
		commonCode.setCode(Integer.parseInt(request.getParameter("code")));
		//매핑할때 
		List<HashMap> resultList = commonCodeService.selectPart(commonCode);
		
		ModelAndView mav = new ModelAndView("admin/exerciseInfo/partList");
		mav.addObject("resultList", resultList);

		return mav;
	}
	
	/**
	 * 운동 부위 목록
	 *
	 * @param CodeVO codeSearchVO
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/exerciseInfo/partDetail")
	public ModelAndView partDetail(
			ExerciseInfo exerciseInfo,
			HttpServletRequest request ,
			HttpSession session ,
			ModelMap model) throws Exception {
		
		ExerciseInfo result = exerciseInfoService.selectExerciseInfo(exerciseInfo);

		ModelAndView mav = new ModelAndView("admin/exerciseInfo/partDetail");
		mav.addObject("result", result);

		return mav;
	}

	
	

	/**
	 * 운동 기구-부위 등록
	 *
	 * @param HttpServletRequest request
	 * @param Map<String, Object> codeMap
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/exerciseInfo/insert")
	public ModelAndView insert(
			HttpServletRequest request,
			@ModelAttribute("exerciseInfoVo") ExerciseInfo exerciseInfo,
			ModelMap model) throws Exception {

		//기구-부위중 기구
		exerciseInfoService.updateUseN(exerciseInfo);
		
		
		int mappingCnt = exerciseInfoService.selectCnt(exerciseInfo);
		if(mappingCnt>0) {
			exerciseInfoService.update(exerciseInfo);
		}else {
			exerciseInfoService.save(exerciseInfo);
		}

		ModelAndView mav = new ModelAndView("forward:/admin/exerciseInfo/list");
		return mav;
	}
	
	/**
	 * 운동 기구-부위 상세 등록
	 *
	 * @param HttpServletRequest request
	 * @param Map<String, Object> codeMap
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/exerciseInfo/detailUpdate")
	public ModelAndView detailUpdate(
			HttpServletRequest request,
			@ModelAttribute("exerciseInfoVo") ExerciseInfo exerciseInfo,
			ModelMap model) throws Exception {

		exerciseInfoService.update(exerciseInfo);

		ModelAndView mav = new ModelAndView("forward:/admin/exerciseInfo/list");
		return mav;
	}
	
}
