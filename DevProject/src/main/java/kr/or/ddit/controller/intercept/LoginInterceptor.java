package kr.or.ddit.controller.intercept;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final String USER_INFO = "userInfo";
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("preHandler...!");
		
		String requestURL = request.getRequestURL().toString();		// http://localhost.login1
		String requestURI = request.getRequestURI();				// login1
		
		// 리플렉션??
		
		log.info("requestURL : " + requestURL);
		log.info("requestURI : " + requestURI);
		
		HandlerMethod method = (HandlerMethod) handler;
		Method methodObj = method.getMethod();
		
		log.info("Bean : " + method.getBean());	// kr.or.ddit.controller.login.LoginController@3213h123
		log.info("method : " + methodObj);		// public java.lang.String kr.or.ddit.controller.login.LoginController.loginForm()
		
		// 키 'userInfo'를 가지고 있는 세션이 존재하면 삭제 처리로 초기화
		HttpSession session = request.getSession();
		if(session.getAttribute(USER_INFO) != null) {
			session.removeAttribute(USER_INFO);
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("postHandle...!");

		String requestURL = request.getRequestURL().toString();		// http://localhost.login1
		String requestURI = request.getRequestURI();				// login1
		
		log.info("requestURL : " + requestURL);
		log.info("requestURI : " + requestURI);
		
		HandlerMethod method = (HandlerMethod) handler;
		Method methodObj = method.getMethod();
		
		log.info("Bean : " + method.getBean());
		log.info("Method : " + methodObj);
		
		HttpSession session = request.getSession();
		
		// 컨트롤러 메소드를 거쳤다가 postHandle로 넘어오면서 전달된 user라는 키에 value로 member가 담긴 값이
		// Model에 담겨져 있다. 그 중에 'user'로 넘긴 값이 로그인 후 인증된 회원 1명의 정보가 담긴 MemberVO 자바빈즈 객체가 되고 
		// 객체가 null이 아닌경우 메인화면으로 리다이렉트 처리한다.
		ModelMap modelMap = modelAndView.getModelMap();
		Object member = modelMap.get("user");
		
		if(member != null) {
			log.info("member : " + member);
			log.info("member != null");
			session.setAttribute(USER_INFO, member);
			response.sendRedirect("/");
		}
	}

	// DispatcherServlet의 화면 처리가 완료된 상태에서 처리한다.
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("afterCompletion...!");
		
		String requestURL = request.getRequestURL().toString();		// http://localhost.login1
		String requestURI = request.getRequestURI();				// login1
		
		log.info("requestURL : " + requestURL);
		log.info("requestURI : " + requestURI);
		
		HandlerMethod method = (HandlerMethod) handler;
		Method methodObj = method.getMethod();
		
		log.info("Bean : " + method.getBean());
		log.info("Method : " + methodObj);
	}
	
}
