package com.example.studentsystem.model;

import java.util.Arrays;
import java.util.Objects;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Manager {

   public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   private String name;

   @JsonIgnore
   private String password;

   private String[] roles;

   public void setPassword(String password) {
      this.password = PASSWORD_ENCODER.encode(password);
   }

   protected Manager() {
   }

   public Manager(String name, String password, String... roles) {

      this.name = name;
      this.setPassword(password);
      this.roles = roles;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      Manager manager = (Manager) o;
      return Objects.equals(id, manager.id) &&
            Objects.equals(name, manager.name) &&
            Objects.equals(password, manager.password) &&
            Arrays.equals(roles, manager.roles);
   }

   @Override
   public int hashCode() {

      int result = Objects.hash(id, name, password);
      result = 31 * result + Arrays.hashCode(roles);
      return result;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getPassword() {
      return password;
   }

   public String[] getRoles() {
      return roles;
   }

   public void setRoles(String[] roles) {
      this.roles = roles;
   }

   @Override
   public String toString() {
      return "Manager{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", roles=" + Arrays.toString(roles) +
            '}';
   }
}