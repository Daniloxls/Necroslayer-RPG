package com.nilo.necroslayer.model;

import java.util.ArrayList;

public class Menu {
	private ArrayList<MenuTab> menus = new ArrayList<MenuTab>();
	
	public Menu () {
		menus.add(new MenuTab("Grupo"));
		menus.get(0).setSelected(true);
		menus.add(new MenuTab("Inventário"));
		menus.add(new MenuTab("Habilidades"));
		menus.add(new MenuTab("Opções"));
		menus.add(new MenuTab("Mapa"));
	}
	public ArrayList<MenuTab> getMenus() {
		return this.menus;
	}
	public void addTab(String name) {
		this.menus.add(new MenuTab(name));
	}
	public MenuTab getSelectedMenu() {
		for(MenuTab menu: menus) {
			if(menu.isSelected()) return menu;
		}
		return null;
	}
	public void menuUp() {
		int aux = menus.indexOf(this.getSelectedMenu());
		if(aux == 0) {
			this.getSelectedMenu().setSelected(false);
			menus.get(menus.size() - 1).setSelected(true);
		} else {
			this.getSelectedMenu().setSelected(false);
			menus.get(aux - 1).setSelected(true);
		}
	}
	public void menuDown() {
		int aux = menus.indexOf(this.getSelectedMenu());
		if(aux == menus.size() - 1) {
			this.getSelectedMenu().setSelected(false);
			menus.get(0).setSelected(true);
		} else {
			this.getSelectedMenu().setSelected(false);
			menus.get(aux + 1).setSelected(true);
		}
	}
	
}
