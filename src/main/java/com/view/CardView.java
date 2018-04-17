package com.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class CardView {
    private ImageView backCard;
    private ImageView cardImg;

    CardView() {

    }

    void setCard(int valueCard, int suitCard) {
        this.backCard = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("card/card_back_black.png")));
        this.cardImg = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("card/cards/" + valueCard + "_of_" + suitCard + ".png")));
        this.backCard.setFitHeight(90);
        this.backCard.setFitWidth(60);
        this.cardImg.setFitHeight(90);
        this.cardImg.setFitWidth(60);
    }

    ImageView getCloseImg() {
        return this.backCard;
    }

    ImageView getCardImg() {
        return this.cardImg;
    }
}
