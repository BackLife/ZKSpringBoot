package com.demo.main.sys.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Label;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Tree;

/**
 * Title: Menu_Ctrl.java
 * 
 * @author mapper
 * @date 2018年10月16日
 * @version 1.0 Description: 生成菜单树
 */
//@Controller 这里不能使用Spring  @Controller注入，会与手工注入冲突  入口不由Spring管理，交由ZK组件管理
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Menu_Ctrl extends GenericForwardComposer {

	private static Logger logger = LoggerFactory.getLogger(Menu_Ctrl.class);

	private static final long serialVersionUID = 1L;

	Label lbl_DefFunc;
	// Label menuId;

	Label lbl_user;
	Tree thetree;
	Tabbox tb;
	Tabs tabs;
	Tabpanels Tab_Panel;
//
//	@Autowired
//	private Menu_Service MenuServices;
//
//	public void doAfterCompose(Component comp) throws Exception {
//		System.out.println("IAR_MENU_Ctrl====doAfterCompose =======Start ");
//		super.doAfterCompose(comp);
//		System.out.println("IAR_MENU_Ctrl====doAfterCompose =======End ");
//		lbl_user.setValue(" 您好 "+usrName+" !!! ");
//		getMenuList();
//	}
//
//	public void getMenuList() {
//		try {
//
//			// 取菜单树
//			ArrayList menuList = MenuServices.getMenu(usrId);
//			
//			// 封装菜单
//			DefaultTreeNode root = new DefaultTreeNode("ROOT", menuList);
//
//			// create treemodel and assigned its root
//			DefaultTreeModel stm = new DefaultTreeModel(root);
//
//			// create a PersonTreeitemRenderer
//			MyTreeitemRenderer ftr = new MyTreeitemRenderer();
//
//			// System.out.println("OK");
////			thetree.setZclass("z-dottee");
//			thetree.setModel(stm);
//			thetree.setItemRenderer(ftr);
//
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//	}

}
