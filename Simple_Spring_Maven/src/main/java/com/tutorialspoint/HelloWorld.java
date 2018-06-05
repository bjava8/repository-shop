/**
 * Java Based Configuration
 * https://www.tutorialspoint.com/spring/spring_java_based_configuration.htm
 */
package com.tutorialspoint;

public class HelloWorld {
   private String message;

   public void setMessage(String message){
      this.message  = message;
   }
   public void getMessage(){
      System.out.println("Your Message : " + message);
   }
}