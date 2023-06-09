package com.nilo.necroslayer.screens;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.nilo.necroslayer.model.MapaBlocos;
import com.nilo.necroslayer.model.Player;

public class PlayerCamera extends OrthographicCamera{
	public float startX,startY;
	public final int GAME_WORLD_HEIGHT = 576;
	public final int GAME_WORLD_WIDTH = 1024;
	
	PlayerCamera(Player player, MapaBlocos mapa){
		this.near = 0;
		if (player.targetX > mapa.width - 7) {
			this.position.x = (mapa.width-8)*64;
		}else if( player.targetX > 8){
			this.position.x = player.targetX*64;
		}else if (player.targetX <= 8) {
			this.position.x = GAME_WORLD_WIDTH/2;
		}
		if (player.targetY > mapa.height - 4.5) {
			this.position.y = (mapa.height*64)-288;
		}else if( player.targetY > 4.5){
			this.position.y = player.targetY*64;
		}else if (player.targetY <= 4.5) {
			this.position.y = GAME_WORLD_HEIGHT/2;
		}
		this.update();
	}
	
	PlayerCamera(int x, int y, MapaBlocos mapa){
		this.near = 0;
		if (x > mapa.width - 7) {
			this.position.x = (mapa.width-8)*64;
		}else if( x > 8){
			this.position.x = x*64;
		}else if (x <= 8) {
			this.position.x = GAME_WORLD_WIDTH/2;
		}
		if (y > mapa.height - 4.5) {
			this.position.y = (mapa.height*64)-288;
		}else if( y > 4.5){
			this.position.y = y*64;
		}else if (y <= 4.5) {
			this.position.y = GAME_WORLD_HEIGHT/2;
		}
		this.update();
	}

	
	public void follow(Player player, MapaBlocos mapa) {
		if(player.isWalking) {
			if(player.posX < (mapa.width-8)*64){
				if (this.position.x > 512) {
					if(player.getTileX() > player.targetX) {
						this.translate(-2f, 0);
					}
				}
			}
			if (player.posX > 512) {
				if (this.position.x < (mapa.width-8)*64) {
					if(player.getTileX() < player.targetX) {
						this.translate(2f, 0);
					}
				}
			}
			if (player.posY < (mapa.height-4.5)*64) {
				if (this.position.y > 288) {
					if(player.getTileY() > player.targetY) {
						this.translate(0, -2f);
					}
				}
			}
			if(player.posY > 288) {
				if (this.position.y < (mapa.height-4.5)*64) {
					if(player.getTileY() < player.targetY) {
						this.translate(0, 2f);
					}
				}
			}
		}
	}

}
