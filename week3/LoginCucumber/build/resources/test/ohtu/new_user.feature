Feature: A new user account can be created if a proper unused username and password are given

    Scenario: creation is successful with valid username and password
      Given command new is selected
      When  username "taneli" and password "talokasa123" are entered
      Then  system will respond with "new user registered"

    Scenario: creation fails with already taken username and valid password
      Given command new is selected
      When  username "pekka" and password "talokasa123" are entered
      Then  system will respond with "new user not registered"
      
    Scenario: creation fails with too short username and valid password
      Given command new is selected
      When  username "ta" and password "talokasa123" are entered
      Then  system will respond with "new user not registered"
      
    Scenario: creation fails with valid username and too short password
      Given command new is selected
      When  username "taneli" and password "t2o" are entered
      Then  system will respond with "new user not registered"
      
    Scenario: creation fails with valid username and password long enough but consisting of only letters
      Given command new is selected
      When  username "taneli" and password "talokasa" are entered
      Then  system will respond with "new user not registered"