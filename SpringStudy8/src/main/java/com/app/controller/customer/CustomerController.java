package com.app.controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.common.ApiCommonCode;
import com.app.common.CommonCode;
import com.app.controller.study.rest.ApiResponse;
import com.app.dto.api.ApiResponseHeader;
import com.app.dto.room.Room;
import com.app.dto.user.User;
import com.app.dto.user.UserDupCheck;
import com.app.service.user.UserService;
import com.app.util.LoginManager;

import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.Post;

@Slf4j
@Controller
public class CustomerController {

	// 일반 고객 사용자가 접근하는 관련 서비스

	@Autowired
	UserService userService;
	// 사용자 계정정보 관련 서비스 로직

	@GetMapping("/customer/signup")
	public String signup() {
		
		log.info("/customer/signup 경로 접근 확인");
		
		return "customer/signup";
	}

	@PostMapping("/customer/signup")
	public String addUserAction(User user) {
		System.out.println(user);

		user.setUserType("CUS");
		int result = userService.saveCustomerUser(user);

		if (result > 0) {
			return "redirect:/main";
		} else {
			return "customer/signup";
		}
	}

	// 중복된 아이디 체크
	@ResponseBody
	@PostMapping("/customer/checkDupId")
	public String checkDupId(@RequestBody String data) {
		// 요청 body 담겨져 오는 데이터를 단순 텍스트로 수신

		// 클라이언트가 전달한 id 값을 받아서, 이게 중복인지 아닌지 DB에서 조회 비교 -> 응답
		System.out.println("/customer/checkDupId");
		System.out.println(data);

		log.info("/customer/checkDupId 아이디 중복체크 요청 값 {}", data);
		
		boolean result = userService.isDuplicated(data);
		System.out.println(result);

		if (result) { // true 중복
			return "Y";
		} else {
			return "N";
		}

		// 중복 Y 중복아니면 N
		// 1 0
		// T F
	}

	@ResponseBody
	@PostMapping("/customer/checkDupIdJson")

	public ApiResponse<String> checkDupIdJson(@RequestBody UserDupCheck userDupCheck) {
										//요청을 객체로 받으면, 내부적으로 알아서 json 포맷을 객체로 파싱 전환
		System.out.println(userDupCheck);
		
		boolean result = userService.isDuplicated(userDupCheck.getId());
		System.out.println(result);
		
		// Y N
		// api response 활용
		// header body
		//		  Y N
		
		ApiResponse<String> apiResponse = new ApiResponse<String>();
		
		//header
		ApiResponseHeader header = new ApiResponseHeader();
		header.setResultCode(ApiCommonCode.API_RESULT_SUCCESS);
		header.setResultMessage(ApiCommonCode.API_RESULT_EMPTY_DATA_MSG);
		
		apiResponse.setHeader(header);
		
		//body
		if (result) {
			apiResponse.setBody("Y");
		} else {
			apiResponse.setBody("N");
		}
		
//	public String checkDupIdJson(@RequestBody String data) {
//		
//		System.out.println(data);	//기본텍스트 형태로 들어와서 추가적인 json 파싱 작업이 필요함.
//		//{"id":"abc","type":"CUS"}
//		// id  type 추출

		return apiResponse;
	}

	@GetMapping("/customer/signin")
	public String signin() {
		return "customer/signin";
	}

	@PostMapping("/customer/signin")
	public String signinAction(User user, HttpSession session) {

		// 로그인처리로직

		System.out.println("로그인시 입력한 값");
		System.out.println(user);

		// 사용자가 입력한 id pw -> DB 비교

		// id pw 맞음녀 로그인 성공?
		// userType

		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		User loginUser = userService.checkUserLogin(user);

		// 성공//실패

		if (loginUser == null) { // 실패
			System.out.println("로그인실패");
			return "customer/signin";
		} else { // 성공
			System.out.println("로그인성공");
			System.out.println(loginUser);

			// 로그인 성공 -> 세션에 아이디 저장
			// session.setAttribute("loginUserId", loginUser.getId());
			LoginManager.setSessionLoginUserId(session, loginUser.getId());

			// return "redirect:/main";
			return "redirect:/customer/mypage"; // 로그인 성공 후 마이페이지로 연결
		}
	}

	@GetMapping("/customer/mypage")
	public String mypage(HttpSession session, Model model) {
		// 로그인되어있는 사용자의 정보가 표시

		// 현재 누가 로그인한 상태? -> session에 있는 "loginUserId" 키값으로 들어있는 아이디 확인

		// 아이디를 기반으로 조회

		// if( session.getAttribute("loginUserId") != null) {
		if (LoginManager.isLogin(session)) {
			// String loginUserId = session.getAttribute("loginUserId").toString();
			String loginUserId = LoginManager.getLoginUserId(session);

			User user = userService.findUserById(loginUserId);

			// view 전달
			model.addAttribute("user", user);

			return "customer/mypage";
		}

		// 로그인이 안되어있으면?? -> 로그인 페이지로 연결
		return "redirect:/customer/signin";
	}

	@GetMapping("/customer/signout")
	public String signout(HttpSession session) {

		// 세션 초기화
		// session.invalidate();
		LoginManager.logout(session);

		return "redirect:/main";
	}

	@GetMapping("/customer/modifyPw")
	public String modifyPw(HttpSession session, Model model) {

		if (LoginManager.isLogin(session)) {
			String loginUserId = LoginManager.getLoginUserId(session);
			User user = userService.findUserById(loginUserId);
			model.addAttribute("user", user);
			return "customer/modifyPw";
		} else {
			return "redirect:/customer/signin";
		}

	}

	@PostMapping("/customer/modifyPw")
	public String modifyPwAction(User user, HttpSession session) {

		int result = userService.modifyPw(user);

		if (result > 0) {
			session.invalidate();
			return "redirect:/customer/signin";
		} else {
			return "redirect:/customer/modifyPw";
		}
	}

	@GetMapping("/customer/modifyPw2")
	public String modifyPw2() {
		return "customer/modifyPw2";
	}

	@PostMapping("/customer/modifyPw2")
	public String modifyPw2Action(User user, HttpSession session) {

		// user 객체에는 사용자가 입력한 바꿀 비번(pw) 데이터 1개만 존재
		// 비번 바꾸려는 사용자 pk id 필요/세팅

		// mypage -> 비번변경 페이지
		// 로그인O -> session 로그인 사용자 아이디 존재

		// set pw = ?
		// where id = ?

		user.setId(LoginManager.getLoginUserId(session));

		// user 객체
		// 로그인한 id
		// 바꿀 pw

		System.out.println(user);

		int result = userService.modifyPw(user);

		if (result > 0) {
			session.invalidate();
			return "redirect:/customer/signin";
		} else {
			return "redirect:/customer/modifyPw2";
		}

	}
}