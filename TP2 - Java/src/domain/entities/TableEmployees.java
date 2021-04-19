package domain.entities;

public class TableEmployees {
  private String name;
  private String id;
  private String type;

  public TableEmployees(String name, String id, String type){
    this.name = name;
    this.id = id;
    this.type = type;
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
}
