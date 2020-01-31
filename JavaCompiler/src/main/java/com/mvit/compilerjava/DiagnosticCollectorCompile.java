/* 
 * funciona con jdk
 */

package com.mvit.compilerjava;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class DiagnosticCollectorCompile {

  public static void main(String args[]) throws IOException {
    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
    DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
    StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);
    Iterable<? extends JavaFileObject> compilationUnits = fileManager
        .getJavaFileObjectsFromStrings(Arrays.asList("C:/lenguaje/pruebas_java/JavaCompiler/src/main/java/com/mvit/compilerjava/Test.java"));
    JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics, null,
        null, compilationUnits);
    boolean success = task.call();
    fileManager.close();
    System.out.println("Success: " +  new Date() +" " + success);
  }
}