package com.example.myapp.services;

import com.example.myapp.models.Topic;
import com.example.myapp.models.Widget;
import com.example.myapp.repositories.TopicRepository;
import com.example.myapp.repositories.WidgetRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

  @Autowired
  WidgetRepository widgetRepository;

  @Autowired
  TopicRepository topicRepository;

  @Autowired
  WidgetService widgetService;

  private int total = 0;
  private int order = 0;

  public List<Topic> findAllTopics() {
    return (List<Topic>)topicRepository.findAll();
  }

  public Topic findTopicById(Integer tid) {
    return topicRepository.findTopicById(tid);
  }

  public int updateTopic(Integer tid, Topic newTopic) {
    boolean found = false;
    List<Topic> list = topicRepository.findAllTopics();
    for (Topic curTopic : list) {
      if (curTopic.getId().equals(tid)) {
        curTopic.setTitle(newTopic.getTitle());
        topicRepository.save(curTopic);
        found = true;
      }
    }
    if (found) {
      return 1;
    }
    return 0;
  }

  public Topic createTopic(String lid, Topic newTopic) {
    newTopic.setLessonId(lid);
    total++;
    return topicRepository.save(newTopic);
  }

  public Widget createWidgetForTopic(
      Integer tid,
      Widget newWidget) {
    Topic topic = topicRepository.findById(tid).get();
    widgetService.createWidget();
    newWidget.setWidgetOrder(order++);
    newWidget.setTopic(topic);
    newWidget.setTopicId(topic.getId());
    return widgetRepository.save(newWidget);
  }

  public List<Topic> findTopicsForLesson(String lessonId) {
    return topicRepository.findTopicsForLesson(lessonId);
  }

  public int deleteTopic(Integer tid) {
    boolean found = false;
    for(int i = 0; i < total; i++) {
      Topic curTopic = topicRepository.findAllTopics().get(i);
      if (curTopic.getId().equals(tid)) {
        topicRepository.deleteById(curTopic.getId());
        i--;
        found = true;
      }
    }
    if (!found) {
      return 0;
    }
    total--;
    return 1;
  }

  public int deleteWidget(Integer wid) {
    System.out.println(wid);
    boolean found = false;
    List<Widget> list = widgetRepository.findAllWidgets();
    int totalWidget = list.size();
    for(int i = 0; i < totalWidget; i++) {
      Widget curWidget = list.get(i);
      if (found) {
        curWidget.setWidgetOrder(curWidget.getWidgetOrder() - 1);
        widgetRepository.save(curWidget);
      }
      else if (curWidget.getId().equals(wid)) {
        widgetRepository.deleteById(curWidget.getId());
        found = true;
      }
    }
    order--;
    if (!found) {
      return 0;
    }
    widgetService.deleteWidget(wid);
    return 1;
  }
}
