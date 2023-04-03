package com.nilo.necroslayer.screens;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.nilo.necroslayer.model.MapaBlocos;
import com.nilo.necroslayer.model.Player;

public class PlayerCamera extends OrthographicCamera{
	public float x,y;
	
	PlayerCamera(Player player, MapaBlocos mapa){
		this.near = 0;
		if(player.targetX < 7) {
			this.x = 448;
			
		}
		else if (player.targetX > mapa.width - 7) {
			this.x = (mapa.width - 7)*64;
		}
		else if(player.targetY < 4) {
			this.x = 256;
			
		}
		else if (player.targetY > mapa.width - 4) {
			this.x = (mapa.width - 4)*4;
		}
		
		//this.translate(this.x, this.y);
		this.update();
	}

	
	public void follow(Player player, MapaBlocos mapa) {
		if(player.isWalking) {
			if (player.isMovingLeft) {
				if (this.position.x > 512) {
					this.translate(-2f, 0);
				}
			}else if (player.isMovingRight) {
				if (this.position.x < (mapa.width-8)*64) {
					this.translate(2f, 0);
					}
			}else if (player.isMovingDown) {
				if (this.position.y > 288) {
					this.translate(0, -2f);
				}
			}else if (player.isMovingUp) {
				if (this.position.y < (mapa.height-4.5)*64) {
					this.translate(0, 2f);
					}
			}
		}
	}

}
