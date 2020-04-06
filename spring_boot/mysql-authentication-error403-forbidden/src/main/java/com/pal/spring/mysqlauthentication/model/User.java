package com.pal.spring.mysqlauthentication.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="user_id")
		private int id;
		
		@Column(name="email")
		private String email;
		
		@Column(name="password")
		private String pass;
		
		@Column(name="name")
		private String name;
		
		@Column(name="last_name")
		private String lname;
		
		@Column(name="active")
		private int active;
		
		@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
		@JoinTable(name="user_role",joinColumns=@JoinColumn(name="user_id"))
		private Set<Role> roles;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPass() {
			return pass;
		}

		public void setPass(String pass) {
			this.pass = pass;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLname() {
			return lname;
		}

		public void setLname(String lname) {
			this.lname = lname;
		}

		public int getActive() {
			return active;
		}

		public void setActive(int active) {
			this.active = active;
		}

		public Set<Role> getRoles() {
			return roles;
		}

		public void setRoles(Set<Role> roles) {
			this.roles = roles;
		}

		public User() {
			
		}
		
//		public User(int id, String email, String pass, String name, String lname, int active, Set<Role> roles) {
////			super();
//			this.id = id;
//			this.email = email;
//			this.pass = pass;
//			this.name = name;
//			this.lname = lname;
//			this.active = active;
//			this.roles = roles;
//		}

		public User(User user) {
			this.active=user.getActive();
			this.email=user.getEmail();
			this.roles=user.getRoles();
			this.name=user.getName();
			this.lname=user.getLname();
			this.id=user.getId();
			this.pass=user.getPass();
			
		}
	
		
	
}
