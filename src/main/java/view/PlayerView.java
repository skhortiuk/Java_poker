package view;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import model.Card;

public class PlayerView {
    private CardView cardView = new CardView();
    private VBox root = new VBox();
    private HBox chips = new HBox();
    private HBox cards = new HBox(5);
    private HBox name = new HBox();
    private HBox stack = new HBox();
    private Label stackLable = new Label();
    private Label chipsLable = new Label();
    private Label nameLable = new Label();

    public PlayerView() {
        chipsLable.setTextFill(Paint.valueOf("Red"));
        chipsLable.setFont(Font.font(20));
        root.getChildren().addAll(this.chips, this.cards, this.name, this.stack);
        this.chips.setPrefHeight(10);
        this.cards.setPrefSize(60, 90);
        chipsLable.setText("");
        this.chips.getChildren().addAll(chipsLable);
    }

    public void setCards(Card card, boolean Visible) {
        cardView.setCard(card.getValue(), card.getSuitValue());
        if (!Visible) {
            cards.getChildren().addAll(cardView.getCloseImg());
        } else {
            cards.getChildren().addAll(cardView.getCardImg());
        }
    }

    public void setPosition(int x, int y) {
        root.setTranslateX(x);
        root.setTranslateY(y);
    }

    public VBox getRoot() {
        return root;
    }

    public void setChips(int chips) {
        this.chips.getChildren().clear();
        chipsLable.setText(chips + "");
        this.chips.getChildren().addAll(chipsLable);
    }

    public void setName(String name) {
        this.name.getChildren().clear();
        this.name.getChildren().addAll(nameLable);
        nameLable.setTextFill(Paint.valueOf("#948608"));
        nameLable.setFont(Font.font(20));
        nameLable.setText(name);
    }

    public void setStack(int number) {
        this.stack.getChildren().clear();
        stackLable.setTextFill(Paint.valueOf("Green"));
        stackLable.setFont(Font.font(15));
        stackLable.setText("" + number);
        this.stack.getChildren().addAll(stackLable);
    }

    public void clearChips() {
        this.chips.getChildren().clear();
        chipsLable.setText("");
        this.chips.getChildren().addAll(chipsLable);
    }

    public void clearCards() {
        this.cards.getChildren().clear();
    }

    public void del() {
        this.root.getChildren().clear();
    }
}
