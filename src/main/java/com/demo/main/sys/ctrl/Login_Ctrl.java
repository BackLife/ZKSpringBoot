package com.demo.main.sys.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

/**
 * 
* Title: Login_Ctrl.java 
* @author mapper  
* @date 2019年1月9日  
* @version 1.0    
* Description:
 */
@SuppressWarnings("all")
public class Login_Ctrl extends GenericForwardComposer {

	private static Logger logger = LoggerFactory.getLogger(Login_Ctrl.class);

	private static final long serialVersionUID = 1L;

	private Textbox userName, userPwd;

	String userId = "";
	String passWord = "";
	String loginIP = "";

//	@Autowired
//	private Login_Service loginService;
	
	

	public void doAfterCompose(Component comp) throws Exception {
		System.out.println("====Login_Ctrl====doAfterCompose===Start==");
		SpringUtil.getApplicationContext().getAutowireCapableBeanFactory().autowireBean(this);
		super.doAfterCompose(comp);
	}

	public void onClick$login() {
		System.out.println("====Login_Ctrl====Login===Start==");
		logger.debug("====Login_Ctrl====onLogin===Start==");
		
		int resultCode = -1;

		if (userName.getValue() != null && !userName.getValue().equals("")) {
			userId = userName.getValue().trim();
		}

		if (userPwd.getValue() != null && !userPwd.getValue().equals("")) {
			passWord = userPwd.getValue().trim();
		}

		System.out.println("UserId======" + userId);
		System.out.println("Password====" + passWord);
		logger.debug("====UserId=={},Password===={}", userId, passWord);

		try {

			// 取登入者IP
			if (Sessions.getCurrent().getRemoteAddr() != null && !Sessions.getCurrent().getRemoteAddr().equals("")) {
				loginIP = Sessions.getCurrent().getRemoteAddr().trim();
			}
			
			// 有任一账号或密码为空则停止
			if (userId == null   || "".equals(userId.trim())   || userId.isEmpty() ||
				passWord == null || "".equals(passWord.trim()) ||userId.isEmpty() ) {
				Messagebox.show("输入之账号或密码不对, 请检查后再输入!!! ", "警告讯息!!! ", Messagebox.OK, Messagebox.ERROR);
				return;
			}

			// 身分验证成功，将用户信息放至 Session 中
//			V_USR_ROLE user2 = new V_USR_ROLE();
//			resultCode = loginService.Login(userId, passWord, loginIP);

			// 设定登入者数据, 放入 Session
//			V_USR_ROLE loginuser = new LoginUser(user2, loginIP);
//			Sessions.getCurrent(true);
//			Sessions.getCurrent().setAttribute("AMS.LoginUser", loginuser);

//			System.out.println("==========go to MENU============="+RedisKeyConstant.getRedis2KValue("AMS.2k.DefaultPage.MENU#"));
//			Executions.getCurrent().sendRedirect(RedisKeyConstant.getRedis2KValue(RedisKeyConstant.MENU_PAGE));
			return;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
		}
	}

}
