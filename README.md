Uploading product details in asynchronously with jwt authentication.
Adding sample curls for all the APIs - 
1)Endpoint - /register
``{
    "username":"abc",
    "password":"12345",
    "role":"ROLE_ADMIN"
}``
Response: Newly added user's id will be given
``2``
2)Endpoint- /login
``
{
    "username":"abc",
    "password":"12345"
}
``
Response : The JWT token will be given
``
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJXXXXXX"
}
``
3) Endpoint- /product/upload
Use the jwt token in the Authorization with Auth Type "Bearer Token"
```
[
    {
        "price":"23.56",
        "name":"pencil",
        "company":"LKP",
        "location":"LOC1"
    },
     {
        "price":"7.56",
        "name":"Eraser",
        "company":"LKP",
        "location":"LOC2"
    },
    {
        "price":"37.56",
        "name":"pen",
        "company":"LKP",
        "location":"LOC3"
    }
]

```
Response:-
Will give the ticket id through which you can track the progress later on
``
7dfee8b8-f294-48b9-9a20-46114b26f1f1
``
4)Endpoint- /status/{ticketId} ```[GET]```
Response:-
``COMPLETED``
