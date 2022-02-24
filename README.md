[Angular-Spring Training Project]



![](README-assets/Aspose.Words.3eca31a0-4687-4e79-9ebe-1f57cf0e3c18.001.png)![](README-assets/Aspose.Words.3eca31a0-4687-4e79-9ebe-1f57cf0e3c18.002.png)


1. ## Installation
**IDE:**  [Eclipse 2019-6](https://www.eclipse.org/eclipseide/)  ( please, install Eclipse for Java Enterprise Edition).

![](README-assets/Aspose.Words.3eca31a0-4687-4e79-9ebe-1f57cf0e3c18.003.png)

The following softwares are needed to be installed:

1. **Spring Tools 4 – for spring boot (aka Spring tool suite 4) 4.3.2. Release:**

![](README-assets/Aspose.Words.3eca31a0-4687-4e79-9ebe-1f57cf0e3c18.004.png)



1. ## Introduction
- Project idea is a library management system. This project is divided into the following:
  1. Implementing Angular 8 basic concepts.
  1. Merging with Spring boot (implemented already).
  1. Adding Angular [PrimeNG](https://www.primefaces.org/primeng/) components.
  1. Adding localization (Arabic/English) (RTL/LTR).
- Library has 5 main classes, you can find more details in spring project as:
  Book, Borrow, Librarian, Person, User.
- Please, make sure that your models in spring matches the ones in your angular applications.
- All requirements are considered as minimum requirements, you can add as much as you wish without neglecting the asked ones.

General Rules:

- The system should be divided into modules.
- All (components, modules, services)’s name should be in small letters, if component name is more than one word, please separate it with dash ‘-‘.
- Please, use spring boot for storing your data.
- The system should support Arabic/English languages (RTL/LTR).
- Please, apply pipes for translating service.
- Please, add guards for your pages.

Login/Logout/Registration for User/Librarian should be one page with different modes:
### Login for User/Librarian:
- Login page should be the viewed one for the system until user logged in.
- Login is done using a username and password (mandatory fields).
- The entered username/password should be validated with the saved one in your DB.
- The successful login should be redirected to home page.
- For the un-successful login, user/librarian should be on login page.
- For the un-successful login, a growl message should be shown.
### Logout for User/Librarian:
- A popup message should be viewed and recheck if the person is sure of logging out.
- The successful logout should be redirected to login page.
### ` `Registration for User/Librarian:
- It has to be done using wizard.
- First tab of wizard includes username and password.
- Second tab of wizard includes user/librarian personal information.
- The password should be at least 6 characters/digits include at least 1 capital letter and 1 special character.
- All fields are mandatory and validated.


Add User /Borrow-Request/Book:

- Librarian is the only authorized one to add a new user/Book.
- User is the only authorized one to add a new borrow request.

Update/ Delete User/Librarian/Borrow-Request/Book Tables:

- A page for viewing a table of users, librarian, etc. this table should have a column for updating, one for deleting this record and another column for showing the details under this master table.
- This table also should have a filtration for searching the items.
- A popup message should be viewed and recheck if the person is sure of deleting.

private baseUrl = 'http://localhost:9080/springboot-crud-rest/api/v1/user';

**getUser**(id: number): Observable<any> {

`    `**return** **this**.http.get(`${**this**.baseUrl}/${id}`);

}


![](README-assets/Aspose.Words.3eca31a0-4687-4e79-9ebe-1f57cf0e3c18.005.png)

Example for HTTP Request in angular for spring: 



##
1. ## Spring methods
Please, add functions in your repository that is using queries.

|BookController|BorrowController|
| :- | :- |
|<p>- getAllBooks</p><p>- getBookByNameOrIdOrAuthorname(Long id, String name, String authorName)</p><p>- addBook(Book book)</p><p>- addBooks(List<Book> books)</p><p>- updateBook(Long id)</p><p>- deleteBook(Long id)</p><p></p>|<p>- getAllBorrows</p><p>- getBorrowByIdOrUserIdOrBookId(Long id, Long userId, Long bookId)</p><p>- addBorrow(Borrow borrow)</p><p>- updateBorrow(Long id)</p><p>- deleteBorrow(Long id)</p><p></p>|
|LibrarianController|UserController|
|<p>- getAllLibrarians()</p><p>- getLibrarianByIdOrUsername(Long id, String username)</p><p>- createLibrarian(Librarian librarian)</p><p>- updateLibrarian(Long id)</p><p>- deleteLibrarian(Long id)</p>|<p>- getAllUsers()</p><p>- getUserByIdOrUsername(Long id, String username)</p><p>- createUser(User user)</p><p>- updateUser(Long id)</p><p>- deleteUser(Long id)</p>|

3

