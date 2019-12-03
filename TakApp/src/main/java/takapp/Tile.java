/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takapp;

import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import domain.GameLogic;
import static takapp.TakApp.TILE_SIZE;

/**
 *
 * @author meriraja
 */
public class Tile extends Rectangle {
    
    
    //todo: tile will have to be able to hold multiple pieces
    
    public Piece piece;
    
    public boolean hasPiece() {
        return piece != null;
    }
    
    public Piece getPiece() {
        return this.piece;
    }
    
    public Tile(GameLogic logic, int x, int y) {
        
        setWidth(TakApp.TILE_SIZE);
        setHeight(TakApp.TILE_SIZE);
        
        relocate(x * TakApp.TILE_SIZE, y * TakApp.TILE_SIZE);
        Image tilebg = new Image(getClass().getResourceAsStream("/images/tile.jpg"));
        ImagePattern imagePattern = new ImagePattern(tilebg);
        setFill(imagePattern);
        
        if (this.hasPiece() == false) {
        
            setOnMousePressed(e -> {
                String pieceColor = logic.checkTurn();
                Piece piece = logic.makePiece(pieceColor, x, y);
                this.piece = piece;
                logic.setPiece(piece, x, y);
            });
            
        }
    }
}
