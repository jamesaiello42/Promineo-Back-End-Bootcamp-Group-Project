# Social Media Menu Application
Contributors: 
* [James Aiello](https://github.com/jamesaiello42)
* [Wendy Sun](https://github.com/wensun163)

## Some Background Information
* Program displays menu options for the entities Users, Posts, Comments, and Likes.
* These options allow for the following:
	* Create
	* Read
	* Update
	* Delete

## Getting Started
The following sub-sections will provide you details on how get the project set up.

## Setting up the Repository Locally
Type into you git client this command: git clone https://github.com/jamesaiello42/Promineo-Back-End-Bootcamp-Group-Project.git

### Creating the Database
* Once the files are on your computer, you will need to have MySQL installed on your computer.
* You will need to run the Create_DB.sql in you MySQL Workbench to get the database set up. 
	* File is located in the DB Create Script and ERD sub-directory.

### Setting up the Eclipse Project
* You will need to import the project's workspace into Eclipse.
* You will need to import the external MySQL Java Connector into your Eclipse project.
* Open the Application.java and run the program.

### Updates for Contribution by Wendy Sun
* Below are Wendy's contributions to those files:
*  Likes.java:  added setters and update field section and comments in the file.
* Comments.java: uploaded the Comments.java and have updated version of the file including adding default constructor, setters, and comments etc. 
* LikesDao.java: Wendy's contribution includes the following: GET_POSTS_COMMENTS_BY_USER_ID_QUERY, getPostLikesByPostLikeId method, getPostLikesByCommentLikeId method, createNewPostLike method, etc.
* Menu.java: I added more options out of 12 options in the file. These added options are: case “2”, case “4”, case”6”, case”8”. The contributor of case”4” is not labeled correctly. I also added some methods in the file, such as displayPostsByUser, updatePostByID, etc.
* In order to merge Wendy's version and Jame's version together, Wendy also make changes in files in entity and dao packages.
