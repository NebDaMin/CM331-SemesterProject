/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm331montyhall;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author rndmorris
 */
public class SelectionHandler implements EventHandler<MouseEvent>{
    
    private final DoorImage[] doorImages;
    private final GameInstance currentGame;
    private Button nextBtn;
    
    public SelectionHandler(DoorImage[] doorImages, GameInstance currentGame) {
        super();
        this.doorImages = doorImages;
        this.currentGame = currentGame;
    }
    @Override
    public void handle (MouseEvent event) {
        DoorImage source = (DoorImage)event.getSource();
        if (!source.getDoor().isOpened()) {
            for (DoorImage doorImage : doorImages) {
                doorImage.setSelected(false);
            }
            doorImages[source.getDoor().getId()].setSelected(true);
            currentGame.setCurrentSelection(source.getDoor().getId());
            this.nextBtn.setDisable(false);
        }
    }
    public void setNextBtn(Button nextBtn) {
        this.nextBtn = nextBtn;
    }
}

