package uet.oop.bomberman.entities.character.enemy.ai;

import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.entities.character.enemy.Enemy;

public class AIMedium extends AI {

    Bomber _player;
	Enemy _e;
	
	public AIMedium(Bomber player, Enemy e) {
		_player = player;
		_e = e;
	}

	@Override
	public int calculateDirection() { // tránh bom


		if(_player == null)
			return random.nextInt(4);

		if(_player.get_bombs().isEmpty() ) {

			int vertical = random.nextInt(2);

			if(vertical == 1) {
				int v = calculateRowDirection();
				if(v != -1)
					return v;
				else
					return calculateColDirection();

			} else {
				int h = calculateColDirection();

				if(h != -1)
					return h;
				else
					return calculateRowDirection();
			}
		}

		if(_player.get_bombs().size() > 0 && nearlyBomb()) {

			int disX = _e.getXTile() - (int)_player.get_bombs().get(0).getX();
			int disY = _e.getYTile() - (int)_player.get_bombs().get(0).getY();

                    switch (disX) {
                        case -2:
                            return random.nextInt(2) == 0 ? 3 : (random.nextInt(2) == 0 ? 0 : 2);
                        case -1:
                        switch (disY) {
                            case -1:
                                return random.nextInt(2) == 0 ? 0 : 3;
                            case 0:
                                return 3;
                            case 1:
                                return random.nextInt(2) == 0 ? 2 : 3;
                            default:
                                break;
                        }
                            break;
                        case 0:
                        switch (disY) {
                            case -1:
                                return 0;
                            case 1:
                                return 2;
                            case -2:
                                return random.nextInt(2) == 0 ? 0 : (random.nextInt(2) == 0 ? 1 : 3);
                            case 2:
                                return random.nextInt(2) == 0 ? 2 : (random.nextInt(2) == 0 ? 1 : 3);
                            default:
                                break;
                        }
                            break;
                        case 1:
                        switch (disY) {
                            case -1:
                                return random.nextInt(2) == 0 ? 0 : 1;
                            case 0:
                                return 1;
                            case 1:
                                return random.nextInt(2) == 0 ? 2 : 1;
                            default:
                                break;
                        }
                            break;
                        case 2:
                            return random.nextInt(2) == 0 ? 1 : (random.nextInt(2) == 0 ? 0 : 2);
                        default:
                            break;
                    }
		}
		return random.nextInt(4);
	}

	protected boolean nearlyBomb() {
		int disX = _e.getXTile() - (int)_player.get_bombs().get(0).getX();
		int disY = _e.getYTile() - (int)_player.get_bombs().get(0).getY();

		if(disX == 0 && disY >= -2 && disY <= 2) return true;
		if(disY == 0 && disX >= -2 && disX <= 2) return true;
		return disX == -1 || disX == 1 && disY == -1 || disY == 1;
	}

	protected int calculateColDirection() {
		if(_player.getXTile() < _e.getXTile())
			return 3;
		else if(_player.getXTile() > _e.getXTile())
			return 1;

		return -1;
	}

	protected int calculateRowDirection() {
		if(_player.getYTile() < _e.getYTile())
			return 0;
		else if(_player.getYTile() > _e.getYTile())
			return 2;
		return -1;
	}


        
}
