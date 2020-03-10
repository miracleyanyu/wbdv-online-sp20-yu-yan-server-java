package com.example.myapp.services;

import com.example.myapp.models.Topic;
import com.example.myapp.models.Widget;
import com.example.myapp.repositories.TopicRepository;
import com.example.myapp.repositories.WidgetRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WidgetService {

  @Autowired
  WidgetRepository widgetRepository;

  @Autowired
  TopicRepository topicRepository;

  private int total = 0;

  public List<Widget> findAllWidgets() {
    return widgetRepository.findAllWidgets();
  }

  public Widget findWidgetById(Integer wid) {
    return widgetRepository.findWidgetById(wid);
  }

  public List<Widget> findWidgetsForTopic(Integer tid) {
    return widgetRepository.findWidgetsForTopic(tid);
  }

  void createWidget() {
    total++;
  }

  public int updateWidget(Integer wid, Widget newWidget) {
    boolean found = false;
    boolean up = false;
    boolean down = false;
    List<Widget> list = widgetRepository.findAllWidgets();
    int totalWidget = list.size();
    for (int i = 0; i < totalWidget; i++) {
      Widget curWidget = list.get(i);
      if (found && !curWidget.getId().equals(wid) && up) {
        curWidget.setWidgetOrder(curWidget.getWidgetOrder() + 1);
        widgetRepository.save(curWidget);
        return 1;
      }
      else if (found && !curWidget.getId().equals(wid) && down) {
        curWidget.setWidgetOrder(curWidget.getWidgetOrder() - 1);
        widgetRepository.save(curWidget);
        return 1;
      }
      if (curWidget.getId().equals(wid)) {
        if (curWidget.getWidgetOrder() > newWidget.getWidgetOrder()) {
          up = true;
        }
        else if (curWidget.getWidgetOrder() < newWidget.getWidgetOrder()){
          down = true;
        }
        if (!(i == 0 && up || i == totalWidget - 1 && down)) {
          curWidget.setWidgetOrder(newWidget.getWidgetOrder());
        }
        curWidget.setTopic(newWidget.getTopic());
        curWidget.setCssClass(newWidget.getCssClass());
        curWidget.setHeight(newWidget.getHeight());
        curWidget.setName(newWidget.getName());
        curWidget.setSize(newWidget.getSize());
        curWidget.setSrc(newWidget.getSrc());
        curWidget.setStyle(newWidget.getStyle());
        curWidget.setText(newWidget.getText());
        curWidget.setType(newWidget.getType());
        curWidget.setTopicId(newWidget.getTopicId());
        curWidget.setTopic(topicRepository.findTopicById(newWidget.getTopicId()));
        widgetRepository.save(curWidget);
        if (up) {
          i = i - 2;
        }
        found = true;
      }
    }
    if (found) {
      return 1;
    }
    return 0;
  }

  public int deleteWidget(Integer wid) {
    total--;
    return 1;
  }

}
