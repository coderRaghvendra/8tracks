# 8tracks
8tracks demo implementation for swiggy assignment

whole codebase has been divided into four major components/layer : 
1. Controller : which listens request from client and call request layer
to process 
2. Request : which contains core business logic for each request, 
communicates with manager layer mainly and returns the response to the 
client layer
3. Manager : which provides generic methods for whole application,
 communicates with model and DAO layer mostly
4. DAO : which communicates with database, does CRUD operation on database