package org.wangyu.ems.intercepors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.wangyu.ems.entity.Employee;

/**
 * 配置拦截器，拦截器归于spring管理，
 * @author Bennie
 *
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
	
	/**
	 * @param HttpServletRequest ,HttpServletResponse
	 * @return boolean
	 * 在请求到达handler之前，进行判断，true是url发往handler，false则进行拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		if (employee == null) {
			return false;
		} else {
			return true;
		}

	}
	
	/**
	 * @param HttpServletRequest ,HttpServletResponse
	 * @return void
	 * 执行完handler逻辑后在返回视图渲染层之前控制modelAndView的值
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
