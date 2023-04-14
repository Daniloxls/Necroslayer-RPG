package com.nilo.necroslayer.model;

import java.util.ArrayList;

import com.nilo.necroslayer.character.Charac;
import com.nilo.necroslayer.character.Party;
import com.nilo.necroslayer.jobs.Job;
import com.nilo.necroslayer.screens.MenuScreen.Infos;

public class PartyTab extends MenuTab {
	
	ArrayList<Charac> listChar;
	int selectedChar;
	
	public Charac getSelected() {
		return this.listChar.get(selectedChar);
	}
	
	public PartyTab(String name, Infos tipo, Party party) {
		super(name, tipo);
		this.listChar = party.getComp();
		this.selectedChar = 0;
		}
	public void downChar() {
		if(selectedChar == listChar.size() - 1) {
			selectedChar = 0;
		} else {
			selectedChar++;
		}
	}
	public void upChar() {
		if(selectedChar == 0) {
			selectedChar = listChar.size() - 1;
		} else {
			selectedChar--;
		}
	}
	public void alterarJob(Job newJob) {
		listChar.get(selectedChar).setJob(newJob);
	}
	

}
