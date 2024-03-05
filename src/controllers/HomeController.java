package controllers;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import models.Order;

public class HomeController implements Initializable{
	
	private final ObservableList<String> crustTypeList = FXCollections.observableArrayList(
			"Normal", "Thin", "Deep Dish");

	@FXML
	private TextField name_tfd, phone_tfd, quatity_tfd;

	@FXML
	private TextArea summary_tarea;

	@FXML
	private Button clear_btn, placeOrder_btn;

	@FXML
	private ToggleGroup SizeGroup;
	@FXML
	private RadioButton sizeS_rBtn, sizeM_rBtn, sizeL_rBtn, sizeXL_rBtn;

	@FXML
	private ChoiceBox<String> type_cBox;

	@FXML
	private CheckBox top1_chkBox, top2_chkBox, top3_chkBox, top4_chkBox, 
					 top5_chkBox, top6_chkBox, top7_chkBox, top8_chkBox,
					 top9_chkBox, top10_chkBox, top11_chkBox, top12_chkBox, 
					 top13_chkBox, top14_chkBox, top15_chkBox, top16_chkBox;


	private Set<String> selectedCheckBoxes = new HashSet<String>();
	private Order order;
	private int pizzaQuantity;
	private String custName;
	private String custPhone;
	private String pizzaSize = "Medium";
	private String pizzaType;
	private String[] pizzaToppings;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		type_cBox.getItems().addAll(crustTypeList);
		type_cBox.setOnAction(this::typeChoiceBoxSelected);
		sizeS_rBtn.setUserData("Small");
		sizeM_rBtn.setUserData("Medium");
		sizeL_rBtn.setUserData("Large");
		sizeXL_rBtn.setUserData("Extra Large");
	}
	
	public void typeChoiceBoxSelected(ActionEvent event) {
		pizzaType = type_cBox.getValue();
	}
	
	public void toppingCheckBoxSelected(ActionEvent event) {
		if (top1_chkBox.isSelected())  selectedCheckBoxes.add(top1_chkBox.getText());
		if (top2_chkBox.isSelected())  selectedCheckBoxes.add(top2_chkBox.getText());
		if (top3_chkBox.isSelected())  selectedCheckBoxes.add(top3_chkBox.getText());
		if (top4_chkBox.isSelected())  selectedCheckBoxes.add(top4_chkBox.getText());
		if (top5_chkBox.isSelected())  selectedCheckBoxes.add(top5_chkBox.getText());
		if (top6_chkBox.isSelected())  selectedCheckBoxes.add(top6_chkBox.getText());
		if (top7_chkBox.isSelected())  selectedCheckBoxes.add(top7_chkBox.getText());
		if (top8_chkBox.isSelected())  selectedCheckBoxes.add(top8_chkBox.getText());
		if (top9_chkBox.isSelected())  selectedCheckBoxes.add(top9_chkBox.getText());
		if (top10_chkBox.isSelected())  selectedCheckBoxes.add(top10_chkBox.getText());
		if (top11_chkBox.isSelected())  selectedCheckBoxes.add(top11_chkBox.getText());
		if (top12_chkBox.isSelected())  selectedCheckBoxes.add(top12_chkBox.getText());
		if (top13_chkBox.isSelected())  selectedCheckBoxes.add(top13_chkBox.getText());
		if (top14_chkBox.isSelected())  selectedCheckBoxes.add(top14_chkBox.getText());
		if (top15_chkBox.isSelected())  selectedCheckBoxes.add(top15_chkBox.getText());
		if (top16_chkBox.isSelected())  selectedCheckBoxes.add(top16_chkBox.getText());
	}

	@FXML
	void sizeRadioButtonSelected(ActionEvent event) {
		pizzaSize = (String)SizeGroup.getSelectedToggle().getUserData();
	}
	
	@FXML 
	void placeOrderButtonPressed(ActionEvent event) {
		custName = name_tfd.getText().trim();
		custPhone = phone_tfd.getText().trim();

		try {		// handle integer type error
			pizzaQuantity = Integer.parseInt(quatity_tfd.getText().trim());
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setContentText("Enter numbers only please.");
			alert.show();
		}

		pizzaToppings = selectedCheckBoxes.toArray(new String[selectedCheckBoxes.size()]);
		
		order = new Order();
		order.setCustomer(custName, custPhone);
		order.setOrderDetail(pizzaQuantity, pizzaSize, pizzaType, pizzaToppings);
		
		summary_tarea.setText(order.toString());
	}
	
	@FXML
	void clearButtonPressed(ActionEvent event) {
		// clear text
		name_tfd.clear();
		phone_tfd.clear();
		quatity_tfd.clear();
		summary_tarea.clear();
		// reset size toggle group
		sizeS_rBtn.setSelected(false);
		sizeM_rBtn.setSelected(false);
		sizeL_rBtn.setSelected(false);
		sizeXL_rBtn.setSelected(false);
		// reset type choice box
		type_cBox.setValue("Normal");
		// clear toppings check boxes
		top1_chkBox.setSelected(false);
		top2_chkBox.setSelected(false);
		top3_chkBox.setSelected(false);
		top4_chkBox.setSelected(false);
		top5_chkBox.setSelected(false);
		top6_chkBox.setSelected(false);
		top7_chkBox.setSelected(false);
		top8_chkBox.setSelected(false);
		top9_chkBox.setSelected(false);
		top10_chkBox.setSelected(false);
		top11_chkBox.setSelected(false);
		top12_chkBox.setSelected(false);
		top13_chkBox.setSelected(false);
		top14_chkBox.setSelected(false);
		top15_chkBox.setSelected(false);
		top16_chkBox.setSelected(false);
		selectedCheckBoxes.clear();
	}
	
}
