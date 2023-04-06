package com.nilo.necroslayer.model;

import com.nilo.necroslayer.screens.MenuScreen.Infos;

public class MenuTab {
	private String name;
	private boolean isSelected;
	private Infos tipo;
	public MenuTab(String name, Infos tipo) {
		this.name = name;
		this.isSelected = false;
		this.setTipo(tipo);
	}
	public boolean isSelected() {
		return isSelected;
	}
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Infos getTipo() {
		return tipo;
	}
	public void setTipo(Infos tipo) {
		this.tipo = tipo;
	}
	
}
