package com.example.myapp.repositories;

import com.example.myapp.models.Widget;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface WidgetRepository extends CrudRepository<Widget, Integer> {

  @Query(value = "SELECT * FROM widgets WHERE id=:widgetId", nativeQuery = true)
  public Widget findWidgetById(
      @Param("widgetId") Integer wid
  );

  @Query(value = "SELECT * FROM widgets ORDER BY widget_order", nativeQuery = true)
  public List<Widget> findAllWidgets();

  @Query(value = "SELECT * FROM widgets WHERE topic_id=:topicId", nativeQuery = true)
  public List<Widget> findWidgetsForTopic(
      @Param("topicId") Integer topicId
  );
}
