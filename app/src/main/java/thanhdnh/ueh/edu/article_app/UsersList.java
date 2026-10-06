package thanhdnh.ueh.edu.article_app;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UsersList {

  @SerializedName("users")
  @Expose
  private ArrayList<Users> users;

  public UsersList(ArrayList<Users> users) {
    this.setUsers(users);
  }

  public ArrayList<Users> getUsers() {
    return users;
  }

  public void setUsers(ArrayList<Users> users) {
    this.users = users;
  }
}
