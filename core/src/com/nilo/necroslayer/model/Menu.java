package com.nilo.necroslayer.model;

import java.util.ArrayList;

import com.nilo.necroslayer.screens.MenuScreen.Infos;

public class Menu {
	private ArrayList<MenuTab> menus = new ArrayList<MenuTab>();
	public Menu () {
		menus.add(new MenuTab("Grupo", Infos.PARTY));
		menus.get(0).setSelected(true);
		menus.add(new MenuTab("Inventário", Infos.BACKPACK));
		menus.add(new MenuTab("Habilidades", Infos.SKILLS));
		menus.add(new MenuTab("Opções", Infos.OPTIONS));
		menus.add(new MenuTab("Mapa", Infos.MAP));
	}
	public ArrayList<MenuTab> getMenus() {
		return this.menus;
	}
	public void addTab(String name, Infos tipo) {
		this.menus.add(new MenuTab(name, tipo));
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