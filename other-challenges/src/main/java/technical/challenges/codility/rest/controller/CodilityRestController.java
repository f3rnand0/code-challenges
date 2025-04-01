package technical.challenges.codility.rest.controller;

import com.google.common.collect.Lists;
import java.util.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodilityRestController {
  private final TaskRepository repository;

  @Autowired
  public CodilityRestController(TaskRepository repository) {
    this.repository = repository;
  }

  @PostMapping("/tasks")
  public ResponseEntity<Long> readTask(@RequestBody TaskDto taskDto) {
    Task task = new Task(taskDto.getTitle());
    task.setDescription(taskDto.getDescription());
    Task newTask = repository.save(task);
    return new ResponseEntity<>(newTask.getId(), HttpStatus.OK);
  }

  @GetMapping("/tasks/{id}")
  public ResponseEntity<TaskDto> readTask(@PathVariable Long id) {
    Optional<Task> task = repository.findById(id);
    if (task.isPresent()) {
      return new ResponseEntity<>(task.get().toDto(), HttpStatus.OK);
    } else {
      Task emptyTask = new Task("");
      return new ResponseEntity<>(emptyTask.toDto(), HttpStatus.NO_CONTENT);
    }
  }

  @PutMapping("/tasks/{id}")
  public ResponseEntity<String> updateTask(@PathVariable Long id, @RequestBody TaskDto taskDto) {
    Optional<Task> task = repository.findById(id);
    if (task.isPresent()) {
      Task taskToUpdate = task.get();
      if (checkTaskStatus(taskDto.getStatus())) {
        if (StringUtils.isNotEmpty((taskDto.getTitle()))) {
          taskToUpdate.setTitle(taskDto.getTitle());
        }
        if (StringUtils.isNotEmpty((taskDto.getDescription()))) {
          taskToUpdate.setDescription(taskDto.getDescription());
        }
        taskToUpdate.setTaskStatus(TaskStatus.valueOf(taskDto.getStatus()));
        repository.save(taskToUpdate);
        return new ResponseEntity<>("", HttpStatus.OK);
      } else {
        return new ResponseEntity<>(
            "Available statuses are: CREATED, APPROVED, REJECTED, BLOCKED, DONE.",
            HttpStatus.BAD_REQUEST);
      }
    } else {
      return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
    }
  }

  @DeleteMapping("/tasks/{id}")
  public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
    Optional<Task> task = repository.findById(id);
    if (task.isPresent()) {
      repository.delete(task.get());
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  }

  @GetMapping("/tasks")
  public ResponseEntity<List<TaskDto>> readAllTasks() {
    List<Task> tasks = Lists.newArrayList(repository.findAll());
    List<TaskDto> taskDtos = new ArrayList<>();
    for (Task task : tasks) {
      taskDtos.add(task.toDto());
    }
    return new ResponseEntity<>(taskDtos, HttpStatus.OK);
  }

  private boolean checkTaskStatus(String name) {
    for (TaskStatus status : TaskStatus.values()) {
      if (status.name().equalsIgnoreCase(name)) {
        return true;
      }
    }
    return false;
  }
}
