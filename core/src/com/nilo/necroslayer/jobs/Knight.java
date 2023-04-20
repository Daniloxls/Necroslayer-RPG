package com.nilo.necroslayer.jobs;

import java.util.ArrayList;

import com.nilo.necroslayer.character.Charac;

public class Knight extends Job{

	public Knight(Charac c){
		super(c);
		this.setId(12);
		this.setAbilityName("Defender");
	}

	@Override
	public void ability() {
		this.getCharac().setDefend(true);
		
	}
}
