# TBC Automation Project

ტექნოლოგიები
ბიბლიოთეკა              დანიშნულებაJSON 
REST Assured            API ტესტირება
Playwright (Java)       UI ბრაუზერის ავტომატიზაცია
TestNG                  ტესტების მართვა
Jackson                 JSON დესერიალიზაცია
Hamcrest                Assertion-ები


ტესტები
1. moneyTransferTest
Remittance გვერდის ტესტი — ამოწმებს გადარიცხვის სისტემების ინფორმაციას.
რას ამოწმებს:

✅ API სტატუს კოდი 200
✅ სისტემების სახელები UI-ზე ემთხვევა API-ს
✅ ვალუტების ჩამონათვალი UI-ზე ემთხვევა API-ს

Endpoint: GET /api/v1/moneyTransfer/systems?locale=ka-GE

2. treasuryRatesTest
Treasury გვერდის ტესტი — ამოწმებს USD/GEL Forward Rate-ებს.
რას ამოწმებს:

✅ API სტატუს კოდი 200
✅ USD/GEL წყვილი არსებობს
✅ პერიოდები UI-ზე ემთხვევა API-ს
✅ Bid Rate-ები ემთხვევა (სიზუსტე: 0.00001)
✅ Ask Rate-ები ემთხვევა (სიზუსტე: 0.00001)

Endpoint: GET /api/v1/forwardRates/getForwardRates?locale=ka-GE
კონფიგურაცია
Constants.java-ში განსაზღვრულია ყველა URL:
javaBASE_URL        = "https://apigw.tbcbank.ge"
Remittance_URL  = "https://tbcbank.ge/ka/other-products/money-transfers"
Treasury_URL    = "https://tbcbank.ge/ka/treasury-products?amount=100&ccyFrom=USD&ccyTo=GEL"



## Project Structure
```

src/
├── main/java/ge/tbc/
│   ├── data/
│   │   └── Constants.java          # URL-ები და endpoint-ები
│   ├── models/
│   │   ├── RemittanceSegment.java  # Remittance API მოდელი
│   │   └── TreasurySegment.java    # Treasury API მოდელი
│   ├── pages/
│   │   ├── RemittancePage.java     # Playwright locator-ები (Remittance)
│   │   └── TreasuryPage.java       # Playwright locator-ები (Treasury)
│   ├── steps/
│   │   ├── api/
│   │   │   ├── MoneyTransferApiSteps.java   # Remittance API ლოგიკა
│   │   │   └── ForwardRatesApiSteps.java    # Treasury API ლოგიკა
│   │   └── ui/
│   │       ├── RemittancePageSteps.java     # Remittance UI ლოგიკა
│   │       └── TreasuryPageSteps.java       # Treasury UI ლოგიკა
│   └── utils/
│       └── BaseTest.java           # Playwright კონფიგურაცია
└── test/java/ge/tbc/
    └── Tests.java                  # ტესტ კლასი
        



## Prerequisites

- Java 17 
- Maven
- IntelliJ IDEA or any other preferred IDE
  




## Running Tests

To run the tests, use the following command:
```sh 
# ყველა ტესტი
mvn test

# კონკრეტული ტესტი
mvn test -Dtest=Tests#moneyTransferTest
mvn test -Dtest=Tests#treasuryRatesTest
``` using Playwright and POM (Page Object Model). The framework supports UI automation, and the tests are written in Java using TestNG.

