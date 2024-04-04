package myDiaries;

import java.time.LocalDateTime;

public class Entry {
    private int id;
    private String title;
    private String body;
    private LocalDateTime dateCreated;
    public Entry(int id, String title, String body){
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void editTitle(String newTitle) {
        title = newTitle;
    }

    public void editBody(String newBody) {
        body = newBody;
    }
    //public String toString(){
      //  return String.format("id: %d%nTitle: %s%nBody: %s%n", id, title, body);
    //}
}
