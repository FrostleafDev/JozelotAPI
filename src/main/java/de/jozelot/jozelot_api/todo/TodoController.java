package de.jozelot.jozelot_api.todo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    private List<Todo> todos = new ArrayList<>();
    private Long idCounter = 0L;

    @GetMapping
    public List<Todo> getTodos() {
        return todos;
    }

    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable Long id) {
        for (Todo t : todos) {
            if (t.getId().equals(id)) return t;
        }
        return null;
    }

    @PostMapping
    public Todo addTodo(@RequestBody Todo todo) {
        todo.setId(idCounter);
        idCounter++;
        todos.add(todo);
        System.out.println("Todo hinzugefügt");
        return todo;
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todos.removeIf(todo -> todo.getId().equals(id));
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        for (Todo t : todos) {
            if (t.getId().equals(id)) {
                t.setTask(todo.getTask());
                t.setDone(todo.isDone());
                return t;
            }
        }
        return null;
    }
}
