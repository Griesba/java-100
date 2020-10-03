package com.sdz.processors;

import com.sdz.annotation.Todo;
import com.sdz.annotation.Todos;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//Permet de spécifier les annotations à traiter
@SupportedAnnotationTypes(value = { "com.sdz.annotation.Todo", "com.sdz.annotation.Todos" })
//Défini quelle version de source gérer, ici je code en Java 7
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class TodoEtTodos extends AbstractProcessor {

    List<Todo> todoList;

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        todoList = new ArrayList<>();

        for (TypeElement typeElement : annotations) {
            for (Element element: roundEnv.getElementsAnnotatedWith(typeElement)) {
                String name = element.getClass().toString();

                Todos todos = element.getAnnotation(Todos.class);

                if (todos != null){
                    for (Todo todo: todos.todos()) {
                        if (todo != null) {
                            todoList.add(todo);
                        }
                    }
                }
            }
        }

        FileOutputStream fw = null;
        TodoHTMLProcessor.genererHTML(todoList, fw);

        return true;
    }
}
