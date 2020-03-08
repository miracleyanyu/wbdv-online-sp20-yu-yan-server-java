package com.example.myapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
@Table(name="widgets")
public class Widget {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JsonIgnore
  private Topic topic;

  private String name;
  private String type;
  private String text;
  private String src;
  private String cssClass;
  private String style;
  private String value;
  private Integer widgetOrder;
  private Integer size;
  private Integer width;
  private Integer height;

  public Widget() {
  }

  public Widget(Topic topic, String name, String type, String text, String src,
      String cssClass, String style, String value, Integer widgetOrder, Integer size,
      Integer width, Integer height) {
    this.topic = topic;
    this.name = name;
    this.type = type;
    this.text = text;
    this.src = src;
    this.cssClass = cssClass;
    this.style = style;
    this.value = value;
    this.widgetOrder = widgetOrder;
    this.size = size;
    this.width = width;
    this.height = height;
  }

  public Widget(Topic topic) {
    this.topic = topic;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }

  public String getCssClass() {
    return cssClass;
  }

  public void setCssClass(String cssClass) {
    this.cssClass = cssClass;
  }

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Integer getWidgetOrder() {
    return widgetOrder;
  }

  public void setWidgetOrder(Integer widgetOrder) {
    this.widgetOrder = widgetOrder;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public Topic getTopic() {
    return topic;
  }

  public void setTopic(Topic topic) {
    this.topic = topic;
  }
}