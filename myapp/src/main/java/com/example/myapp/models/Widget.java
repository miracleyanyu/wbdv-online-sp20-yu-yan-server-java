package com.example.myapp.models;

public class Widget {
  private String id;
  private String topicId;
  private String name;
  private String type;
  private String text;
  private String src;
  private String cssClass;
  private String style;
  private String value;
  private Integer order;
  private Integer size;
  private Integer width;
  private Integer height;

  public Widget() {
  }

  public Widget(String id, String topicId, String name, String type, String text, String src,
      String cssClass, String style, String value, Integer order, Integer size,
      Integer width, Integer height) {
    this.id = id;
    this.topicId = topicId;
    this.name = name;
    this.type = type;
    this.text = text;
    this.src = src;
    this.cssClass = cssClass;
    this.style = style;
    this.value = value;
    this.order = order;
    this.size = size;
    this.width = width;
    this.height = height;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
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

  public Integer getOrder() {
    return order;
  }

  public void setOrder(Integer order) {
    this.order = order;
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

  public String getTopicId() {
    return topicId;
  }

  public void setTopicId(String topicId) {
    this.topicId = topicId;
  }
}