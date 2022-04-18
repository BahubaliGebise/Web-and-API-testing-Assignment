Feature:  User is able to open the bank account at ABN-AMRO via online portal.

  @UI
  Scenario Outline: HappyPath - As a retail user, I would like to open bank account( non-us born, tax paying, Dutch citizen with citizenship (BSN) number 999999990, living in Gustav Mahlerlaan 10,
  1082 PP Amsterdam. and need to create a private bank account for yourself)

    Given User is able to launch URL of bank application and the application type is "Web"
    And User choose PRIVATE as a bank products for SELF use
    When User enters valid address to receive debit card
      | 1082 PP | 10 |

    And User navigates to personal details page

    Then User enters name, surname and date of birth on Your_Details page
      |Mr|B |Johan| Britto | 01-02-1986 |

    And User enters required details under tax fields with nationality
      | 999999990 |

    And User navigates to Identifying page successfully

    And User enters form of identification and contact details
      | johan@gmail.com |+31617840000 |

    And user enters details of "<Income_Received>", company "<OwnerOrDirector>" , willing to transfer "<Above500k>" and bank ever "<Refused>" details


    And User verifies all input data on Overview screen
      | 01-02-1986 | +31617840000 | johan@gmail.com |

    Then User is able to create new account successfully
    And close the application
    Examples:
      |Income_Received|OwnerOrDirector|Above500k|Refused|
      |Not Applicable |NO             |NO       |NO    |



  @UI
  Scenario Outline: As a retail user, I enter invalid postal address details and I am unable to open account

    Given User is able to launch URL of bank application and the application type is "Web"
    And User choose PRIVATE as a bank products for SELF use
    When User enters invalid "<Postalcode>" and house "<House_Number>" number
    Then User verify error message for wrong address
    And close the application
    Examples:
      |Postalcode|House_Number|
      | 1218 GX  |   00       |



  @UI
  Scenario Outline: User able to navigate to previous page(Back Button functionality) and continues E2E flow.

    Given User is able to launch URL of bank application and the application type is "Web"
    And User choose PRIVATE as a bank products for SELF use
    When User enters valid address to receive debit card
      | 1218 GX | 54 |

    And User navigates to personal details page

    And User enters name, surname and date of birth on Your_Details page
      |Mr|B |Johan| Britto | 01-02-1986 |

    Then User navigate back to bank account page to update the current postal code

    And User navigates to personal details page

    And User enters required details under tax fields with nationality
      | 999999990 |

    And User navigates to Identifying page successfully

    And User enters form of identification and contact details
      | johan@gmail.com |+31617840000 |

    And user enters details of "<Income_Received>", company "<OwnerOrDirector>" , willing to transfer "<Above500k>" and bank ever "<Refused>" details


    And User verifies all input data on Overview screen
      | 01-02-1986 | +31617840000 | johan@gmail.com |

    And User is able to create new account successfully
    And close the application
    Examples:
      |Income_Received|OwnerOrDirector|Above500k|Refused|
      |Not Applicable |     NO        |   NO    | NO    |



  @UI
  Scenario: Business Account, verifies business bank account link text from UI

    Given User is able to launch URL of bank application and the application type is "Web"
    And User choose Business as a bank products
      |If you would like to open a business account, you can do so easily online.|
    Then close the application


  @UI
  Scenario: ToolTip functionality on Your_Details page

    Given User is able to launch URL of bank application and the application type is "Web"
    And User choose PRIVATE as a bank products for SELF use
    When User enters valid address to receive debit card
      | 1082 PP | 10 |

    And User navigates to personal details page

    And User enters name, surname and date of birth on Your_Details page
      |Mr|B |Johan| Britto | 01-02-1986 |

    Then User clicks tooltip and verifies text message
    And close the application



  @UI
  Scenario: As a retail user, I enter invalid Email address and I am unable to open account

    Given User is able to launch URL of bank application and the application type is "Web"
    And User choose PRIVATE as a bank products for SELF use
    When User enters valid address to receive debit card
      | 1082 PP | 10 |

    And User navigates to personal details page

    And User enters name, surname and date of birth on Your_Details page
      |Mr|C | Coral | Simods | 01-02-1986 |

    And User enters required details under tax fields with nationality
      | 999999990 |

    And User navigates to Identifying page successfully

    And User enters form of identification and contact details
      | corol123@gmail.com11 |+31617840000|

    Then User verifies error message for wrong email ID
      |The email address seems to be invalid. Please check that it has been entered correctly.|
    And close the application

  @UI
  Scenario: Validate telephone number and at Mandatory field NO blank value is allowed

    Given User is able to launch URL of bank application and the application type is "Web"
    And User choose PRIVATE as a bank products for SELF use
    When User enters valid address to receive debit card
      | 1082 PP | 10 |

    And User navigates to personal details page

    And User enters name, surname and date of birth on Your_Details page
      |Ms|s |Vanessa| Sterry | 01-02-1986 |

    And User enters required details under tax fields with nationality
      | 999999990 |

    And User navigates to Identifying page successfully

    And User enters form of identification and contact details
      | johan@gmail.com |2617840000999|

    Then User verifies error message for wrong Telephone number
      |Fill in an answer to continue.|
    And close the application