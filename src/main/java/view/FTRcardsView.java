package view;

import javafx.scene.layout.HBox;
import model.Card;

public class FTRcardsView {
    private CardView cardView = new CardView();
    private HBox root = new HBox(5);
    private HBox main = new HBox(root);

    public FTRcardsView() {
        main.setTranslateX(340);
        main.setTranslateY(200);
    }

    public HBox getRoot() {
        return main;
    }

    public void setCard(Card card) {
        if (main.getChildren().isEmpty()) {
            main.getChildren().addAll(root);
        }
        cardView.setCard(card.getValue(), card.getSuitValue());
        root.getChildren().addAll(cardView.getCardImg());
    }

    public void clear() {
        root.getChildren().clear();
        main.getChildren().clear();
    }
}
