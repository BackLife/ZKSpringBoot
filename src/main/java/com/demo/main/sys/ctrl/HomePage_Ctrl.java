package com.demo.main.sys.ctrl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Panelchildren;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;


/**
 * Title: AMS_Home_Ctrl.java
 * 
 * @author mapper
 * @date 2018年10月19日
 * @version 1.0 Description:
 */
@SuppressWarnings("all")
public class HomePage_Ctrl extends GenericForwardComposer {

	private static Logger logger = LoggerFactory.getLogger(HomePage_Ctrl.class);

	private static final long serialVersionUID = 1L;
	
	public void doAfterCompose(Component comp) throws Exception {
		SpringUtil.getApplicationContext().getAutowireCapableBeanFactory().autowireBean(this);
		System.out.println("Home_Ctrl====doAfterCompose =======Start ");
		super.doAfterCompose(comp);
		System.out.println("Home_Ctrl====doAfterCompose =======End ");

		addLi(comp);
	}

	public void addLi(Component comp) {

		Panelchildren Panelchildren = (org.zkoss.zul.Panelchildren) comp.getFellowIfAny("schedule");
		String hyperlink = "~./zul/sys/demo.zul";

		for (int i = 0; i < 5; i++) {

			String titleName = "\t 测试页签" + i + "\t\r\n";

			Label lab = new Label(titleName);
			lab.setId(i + "");
			lab.setPre(true);
			lab.setStyle("color:blue;font-size:15px;cursor: pointer;");

			// 添加双击关闭的监听
			EventListener listener = new EventListener() {
				public void onEvent(Event event) throws Exception {
					addTabs(comp.getParent().getParent().getParent().getParent(), hyperlink, titleName);
				}
			};
			lab.addEventListener(Events.ON_CLICK, listener);
//			lab.setContext("sdsdsdsds");

			// lab.setParent(ht);
			// ht.setContent("===================");

			lab.setParent(Panelchildren);

		}

		// System.out.println("==================");

	}

	// 画面点选
	private void addTabs(Component comp, String hyperlink, String menuId) {

		Tabs tabs = (Tabs) comp.getFellowIfAny("tabs");
		Tabpanels Tab_Panel = (Tabpanels) comp.getFellowIfAny("Tab_Panel");

		List<Component> list = tabs.getChildren();

		// 判断页签是否已经被打开，如若打开，直接激活，不再新建
		for (Component con : list) {
			if (con.getId().equals(menuId)) {
				Tabbox tb = (Tabbox) comp.getFellowIfAny("tbx");
				tb.setSelectedTab((Tab) con);
				return;
			}
		}
		if (list.size() > 10) {
			// 最多10个
			Messagebox.show("已达到页签上限", "警告", Messagebox.OK, Messagebox.EXCLAMATION);
			return;
		}

		Tab tab = new Tab(menuId);
		// 添加双击关闭的监听
		EventListener listener = new EventListener() {
			public void onEvent(Event event) throws Exception {
				removeTabs(event, comp, hyperlink, menuId);
			}
		};
		tab.addEventListener(Events.ON_DOUBLE_CLICK, listener);
		// 默认选中
		tab.setSelected(true);
		tab.setId(menuId);
		tab.setParent(tabs);

		Tabpanel aa = new Tabpanel();

		aa.appendChild(Executions.createComponents(hyperlink, aa, null));

		aa.setParent(Tab_Panel);

		// System.out.println("============");

	}

	private void removeTabs(Event event, Component comp, String hyperlink, String menuId) {
		Tabbox tb = (Tabbox) comp.getFellowIfAny("tbx");
		Tab tab = tb.getSelectedTab();

		int num = tb.getSelectedIndex();
		Tabs tabs = (Tabs) comp.getFellowIfAny("tabs");

		Tabpanels Tab_Panel = (Tabpanels) comp.getFellowIfAny("Tab_Panel");
		Tabpanel Panel = tb.getSelectedPanel();
		// 先移除Panel
		if(Panel !=null) {
			Tab_Panel.removeChild(Panel);
		}
		// 再移除tab
		tabs.removeChild(tab);
		// 必须在移除后再进行激活
		tb.setSelectedIndex(num - 1);
		
		tb.getSelectedTab().getId();

		 System.out.println(menuId+"=====remove======="+tb.getSelectedTab().getId());

	}
}
