package com.nilo.necroslayer.model;

public class MenuTab {
	private String name;
	private boolean isSelected;
	
	public MenuTab(String name) {
		this.name = name;
		this.isSelected = false;
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
	
}
