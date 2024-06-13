# Lab 3.1 Notes

### The “UserController” class gets an instance of “userRepository” through its constructor; how is this new repository instantiated?

The UserRepository instance is instantiated through the @Autowired annotation. When used as a Spring Bean, the constructor is autowired.

###  List the methods invoked in the “userRepository” object by the “UserController”. Where are these methods defined?
* findAll() - returns all entities
* findById() - returns a certain entity specified by id
* save() - saves an entity
* delete() - deletes an entity

The UserRepository is an extension of the class CrudRepository, which means that it will inherit it's methods and constructors. Thus, the methods above come from it's super class.

###  Where is the data being saved?
The data is being saved inside the UserRepository object.

### Where is the rule for the “not empty” email address defined?
It's defined in the User.java class file:
```
@NotBlank(message = "Email is mandatory")
private String email;