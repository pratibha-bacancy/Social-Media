# Social-Media
In this project, There are two entities user and post, and respective to that userDto, PostDto, controller, service and repository.
Mapped user and post so now user can see the post, @GetMapping with user url in userController, while running that url and pass the id of user then it will show the post of that user only.
User can see all his posts, create the post, update the post, delete the post, because while mapping user_id column is created in post table, so, it is fetching that row of post table.
As same as there are another entities like, tag and comment, for them service layer, controller and repository are created. Now user can comment on the post, tag on the post and also like the post due to @OneToMany mapping in post entity.

