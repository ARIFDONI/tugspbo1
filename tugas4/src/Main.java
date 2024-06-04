// package com.main
package com.main;

import books.*;
import data.*;
import util.*;

public class LibrarySystem {
    // Your code here
}

// package books
package books;

public class Book {
    // Your code here
}

public class HistoryBook extends Book {
    // Your code here
}

public class StoryBook extends Book {
    // Your code here
}

public class TextBook extends Book {
    // Your code here
}

// package data
package data;

import util.iMenu;

public class Admin implements iMenu {
    @Override
    public void menu() {
        // Your code here
    }
    // Your code here
}

public class Student implements iMenu {
    @Override
    public void menu() {
        // Your code here
    }

    public void choiceBook() {
        // Your code here
    }
    // Your code here
}

public class User {
    // Your code here
}

// package util
package util;

public interface iMenu {
    void menu();
}