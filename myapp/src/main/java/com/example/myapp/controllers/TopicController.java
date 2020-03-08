package com.example.myapp.controllers;

import com.example.myapp.models.Topic;
import com.example.myapp.services.TopicService;
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
public class TopicController {

  @Autowired
  TopicService topicService;

  @PostMapping("/api/lessons/{lid}/topics")
  public Topic createTopic(@PathVariable("lid") String lid, @RequestBody Topic newTopic
  ) {
    return topicService.createTopic(lid, newTopic);
  }

  @GetMapping("/api/lessons/{lid}/topics")
 public List<Topic> findTopicsForLesson(@PathVariable("lid") String lid) {
    return topicService.findTopicsForLesson(lid);
 }

 @PutMapping("api/topics/{tid}")
  public int updateTopic(@PathVariable("tid") Integer tid, @RequestBody Topic topic) {
    return topicService.updateTopic(tid, topic);
 }

  @DeleteMapping("/api/topics/{tid}")
  public int deleteTopic(@PathVariable("tid") Integer tid) {
    return topicService.deleteTopic(tid);
  }

  @GetMapping("/api/topics")
  public List<Topic> findAllTopics() {
    return topicService.findAllTopics();
  }

  @GetMapping("/api/topics/{tid}")
  public Topic findTopicById(@PathVariable("tid") Integer tid) {
    return topicService.findTopicById(tid);
  }
}
