package com.example.myapp.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "topics")
public class Topic {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String title;
  private String description;
  private String lessonId;

  @OneToMany(mappedBy = "topic")
  private List<Widget> widgets;

  public Topic() {
  }

  public Topic(String title, String description, String lessonId,
      List<Widget> widgets) {
    this.title = title;
    this.description = description;
    this.lessonId = lessonId;
    this.widgets = widgets;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getLessonId() {
    return lessonId;
  }

  public void setLessonId(String lessonId) {
    this.lessonId = lessonId;
  }

  public List<Widget> getWidgets() {
    return widgets;
  }

  public void setWidgets(List<Widget> widgets) {
    this.widgets = widgets;
  }
}
