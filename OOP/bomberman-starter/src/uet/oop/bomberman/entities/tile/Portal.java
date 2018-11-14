package uet.oop.bomberman.entities.tile;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.level.Coordinates;

public class Portal extends Tile {

    protected Board _board;

    public Portal(int x, int y, Board board, Sprite sprite) {
        super(x, y, sprite);
        _board = board;
    }

    @Override
    public boolean collide(Entity e) {
        // TODO: xử lý khi Bomber đi vào
        if (e instanceof Bomber) {
            if (_board.detectNoEnemies() == false) {
                return false;
            }

            if((int)getX() == Coordinates.pixelToTile(((Bomber) e).getCenterX()) &&
                    (int)getY() == Coordinates.pixelToTile(((Bomber) e).getCenterY())-1) {
                if (_board.detectNoEnemies()) {
                    _board.nextLevel();
                }
            }

            return true;
        }
        return false;
    }

}
