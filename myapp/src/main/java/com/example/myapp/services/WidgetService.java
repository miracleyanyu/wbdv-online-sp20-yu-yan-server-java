package com.example.myapp.services;

import com.example.myapp.models.Widget;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class WidgetService {

  private List<Widget> widgetList = new ArrayList<Widget>();
  private int order = 0;

  public List<Widget> findAllWidgets() {
    return widgetList;
  }

  public Widget findWidgetById(String wid) {
    for (Widget widget : widgetList) {
      if (widget.getId().equals(wid)) {
        return widget;
      }
    }
    return null;
  }

  public List<Widget> findWidgetsByTopic(String tid) {
    List<Widget> widgets = new ArrayList<>();
    for (Widget widget : widgetList) {
      if (widget.getTopicId().equals(tid)) {
        widgets.add(widget);
      }
    }
    return widgets;
  }

  public Widget createWidget(String tid, Widget widget) {
    widget.setTopicId(tid);
    widget.setOrder(order++);
    widget.setId(UUID.randomUUID().toString());
    widgetList.add(widget);
    widgetList.sort(Comparator.comparingInt(Widget::getOrder));
    return widget;
  }

  public int updateWidget(String wid, Widget newWidget) {
    widgetList.sort(Comparator.comparingInt(Widget::getOrder));
    boolean found = false;
    boolean up = false;
    boolean down = false;
    for (int i = 0; i < widgetList.size(); i++) {
      if (found && !widgetList.get(i).getId().equals(wid) && up) {
        widgetList.get(i).setOrder(widgetList.get(i).getOrder() + 1);
        widgetList.sort(Comparator.comparingInt(Widget::getOrder));
        return 1;
      }
      else if (found && !widgetList.get(i).getId().equals(wid) && down) {
        widgetList.get(i).setOrder(widgetList.get(i).getOrder() - 1);
        widgetList.sort(Comparator.comparingInt(Widget::getOrder));
        return 1;
      }
      if (widgetList.get(i).getId().equals(wid)) {
        if (widgetList.get(i).getOrder() > newWidget.getOrder()) {
          up = true;
        }
        else if (widgetList.get(i).getOrder() < newWidget.getOrder()){
          down = true;
        }
        widgetList.set(i, newWidget);
        if (up) {
          i = i - 2;
        }
        found = true;
      }
    }
    if (found) {
      widgetList.sort(Comparator.comparingInt(Widget::getOrder));
      return 1;
    }
    widgetList.sort(Comparator.comparingInt(Widget::getOrder));
    return 0;
  }

  public int deleteWidget(String wid) {
    boolean found = false;
    widgetList.sort(Comparator.comparingInt(Widget::getOrder));
    for(int i = 0; i < widgetList.size(); i++) {
      if (found) {
        widgetList.get(i).setOrder(widgetList.get(i).getOrder() - 1);
      }
      else if (widgetList.get(i).getId().equals(wid)) {
        widgetList.remove(i);
        i--;
        found = true;
      }
    }
    order--;
    if (!found) {
      return 0;
    }
    return 1;
  }

}
