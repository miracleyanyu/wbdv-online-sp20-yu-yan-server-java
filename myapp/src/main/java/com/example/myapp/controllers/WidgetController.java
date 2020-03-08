package com.example.myapp.controllers;

import com.example.myapp.models.Topic;
import com.example.myapp.models.Widget;
import com.example.myapp.services.TopicService;
import com.example.myapp.services.WidgetService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {

  @Autowired
  WidgetService widgetService;

  @Autowired
  TopicService topicService;

  @PostMapping("/api/topics/{tid}/widgets")
  public Widget createWidget(@PathVariable("tid") Integer tid, @RequestBody Widget widget) {
    return topicService.createWidgetForTopic(tid, widget);
  }

  @DeleteMapping("/api/widgets/{widgetId}")
  public int deleteWidget(@PathVariable("widgetId") Integer wid) {
    return topicService.deleteWidget(wid);
  }

  @PutMapping("/api/widgets/{wid}")
  public int updateWidget(@PathVariable("wid") Integer wid, @RequestBody Widget widget) {
    return widgetService.updateWidget(wid, widget);
  }

  @GetMapping("/api/widgets")
  public List<Widget> findAllWidgets() {
    return widgetService.findAllWidgets();
  }

  @GetMapping("/api/widgets/{wid}")
  public Widget findWidgetById(@PathVariable("wid") Integer wid) {
    return widgetService.findWidgetById(wid);
  }

  @GetMapping("/api/topics/{tid}/widgets")
  public List<Widget> findWidgetsForTopic(@PathVariable("tid") Integer tid) {
    return widgetService.findWidgetsForTopic(tid);
  }
}
