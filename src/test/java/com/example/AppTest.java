package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.mockito.*;
import dao.UserDAO;
import models.User;
import controllers.UserController;
import java.util.List;

public class AppTest {

    @Mock
    private UserDAO userDAO;  // Mock the UserDAO

    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);  // Initialize mocks
        userController = new UserController();  // Create an instance of UserController
    }

    
}
