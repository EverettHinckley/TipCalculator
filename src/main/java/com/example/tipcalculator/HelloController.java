package com.example.tipcalculator;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField billAmount;
    @FXML
    private Label tipPercentage;
    @FXML
    private Slider percentageChanger;
    @FXML
    private TextField tipAmount;
    @FXML
    private TextField totalAmount;

    public void initialize(){
        percentageChanger.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue){
                tipPercentage.setText((int)(newValue.intValue()*0.4)+"%");
            }
                }
            );
    }
    public void handleCalculateButtonClicked(){
        tipAmount.clear();
        totalAmount.clear();
        try{
            double tip=Double.parseDouble(tipPercentage.getText().substring(0,2))/100.0*Double.parseDouble(billAmount.getText());
            double total=Double.parseDouble(billAmount.getText())+tip;
            tipAmount.setText("$"+String.format("%.2f",tip));
            totalAmount.setText("$"+String.format("%.2f",total));
            billAmount.clear();
        }
        catch(NumberFormatException e){
            billAmount.setText("Invalid amount");
            billAmount.selectAll();
            billAmount.requestFocus();
        }
    }
}