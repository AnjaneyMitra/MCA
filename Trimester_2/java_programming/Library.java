import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private int bookID;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "BookID: " + bookID + ", Title: " + title + ", Author: " + author + ", Available: " + isAvailable;
    }
}

class Member {
    private int memberID;
    private String name;
    private List<Book> borrowedBooks;

    public Member(int memberID, String name) {
        this.memberID = memberID;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getMemberID() {
        return memberID;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "MemberID: " + memberID + ", Name: " + name + ", Borrowed Books: " + borrowedBooks.size();
    }
}

class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(int bookID, String title, String author) {
        Book newBook = new Book(bookID, title, author);
        books.add(newBook);
        System.out.println("Book added: " + newBook);
    }

    public void registerMember(int memberID, String name) {
        Member newMember = new Member(memberID, name);
        members.add(newMember);
        System.out.println("Member registered: " + newMember);
    }

    public void borrowBook(int memberID, int bookID) {
        Book book = findBookByID(bookID);
        Member member = findMemberByID(memberID);

        if (book != null && member != null && book.isAvailable()) {
            member.borrowBook(book);
            book.setAvailable(false);
            System.out.println(member.getName() + " borrowed the book: " + book.getTitle());
        } else {
            System.out.println("Book is not available or invalid member.");
        }
    }

    public void returnBook(int memberID, int bookID) {
        Book book = findBookByID(bookID);
        Member member = findMemberByID(memberID);

        if (book != null && member != null && member.getBorrowedBooks().contains(book)) {
            member.returnBook(book);
            book.setAvailable(true);
            System.out.println(member.getName() + " returned the book: " + book.getTitle());
        } else {
            System.out.println("Invalid return request.");
        }
    }

    public void listAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }

    public void listBorrowedBooks(int memberID) {
        Member member = findMemberByID(memberID);
        if (member != null) {
            System.out.println("Books borrowed by " + member.getName() + ":");
            for (Book book : member.getBorrowedBooks()) {
                System.out.println(book);
            }
        } else {
            System.out.println("Member not found.");
        }
    }

    private Book findBookByID(int bookID) {
        for (Book book : books) {
            if (book.getBookID() == bookID) {
                return book;
            }
        }
        return null;
    }

    private Member findMemberByID(int memberID) {
        for (Member member : members) {
            if (member.getMemberID() == memberID) {
                return member;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Add a new book");
            System.out.println("2. Register a new member");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. List available books");
            System.out.println("6. List books borrowed by a member");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter book ID: ");
                    int bookID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    library.addBook(bookID, title, author);
                    break;
                case 2:
                    System.out.print("Enter member ID: ");
                    int memberID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter member name: ");
                    String name = scanner.nextLine();
                    library.registerMember(memberID, name);
                    break;
                case 3:
                    System.out.print("Enter member ID: ");
                    memberID = scanner.nextInt();
                    System.out.print("Enter book ID: ");
                    bookID = scanner.nextInt();
                    library.borrowBook(memberID, bookID);
                    break;
                case 4:
                    System.out.print("Enter member ID: ");
                    memberID = scanner.nextInt();
                    System.out.print("Enter book ID: ");
                    bookID = scanner.nextInt();
                    library.returnBook(memberID, bookID);
                    break;
                case 5:
                    library.listAvailableBooks();
                    break;
                case 6:
                    System.out.print("Enter member ID: ");
                    memberID = scanner.nextInt();
                    library.listBorrowedBooks(memberID);
                    break;
                case 7:
                    exit = true;
                    System.out.println("Exiting system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
