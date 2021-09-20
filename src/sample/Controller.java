package sample;


import javafx.animation.TranslateTransition;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller extends Thread implements Initializable {
    int moveCount = Main.moveCount;
    boolean takedGold = Main.takedGold;
    int goldCount = Main.goldCount;
    int summaryGoldCount = Main.summaryGoldCount;
    int healthCount = 3;


    @FXML
    public Rectangle rectangle;
    public ImageView displayImage;
    public Circle leftCircle;
    public Circle rightCircle;
    public ImageView aquaman1;
    public ImageView aquaman2;
    public ImageView aquaman3;
    public ImageView tentacle1;
    public ImageView tentacle2;
    public ImageView tentacle3;
    public ImageView tentacle4;
    public ImageView tentacle5;
    public Label labelCount;
    public Label labelGame;

    Image position0 = new Image(getClass().getResourceAsStream("aquaman.png"));
    Image position1 = new Image(getClass().getResourceAsStream("APosition1.png"));
    Image position2 = new Image(getClass().getResourceAsStream("APosition2.png"));
    Image position3 = new Image(getClass().getResourceAsStream("APosition3.png"));
    Image position4 = new Image(getClass().getResourceAsStream("APosition4.png"));
    Image position5 = new Image(getClass().getResourceAsStream("APosition5.png"));
    Image position1G = new Image(getClass().getResourceAsStream("APosition1G.png"));
    Image position2G = new Image(getClass().getResourceAsStream("APosition2G.png"));
    Image position3G = new Image(getClass().getResourceAsStream("APosition3G.png"));
    Image position4G = new Image(getClass().getResourceAsStream("APosition4G.png"));
    Image position5G = new Image(getClass().getResourceAsStream("APosition5G.png"));


    //Image tentacle1 = new Image(getClass().getResourceAsStream("tentacle1.final.png"));

    public int touchCircleL() {
        if (takedGold && moveCount == 1) {
            moveCount -= 1;
            summaryGoldCount += (goldCount += 2);
            System.out.println("Position: " + moveCount + "-> gold in the wood: " + goldCount);
            System.out.println("Total gold count: " + summaryGoldCount);
            score();
            takedGold = false;
        } else {
            if (moveCount > 1) {
                moveCount -= 1;
                System.out.println("Position: " + moveCount);

            }
        }
        aquamanPositions();
        return moveCount;
    }

    public int touchCircleR() {
        if (moveCount == 5) {
            takedGold = true;
            goldCount += 1;
            System.out.println("Position: " + moveCount + "-> taked gold +" + goldCount);
            score();

        } else {
            if (moveCount <= 4) {
                moveCount += 1;
                System.out.println("Position: " + moveCount);

            }
        }
        aquamanPositions();
        return moveCount;
    }

    public int aquamanPositions() {
        switch (moveCount) {
            case 0:
                aquaman1.setLayoutX(190);
                aquaman1.setLayoutY(80);
                aquaman1.setImage(position0);
                break;
            case 1:
                aquaman1.setLayoutX(185);
                aquaman1.setLayoutY(130);
                if (!takedGold) {
                    aquaman1.setImage(position1);
                } else {
                    aquaman1.setImage(position1G);
                }
                break;
            case 2:
                aquaman1.setLayoutX(195);
                aquaman1.setLayoutY(180);
                if (!takedGold) {
                    aquaman1.setImage(position2);
                } else {
                    aquaman1.setImage(position2G);
                }
                break;
            case 3:
                aquaman1.setLayoutX(260);
                aquaman1.setLayoutY(215);
                if (!takedGold) {
                    aquaman1.setImage(position3);
                } else {
                    aquaman1.setImage(position3G);
                }
                break;
            case 4:
                aquaman1.setLayoutX(320);
                aquaman1.setLayoutY(220);
                if (!takedGold) {
                    aquaman1.setImage(position4);
                } else {
                    aquaman1.setImage(position4G);
                }
                break;
            case 5:
                aquaman1.setLayoutX(390);
                aquaman1.setLayoutY(220);
                if (!takedGold) {
                    aquaman1.setImage(position5);
                } else {
                    aquaman1.setImage(position5G);
                }
                break;
            default:
                break;
        }
        return aquamanPositions();
    }

    public void score() {
        String countString = String.valueOf(goldCount);
        if (String.valueOf(goldCount).length() == 1) {
            labelCount.setText("00" + countString);
        } else if (String.valueOf(goldCount).length() == 2) {
            labelCount.setText("0" + countString);
        } else if (String.valueOf(goldCount).length() == 3) {
            labelCount.setText(countString);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Thread thread = new Thread ();
        thread.start();

        TranslateTransition translate1 = new TranslateTransition();
        TranslateTransition translate2 = new TranslateTransition();
        TranslateTransition translate3 = new TranslateTransition();
        TranslateTransition translate4 = new TranslateTransition();
        TranslateTransition translate5 = new TranslateTransition();

        translate1.setNode(tentacle1);
        translate2.setNode(tentacle2);
        translate3.setNode(tentacle3);
        translate4.setNode(tentacle4);
        translate5.setNode(tentacle5);

        translate1.setDuration(Duration.seconds(3.0));
        translate2.setDuration(Duration.seconds(3.1));
        translate3.setDuration(Duration.seconds(3.6));
        translate4.setDuration(Duration.seconds(4.0));
        translate5.setDuration(Duration.seconds(2.8));

        translate1.setCycleCount(TranslateTransition.INDEFINITE);
        translate2.setCycleCount(TranslateTransition.INDEFINITE);
        translate3.setCycleCount(TranslateTransition.INDEFINITE);
        translate4.setCycleCount(TranslateTransition.INDEFINITE);
        translate5.setCycleCount(TranslateTransition.INDEFINITE);

        translate1.setAutoReverse(true);
        translate2.setAutoReverse(true);
        translate3.setAutoReverse(true);
        translate4.setAutoReverse(true);
        translate5.setAutoReverse(true);

        translate1.setByX(-60);
        translate2.setByX(-69);
        translate3.setByX(-28);
        translate4.setByX(-10);
        translate5.setByX(10);

        translate1.setByY(0);
        translate2.setByY(46);
        translate3.setByY(76);
        translate4.setByY(51);
        translate5.setByY(35);

        translate1.play();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        translate2.play();
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        translate3.play();
        translate4.play();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        translate5.play();

        collision(tentacle1);
        collision(tentacle2);
        collision(tentacle3);
        collision(tentacle4);
        collision(tentacle5);

    }

    // Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));

    public void collision(ImageView imageView) {
        BooleanBinding collision = Bindings.createBooleanBinding(
                () -> aquaman1.getBoundsInParent().intersects(imageView.getBoundsInParent()),
                aquaman1.boundsInParentProperty(),
                imageView.boundsInParentProperty()
        );

        collision.addListener((obs, wasCollision, isNowCollision) -> {
            if (isNowCollision) {
                healthCount-=1;
                healthChecker();
            }
        });
    }

    public void restart(){
        takedGold = false;
        aquaman1.setVisible(true);
        aquaman2.setVisible(true);
        aquaman3.setVisible(true);
    }
    public void healthChecker(){
        switch (healthCount) {
            case 2 -> {
                moveCount = 0;
                aquamanPositions();
                takedGold = false;
                aquaman3.setVisible(false);
                System.out.println("Boom");
            }
            case 1 -> {
                moveCount = 0;
                aquamanPositions();
                takedGold = false;
                aquaman2.setVisible(false);
                System.out.println("Boom");
            }
            case 0 -> {
                moveCount = 0;
                aquamanPositions();
                aquaman1.setVisible(false);
                labelGame.setText("GAME OVER");
            }
            default -> restart();
        }
    }
}