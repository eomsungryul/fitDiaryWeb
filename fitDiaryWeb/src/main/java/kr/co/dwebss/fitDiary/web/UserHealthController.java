package kr.co.dwebss.fitDiary.web;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import kr.co.dwebss.fitDiary.core.Result;
import kr.co.dwebss.fitDiary.core.ResultGenerator;
import kr.co.dwebss.fitDiary.model.UserFood;
import kr.co.dwebss.fitDiary.model.UserHealth;
import kr.co.dwebss.fitDiary.service.UserHealthService;

/**
* Created by 엄성렬 on 2018/10/04.
*/
@RestController
public class UserHealthController {
    @Resource
    private UserHealthService userHealthService;

	/**
	 * 음식 관리 목록 ( 입력을 안한 목록만 나오는 페이지 현재는 이것만 나오게 함  )
	 *
	 * @param CommonCode codeSearchVO
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
    @RequestMapping("/admin/userHealth/insertList")
	public ModelAndView insertList(@ModelAttribute("userHealth") UserHealth userHealth,
			HttpServletRequest request ,
			HttpSession session ,
			ModelMap model) throws Exception {
		
    	UserHealth resultList = userHealthService.selectInsertList(userHealth);

		ModelAndView mav = new ModelAndView("admin/userHealth/insertList");
		mav.addObject("result", resultList);

		return mav;
	}
    

	/**
	 * 변경 사항 수정 
	 *
	 * @param HttpServletRequest request
	 * @param Map<String, Object> codeMap
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
    @Transactional(rollbackFor=Exception.class)
	@RequestMapping(value = "/admin/userHealth/update")
	public ModelAndView update(UserHealth userHealth) throws Exception {

		ModelAndView mav = new ModelAndView("forward:/admin/userHealth/insertList");
	    userHealthService.update(userHealth);
				
		return mav;
	}
}
