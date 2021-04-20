package domain.entities;

import javafx.scene.control.CheckBox;

public class TableEmployees {
  private String name;
  private String id;
  private String type;
  private CheckBox checkBox;
  public TableEmployees(String name, String id, String type){
    this.name = name;
    this.id = id;
    this.type = type;
    this.checkBox = new CheckBox();
  }

  public String getName(){
    return name;
  }
  public String getId(){
    return id;
  }
  public String getType(){
    return type;
  }
  public CheckBox getSelected(){
    return checkBox;
  }
  public void setSelect(CheckBox select){
    this.checkBox = select;
  }
}
