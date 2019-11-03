import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.util.converter.NumberStringConverter;


/**
 * @author Benjamin Brodwolf
 */
public class ColorPickerPane extends GridPane {
    private final PresentationModel pm;

    private Slider redSlider;
    private Slider greenSlider;
    private Slider blueSlider;

    private TextField redField;
    private TextField greenField;
    private TextField blueField;

    private Rectangle rectangle;

    private ToggleGroup toggleButtonGroup;
    private RadioButton redButton;
    private RadioButton blueButton;
    private RadioButton greenButton;
    private RadioButton yellowButton;
    private RadioButton cyanButton;
    private RadioButton orangeButton;
    private RadioButton blackButton;

    private VBox vBoxButtons;

    public ColorPickerPane(PresentationModel pm) {
        this.pm = pm;
        initializeControls();
        layoutControls();
        setupValueChangeListeners();
        setupBindings();
    }

    private void initializeControls() {
        redSlider = new Slider(0, 255, 0);
        greenSlider = new Slider(0, 255, 0);
        blueSlider = new Slider(0, 255, 0);

        redField = new TextField();
        greenField = new TextField();
        blueField = new TextField();

        rectangle = new Rectangle(200, 200);
        rectangle.setStrokeType(StrokeType.OUTSIDE);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(3);
        rectangle.setFill(Color.WHITESMOKE);

        redButton = new RadioButton("red");
        redButton.setUserData(Color.rgb(155, 0, 0));

        blueButton = new RadioButton("blue");
        blueButton.setUserData(Color.rgb(0, 0, 255));

        greenButton = new RadioButton("green");
        greenButton.setUserData(Color.rgb(0, 255, 0));

        yellowButton = new RadioButton("yellow");
        yellowButton.setUserData(Color.rgb(255, 255, 0));

        cyanButton = new RadioButton("cyan");
        cyanButton.setUserData(Color.rgb(0, 0, 255));

        orangeButton = new RadioButton("orange");
        orangeButton.setUserData(Color.rgb(255, 0, 255));

        blackButton = new RadioButton("black");
        blackButton.setUserData(Color.rgb(0, 0, 0));

        toggleButtonGroup = new ToggleGroup();
        toggleButtonGroup.getToggles().addAll(redButton, blueButton, greenButton, yellowButton, cyanButton, orangeButton, blackButton);

        vBoxButtons = new VBox();
    }

    private void layoutControls() {
        this.setPadding(new Insets(20));
        this.setVgap(10);
        this.setHgap(10);

        this.add(redSlider, 0, 0, 2, 1);
        this.add(greenSlider, 0, 1, 2, 1);
        this.add(blueSlider, 0, 2, 2, 1);


        this.add(redField, 4, 0);
        this.add(greenField, 4, 1);
        this.add(blueField, 4, 2);


        this.add(rectangle, 0, 3);

        vBoxButtons.setPadding(new Insets(10));
        vBoxButtons.setSpacing(10);

        vBoxButtons.getChildren().addAll(redButton, blueButton, greenButton, yellowButton, cyanButton, orangeButton, blackButton);

        this.add(vBoxButtons, 4, 3);

    }

    private void setupValueChangeListeners() {

        ChangeListener<Number> sliderListener = (observable, oldValue, newValue) -> {
            int blue = (int) blueSlider.getValue();
            int red = (int) redSlider.getValue();
            int green = (int) greenSlider.getValue();
            pm.setBlue(blue);
            pm.setRed(red);
            pm.setGreen(green);
            pm.setColor(Color.rgb(red, green, blue).toString());
        };

        redSlider.valueProperty().addListener(sliderListener);
        greenSlider.valueProperty().addListener(sliderListener);
        blueSlider.valueProperty().addListener(sliderListener);

        ChangeListener<String> textListener = (observable, oldValue, newValue) -> {
            int blue = Integer.parseInt(blueField.getText()) ;
            pm.setBlue(blue);

        };

        blueField.textProperty().addListener(textListener);


        toggleButtonGroup.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {
            if (toggleButtonGroup.getSelectedToggle() != null) {

                pm.setColor(toggleButtonGroup.getSelectedToggle().getUserData().toString());
            }
        });

        pm.colorProperty().addListener((observable) -> updateRectangleColor());

    }

    private void updateRectangleColor() {
        Color color = Color.web(pm.getColor(), 1.0);

        this.rectangle.setFill(color);
    }


    private void setupBindings() {
//        redField.textProperty().bind( pm.redProperty().asString());
//        greenField.textProperty().bind( pm.greenProperty().asString());
//        blueField.textProperty().bind( pm.blueProperty().asString());

        redField.textProperty().bindBidirectional(pm.redProperty(), new NumberStringConverter());
        greenField.textProperty().bindBidirectional(pm.greenProperty(), new NumberStringConverter());
        blueField.textProperty().bindBidirectional(pm.blueProperty(), new NumberStringConverter());

    }

}
