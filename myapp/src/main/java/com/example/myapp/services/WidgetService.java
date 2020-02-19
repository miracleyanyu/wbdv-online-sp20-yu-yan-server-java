package com.example.myapp.services;

import com.example.myapp.models.Widget;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class WidgetService {

  private List<Widget> widgetList = new ArrayList<Widget>();

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
    widget.setId(UUID.randomUUID().toString());
    widgetList.add(widget);
    return widget;
  }

  public int updateWidget(String wid, Widget newWidget) {
    for (int i = 0; i < widgetList.size(); i++) {
      if (widgetList.get(i).getId().equals(wid)) {
        widgetList.set(i, newWidget);
        return 1;
      }
    }
    return 0;
  }

  public int deleteWidget(String wid) {
    boolean found = false;
    for(Widget widget : widgetList) {
      if (widget.getId().equals(wid)) {
        widgetList.remove(widget);
        found = true;
      }
    }
    if (!found) {
      return 0;
    }
    return 1;
  }

}
